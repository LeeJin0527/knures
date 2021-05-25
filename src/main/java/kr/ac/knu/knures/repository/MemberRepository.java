package kr.ac.knu.knures.repository;

import kr.ac.knu.knures.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
}
