package org.itstep.many_to_many_uni;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "author")
@NoArgsConstructor
public class Author{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_books",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    private Set<Book> books = new HashSet<>();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Author [id=" + id + ", name=" + name + "]\n");
        books.stream().forEach(book -> result.append("\t" + book.getTitle() + "\n"));
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public void addBook(Book book){
        books.add(book);
    }
}