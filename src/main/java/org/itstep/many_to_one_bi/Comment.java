package org.itstep.many_to_one_bi;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
