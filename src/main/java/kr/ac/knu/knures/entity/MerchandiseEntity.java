package kr.ac.knu.knures.entity;

import kr.ac.knu.knures.constant.Category;
import kr.ac.knu.knures.constant.LocationCategory;
import kr.ac.knu.knures.constant.State;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(value= AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude ="writer")
@Builder
public class MerchandiseEntity extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto - increment
    @Id
    private Long mno; //boardNumber
    @Column (length = 100, nullable = false)
    private String title;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private LocationCategory lcategory;
    @Column
    private Long price; //가격
    @Column(length = 1000 , nullable = false)
    private String content; //글
    @Enumerated(EnumType.STRING)
    private State state; //상태 (대여 나눔 판매)
    @Column(length = 500, nullable = true)
    private String imgURL1; //상태 (대여 나눔 판매)
    @Column(length = 500, nullable = true)
    private String imgURL2; //상태 (대여 나눔 판매)
    @Column(length = 500, nullable = true)
    private String imgURL3; //상태 (대여 나눔 판매)

    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity writer;
}
