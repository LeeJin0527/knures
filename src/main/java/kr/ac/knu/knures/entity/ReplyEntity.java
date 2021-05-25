package kr.ac.knu.knures.entity;

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
@ToString(exclude = "member")
@Builder
public class ReplyEntity extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto - increment
    @Id
    private Long rno;
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private MerchandiseEntity merchandise;

    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity member;
}
