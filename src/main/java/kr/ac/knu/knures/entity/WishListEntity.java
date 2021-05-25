package kr.ac.knu.knures.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
public class WishListEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wno;

    @ManyToOne
    private MemberEntity member;

    @ManyToOne
    private MerchandiseEntity merchandise;
}
