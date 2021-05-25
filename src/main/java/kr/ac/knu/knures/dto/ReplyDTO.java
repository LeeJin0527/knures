package kr.ac.knu.knures.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ReplyDTO {
    //getter setter
    private Long rno; //reply number
    private String text; //내용

    private Long mno; // merchandise PK
    private String replierEmail; // member PK
    private String replier; // member name
}
