package org.itstep;

import org.itstep.many_to_many_uni.Author;
import org.itstep.many_to_many_uni.AuthorRepository;
import org.itstep.many_to_many_uni.BookRepository;
import org.itstep.many_to_one_bi.Comment;
import org.itstep.many_to_one_bi.CommentRepository;
import org.itstep.many_to_one_bi.Post;
import org.itstep.many_to_one_bi.PostRepository;
import org.itstep.one_to_one_bi.PassportRepository;
import org.itstep.one_to_one_bi.PersonRepository;
import org.itstep.one_to_one_uni.Address;
import org.itstep.one_to_one_uni.AddressRepository;
import org.itstep.one_to_one_uni.Employee;
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
         */

        Author author = authorRepository.findById(1L).orElse(null);
        author.getBooks().remove(bookRepository.findById(1L).orElse(null));

        bookRepository.findAll().stream().forEach(
                b -> System.out.println(b));

        authorRepository.findAll().stream().forEach(
                a -> System.out.println(a));
    }
}

/*
cmd
netstat -ano | findstr 8080
taskkill /F /PID 3388
 */
