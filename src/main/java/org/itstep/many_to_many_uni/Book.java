package org.itstep.many_to_many_uni;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
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

    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER) //Имя объекта
    private Set<Author> authors = new HashSet<>();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Book [id=" + id + ", title=" + title + "]\n");
        authors.stream().forEach(author -> result.append("\t" + author.getName() + "\n"));
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    public void addAuthor(Author author){
        authors.add(author);
    }
}
