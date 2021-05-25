package kr.ac.knu.knures.api.response;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UploadImageResponse {
    private String msg;
    private String imgURL1;
    private String imgURL2;
    private String imgURL3;
}
