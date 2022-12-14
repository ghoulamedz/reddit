package ml.ghoulamedz.spring.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Subreddit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subredditId;
    //@NotBlank(message = "Community name cannot be empty!")
    private String subredditName;
    //@NotBlank(message = "Community description cannot be empty!")
    private String subredditDescription;
    //@OneToMany(fetch = FetchType.LAZY)
    //private List<Post> postList;
    //private Instant createdDate;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "userSubreddits", referencedColumnName = "subreddits")
    //private User subredditAuthor;
}
