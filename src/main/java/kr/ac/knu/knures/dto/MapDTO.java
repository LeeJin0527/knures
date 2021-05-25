package kr.ac.knu.knures.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MapDTO {
    private String name;
    private String email;
    private String XPoint;
    private String YPoint;
}