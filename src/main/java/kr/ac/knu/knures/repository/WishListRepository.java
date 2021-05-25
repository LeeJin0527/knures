package kr.ac.knu.knures.repository;

import kr.ac.knu.knures.entity.MemberEntity;
import kr.ac.knu.knures.entity.MerchandiseEntity;
import kr.ac.knu.knures.entity.WishListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishListRepository extends JpaRepository<WishListEntity, Long> {
    List<WishListEntity> findAllByMember(MemberEntity member);
    Optional<WishListEntity> findByMemberAndMerchandise(MemberEntity member, MerchandiseEntity merchandise);
}
