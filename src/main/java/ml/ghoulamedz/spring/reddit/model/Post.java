package ml.ghoulamedz.spring.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @NotBlank(message = "Post title cannot be empty!")
    private String postTitle;
    @Nullable
    @Lob
    private String postText;
    private Integer voteCount;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "userPosts", referencedColumnName = "posts")
    //private User postAuthor;
    private Instant postDate;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "subredditPosts", referencedColumnName = "postList")
    //private Subreddit subreddit;
    //@OneToMany(fetch = FetchType.LAZY)
    //private List<Comment> comments;
    //@OneToMany(fetch = FetchType.LAZY)
    //private List<Vote> votes;
}