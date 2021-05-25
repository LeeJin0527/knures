package kr.ac.knu.knures.repository;

import kr.ac.knu.knures.entity.MailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<MailEntity, String> {
}
