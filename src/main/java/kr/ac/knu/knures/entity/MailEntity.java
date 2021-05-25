package kr.ac.knu.knures.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Random;

@Entity
@EntityListeners(value= AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MailEntity extends BaseEntity {
    @Id
    private String address;
    private String num;
    private String title;
    private String message;

}
