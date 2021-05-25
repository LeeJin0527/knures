package kr.ac.knu.knures.repository;

import kr.ac.knu.knures.entity.CommunityBoardEntity;
import kr.ac.knu.knures.entity.CommunityBoardReplyEntity;
import kr.ac.knu.knures.entity.MemberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class CommunityBoardReplyRepositoryTest {
    @Autowired //만들어진 bean 객체를 찾아서 넣어준다.
    private CommunityBoardReplyRepository repository;
    //dependency injection

    //Junit
    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i->{
            long bno = (long)(Math.random() * 100) + 1;
            CommunityBoardEntity board = CommunityBoardEntity.builder().gno(bno).build();
            MemberEntity member = MemberEntity.builder().email("user" + i +"@aaa.com").build();
            CommunityBoardReplyEntity reply = CommunityBoardReplyEntity.builder()
                   .text("Reply..." + i)
                   .boardEntity(board)
                   .memberEntity(member)
                   .build();
            repository.save(reply);
        });
    }
    //@Test
//    public void updateTest(){
//        Optional<CommunityBoardEntity> result = repository.findById(300L);
//
//        if (result.isPresent()){
//            CommunityBoardEntity communityBoardEntity = result.get();
//            communityBoardEntity.changeTitle("Changed Title..");
//            communityBoardEntity.changeContent("Changed Content");
//
//            repository.save(communityBoardEntity);
//
//        }
//    }
}
