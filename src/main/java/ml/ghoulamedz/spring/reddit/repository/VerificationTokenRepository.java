package ml.ghoulamedz.spring.reddit.repository;

import ml.ghoulamedz.spring.reddit.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    List<VerificationToken> findByToken(VerificationToken token);
}
