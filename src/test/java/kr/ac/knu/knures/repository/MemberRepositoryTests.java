package kr.ac.knu.knures.repository;

import kr.ac.knu.knures.entity.MemberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMembers(){
        IntStream.rangeClosed(1, 100).forEach(i->{
            MemberEntity member = MemberEntity.builder()
                    .email("user" +i +"@aaa.com")
                    .password("1111")
                    .name("USER" + i)
                    .build();
            memberRepository.save(member); // repository.save is upsert(update + insert)
        });
    }
    /*
       JPA / Hibernate / ibatis / MyBatis 같은 친구들은 ORM(Object Relational Mapping) 방식을 이용한다
     */
}
