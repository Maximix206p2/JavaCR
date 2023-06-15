package org.itstep.many_to_many_uni;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "book")
@NoArgsConstructor
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "book")
    private Set<Author> authors = new HashSet<>();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Book [id=" + id + ", title=" + title + "]\n");
        authors.stream().forEach(author -> result.append("\t" + author.toString() + "\n"));
        return result.toString();
    }
}
