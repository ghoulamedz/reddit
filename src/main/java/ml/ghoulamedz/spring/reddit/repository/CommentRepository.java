package ml.ghoulamedz.spring.reddit.repository;

import ml.ghoulamedz.spring.reddit.model.Comment;
import ml.ghoulamedz.spring.reddit.model.Post;
import ml.ghoulamedz.spring.reddit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    //List<Comment> findAllByCommentAuthor(User commentAuthor);
    //List<Comment> findAllByPost(Post post);
}
