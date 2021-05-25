package kr.ac.knu.knures.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CommunityBoardDTO<DTO, EN> {

    //getter setter
    private Long gno; //boardNumber
    private String content; //내용
    private String writerName; // 작성자 name
    private String writerEmail; // email
    private String title;
    private Long replyCount;
    private LocalDateTime regDate, modDate;
}
