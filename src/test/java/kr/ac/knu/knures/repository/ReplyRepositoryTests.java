package kr.ac.knu.knures.repository;

import kr.ac.knu.knures.entity.CommunityBoardEntity;
import kr.ac.knu.knures.entity.MemberEntity;
import kr.ac.knu.knures.entity.MerchandiseEntity;
import kr.ac.knu.knures.entity.ReplyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {
    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private MerchandiseRepository merchandiseRepository;

    @Autowired
    private MemberRepository memberRepository;


    @Test
    public void insertReplyByExistBoardEntity(){
        List<MerchandiseEntity> merchandiseEntities = merchandiseRepository.findAll();
        List<MemberEntity> memberEntities = memberRepository.findAll();

        IntStream.rangeClosed(1,100).forEach(i->{
            int memberIdx = (int)(Math.random()*(memberEntities.size()-1));
            int merchandiseIdx = (int)(Math.random()*(merchandiseEntities.size()-1));

            ReplyEntity reply = ReplyEntity.builder()
                    .text("Reply...." + i)
                    .merchandise(merchandiseEntities.get(merchandiseIdx))
                    .member(memberEntities.get(memberIdx))
                    .build();
            replyRepository.save(reply);
        });
    }
}
