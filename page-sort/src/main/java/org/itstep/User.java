package org.itstep;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String surname;
    @Column(nullable = false)
    String name;
    String patronymic;
    String login;
    String password;
}
