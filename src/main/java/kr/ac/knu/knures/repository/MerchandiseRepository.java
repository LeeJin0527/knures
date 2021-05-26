package kr.ac.knu.knures.repository;

import kr.ac.knu.knures.constant.Category;
import kr.ac.knu.knures.constant.LocationCategory;
import kr.ac.knu.knures.constant.State;
import kr.ac.knu.knures.entity.CommunityBoardEntity;
import kr.ac.knu.knures.entity.MerchandiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MerchandiseRepository extends JpaRepository<MerchandiseEntity, Long> {
    // 객체형 인 Long 사용
    // generic 형태에서는 객체를 사용해야 한다. //generic -> Type이 지정되지 않은 것
    // List<Integer> 사용
    List<MerchandiseEntity> findAllByLcategory(LocationCategory locationCategory);
    List<MerchandiseEntity> findAllByCategory(Category category);
    List<MerchandiseEntity> findAllByState(State state);
}
