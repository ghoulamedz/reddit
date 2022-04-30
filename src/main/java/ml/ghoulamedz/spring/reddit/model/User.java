package ml.ghoulamedz.spring.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users_db")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank(message = "Username is required!")
    private String username;
    @NotBlank(message = "Password is required!")
    private String password;
    @Email
    @NotEmpty(message = "Email is required!")
    private String email;
    private Instant createdDate;
    private Instant activatedDate;
    private boolean isActivated;
    @OneToMany(mappedBy = "commentAuthor")
    private List<Comment> comments;
    //@OneToMany(fetch = FetchType.LAZY)
    //private Post posts;
    //@OneToMany(fetch = FetchType.LAZY)
    //private Subreddit subreddits;
    //@OneToMany(fetch = FetchType.LAZY)
    //private Vote votes;
}
