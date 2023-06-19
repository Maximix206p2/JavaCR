package org.itstep.one_to_one_bi;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToOne(mappedBy="person")
    private Passport passport;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", number=" + passport.getNumber() +
                '}';
    }
}
