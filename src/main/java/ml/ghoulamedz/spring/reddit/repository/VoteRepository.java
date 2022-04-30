package ml.ghoulamedz.spring.reddit.repository;

import ml.ghoulamedz.spring.reddit.model.Post;
import ml.ghoulamedz.spring.reddit.model.User;
import ml.ghoulamedz.spring.reddit.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {
    //List<Vote> findAllByPost(Post post);
    //List<Vote> findAllByVoteAuthor(User voteAuthor);

}
