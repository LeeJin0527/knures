package kr.ac.knu.knures.repository;

import kr.ac.knu.knures.entity.CommunityBoardEntity;
import kr.ac.knu.knures.entity.MemberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SpringBootTest
public class CommunityBoardRepositoryTest {
    @Autowired //만들어진 bean 객체를 찾아서 넣어준다.
    private CommunityBoardRepository repository;
    //dependency injection

    //Junit
    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i->{
            MemberEntity member = MemberEntity.builder().email("user" + i +"@aaa.com").build();
            CommunityBoardEntity board = CommunityBoardEntity.builder()
                   .title("Title..." + i)
                   .content("Content..." + i)
                   .writer(member)
                   .build();
            repository.save(board);
        });
    }
    //@Test
    public void updateTest(){
        Optional<CommunityBoardEntity> result = repository.findById(300L);

        if (result.isPresent()){
            CommunityBoardEntity communityBoardEntity = result.get();
            communityBoardEntity.changeTitle("Changed Title..");
            communityBoardEntity.changeContent("Changed Content");

            repository.save(communityBoardEntity);

        }
    }
}
