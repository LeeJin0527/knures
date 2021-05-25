package kr.ac.knu.knures.repository;

import kr.ac.knu.knures.entity.MerchandiseEntity;
import kr.ac.knu.knures.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
    List<ReplyEntity> findAllByMerchandise(MerchandiseEntity merchandiseEntity);
}
