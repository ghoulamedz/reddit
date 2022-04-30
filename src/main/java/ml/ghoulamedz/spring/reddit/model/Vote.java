package ml.ghoulamedz.spring.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;
    private VoteType voteType;
    //@NotNull
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "postVotes", referencedColumnName = "votes")
    //private Post post;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "userVotes", referencedColumnName = "votes")
    //private User voteAuthor;
}
