package org.itstep.one_to_many_uni;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "phone")
public class Phone {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @Override
    public String toString() {
        return "Phone [id=" + id + ", number=" + number + "]";
    }
}
