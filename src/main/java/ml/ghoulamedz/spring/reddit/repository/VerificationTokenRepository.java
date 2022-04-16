package ml.ghoulamedz.spring.reddit.repository;

import ml.ghoulamedz.spring.reddit.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    List<VerificationToken> findByToken(VerificationToken token);
}
