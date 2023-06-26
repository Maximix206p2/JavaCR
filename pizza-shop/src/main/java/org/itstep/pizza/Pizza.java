package org.itstep.pizza;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pizzas")
public class Pizza {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Integer mass;
    private String desc;
    private Integer price;
}
