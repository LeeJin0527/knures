package kr.ac.knu.knures.repository;

import kr.ac.knu.knures.entity.MapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<MapEntity, String> {
}
