package kr.ac.knu.knures.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MailDTO {
    private String address;
    private String title;
    private String message;
    private String num;
}