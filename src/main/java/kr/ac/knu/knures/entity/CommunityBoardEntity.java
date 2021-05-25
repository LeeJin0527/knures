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
@ToString
@Builder
public class CommunityBoardEntity extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto - increment
    @Id
    private Long gno; //boardNumber
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 1000, nullable = false)
    private String content; //내용

    public void changeTitle(String title){
        this.title = title;
    }
    public void changeContent(String content){
        this.content = content;
    }

    @ManyToOne
    private MemberEntity writer;
}
