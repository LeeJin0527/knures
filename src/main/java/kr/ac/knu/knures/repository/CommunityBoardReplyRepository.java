package kr.ac.knu.knures.repository;

import kr.ac.knu.knures.entity.CommunityBoardReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityBoardReplyRepository extends JpaRepository<CommunityBoardReplyEntity, Long> {
    List<CommunityBoardReplyEntity> findAllByBoardEntity_Gno(Long gno);
    void deleteByBno(Long bno);
}
