package kr.ac.knu.knures.dto;

import kr.ac.knu.knures.constant.Category;
import kr.ac.knu.knures.constant.LocationCategory;
import kr.ac.knu.knures.constant.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MerchandiseDTO {
    //getter setter
    private Long mno; //boardNumber
    private String writer;
    private String writerEmail;
    private String title; //title
    private Long price; //price
    private State state;
    private Category category;
    private LocationCategory lcategory;
    private String content;
    private String imgURL1;
    private String imgURL2;
    private String imgURL3;
    private LocalDateTime regDate;
    private int replyCount;
    private boolean isWish = false;
}
