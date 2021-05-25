package kr.ac.knu.knures.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CommunityBoardReplyDTO {
    //getter setter
    private Long bno; // reply number
    private String text; //내용

    private Long gno; // community board PK
    private String replierEmail; // member PK
    private String replier; // member name
}
