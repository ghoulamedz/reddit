package ml.ghoulamedz.spring.reddit.repository;

import ml.ghoulamedz.spring.reddit.model.Subreddit;
import ml.ghoulamedz.spring.reddit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SubredditRepository extends JpaRepository<Subreddit,Long> {
    //Optional<Subreddit> findBySubredditName(String subredditName);
    //List<Subreddit> findAllBySubredditAuthor(User subredditAuthor);
}
