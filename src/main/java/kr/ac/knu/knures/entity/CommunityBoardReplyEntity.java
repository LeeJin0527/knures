package kr.ac.knu.knures.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude ="boardEntity")
public class CommunityBoardReplyEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    private String text;

    @ManyToOne
    CommunityBoardEntity boardEntity;

    @ManyToOne
    MemberEntity memberEntity;
}
