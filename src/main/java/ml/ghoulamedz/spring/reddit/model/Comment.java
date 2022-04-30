package ml.ghoulamedz.spring.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Nullable
    @Lob
    private String commentText;
    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "userComments", referencedColumnName = "comments")
    private User commentAuthor;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "postComments", referencedColumnName = "comments")
    //private Post post;
    //private Instant createdDate;
}
