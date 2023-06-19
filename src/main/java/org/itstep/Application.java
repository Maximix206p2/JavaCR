package org.itstep;

import org.itstep.many_to_many_uni.Author;
import org.itstep.many_to_many_uni.AuthorRepository;
import org.itstep.many_to_many_uni.Book;
import org.itstep.many_to_many_uni.BookRepository;
import org.itstep.many_to_one_bi.CommentRepository;
import org.itstep.many_to_one_bi.PostRepository;
import org.itstep.one_to_one_bi.PassportRepository;
import org.itstep.one_to_one_bi.PersonRepository;
import org.itstep.one_to_one_uni.AddressRepository;
import org.itstep.one_to_one_uni.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        /*
        passportRepository.findAll().stream().forEach(
                passport -> System.out.println(passport)
        );
        personRepository.findAll().stream().forEach(
                pers -> System.out.println(pers)
        );

        Person person = new Person();
        //person.setFirstName("Ivan");
        Passport passport = new Passport();
        //passport.setNumber("111");
        passport.setPerson(person);
        person.setPassport(passport);
        passportRepository.save(passport);
        personRepository.save(person);

        personRepository.findAll().stream().forEach(
                pers -> System.out.println(pers)
        );

        Post post = new Post();
        Comment comment = new Comment();
        post.addComment(comment);
        comment.setPost(post);
        postRepository.save(post);
        commentRepository.save(comment);

        postRepository.findAll().stream().forEach(
                p -> System.out.println(p));
        commentRepository.findAll().stream().forEach(
                p -> System.out.println(p));
         */

        /*
        employeeRepository.findAll().stream().forEach(
                e -> System.out.println(e));


        //Author author = authorRepository.findById(1L).orElse(null);
        //author.getBooks().remove(bookRepository.findById(1L).orElse(null));

        Author author = new Author();
        author.setName("Author 1");
        author = authorRepository.save(author);

        Author author2 = new Author();
        author2.setName("Author 2");
        author2 = authorRepository.save(author2);

        Book book = new Book();
        book.setTitle("Book");
        book = bookRepository.save(book);

        book.addAuthor(author);
        book.addAuthor(author2);
        author.addBook(book);
        author2.addBook(book);

        authorRepository.save(author);
        authorRepository.save(author2);
        bookRepository.save(book);

        bookRepository.findAll().stream().forEach(
                b -> System.out.println(b));

        authorRepository.findAll().stream().forEach(
                a -> System.out.println(a));

        addressRepository.findByCity("Vitebsk").stream().forEach(
                a -> System.out.println(a));
        addressRepository.findByCityAndStreet("Vitebsk", "Stroiteley st.").stream().forEach(
                a -> System.out.println(a));
        addressRepository.findTop5ByCity("Vitebsk").stream().forEach(
                a -> System.out.println(a));
                */

        employeeRepository.findByCity3("Vitebsk").stream().forEach(
                e -> System.out.println(e));
    }
}

/*
cmd
netstat -ano | findstr 8080
taskkill /F /PID 3388
 */
