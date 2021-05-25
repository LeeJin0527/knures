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
public class MemberEntity extends BaseEntity {
    @Id
    private String email;
    private String password;
    private String name;
}
