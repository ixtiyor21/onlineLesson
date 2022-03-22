package com.example.lesson10.entity.university;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 21.03.2022 9:06
 * Project : lesson7
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToOne
    private Address address;

    @ManyToOne
    private Group group;

    @ManyToMany
    private List<Subject> subjects;
}
