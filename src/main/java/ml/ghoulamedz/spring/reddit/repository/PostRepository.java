package ml.ghoulamedz.spring.reddit.repository;

import ml.ghoulamedz.spring.reddit.model.Post;
import ml.ghoulamedz.spring.reddit.model.Subreddit;
import ml.ghoulamedz.spring.reddit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    //List<Post> findAllByPostAuthor(User postAuthor);
    //List<Post> findAllBySubreddit(Subreddit subreddit);
}
