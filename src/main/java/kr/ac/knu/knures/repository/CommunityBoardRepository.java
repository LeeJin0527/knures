package kr.ac.knu.knures.repository;

import kr.ac.knu.knures.entity.CommunityBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityBoardRepository extends JpaRepository<CommunityBoardEntity, Long> {
    // 객체형 인 Long 사용
    // generic 형태에서는 객체를 사용해야 한다. //generic -> Type이 지정되지 않은 것
    // List<Integer> 사용
}
