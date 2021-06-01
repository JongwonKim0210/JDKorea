package biz.jdkorea.portal.repository;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String boardType;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String authorName;

    private String authorPassword;

    private String saveDate;

    @Builder
    public Board(long id, String boardType, String title, String content, String authorName, String authorPassword, String saveDate) {
        this.id = id;
        this.boardType = boardType;
        this.title = title;
        this.content = content;
        this.authorName = authorName;
        this.authorPassword = authorPassword;
        this.saveDate = saveDate;
    }
}
