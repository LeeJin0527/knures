package kr.ac.knu.knures.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(value= AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MapEntity extends BaseEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String email;
    private String XPoint;
    private String YPoint;

}
