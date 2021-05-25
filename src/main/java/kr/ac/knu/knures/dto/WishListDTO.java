package kr.ac.knu.knures.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class WishListDTO {
    private Long wno; //Wishlist PK

    private String email; //member PK
    private Long mno; //merchandise PK
}
