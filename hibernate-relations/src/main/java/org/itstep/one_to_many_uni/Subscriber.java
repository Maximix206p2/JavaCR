package org.itstep.one_to_many_uni;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "subscriber")
public class Subscriber {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscriber_id")
    private Set<Phone> phones = new HashSet<>();

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Subscriber [id=" + id + ", firstName=" + firstName + "]\n");

        phones.stream().forEach(phone -> result.append("\t" + phone.toString() + "\n"));
        return result.toString();
    }
}
