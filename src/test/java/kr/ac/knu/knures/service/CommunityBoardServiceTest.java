package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.CommunityBoardDTO;
import kr.ac.knu.knures.dto.PageRequestDTO;
import kr.ac.knu.knures.dto.PageResultDTO;
import kr.ac.knu.knures.entity.CommunityBoardEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommunityBoardServiceTest {
    @Autowired
    private CommunityBoardService service;


    //@Test
    public void testRegister(){
        CommunityBoardDTO communityBoardDTO = CommunityBoardDTO.builder()
                .title("Sample Title..")
                .content("Sample Content..")
                .writerName("Writer name")
                .writerEmail("wrtier@naver.com")
                .build();
        service.register(communityBoardDTO);
    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<CommunityBoardDTO, CommunityBoardEntity> resultDTO = service.getList(pageRequestDTO);

        for(CommunityBoardDTO communityBoardDTO : resultDTO.getDtoList()){
            System.out.println(communityBoardDTO);
        }

        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}
