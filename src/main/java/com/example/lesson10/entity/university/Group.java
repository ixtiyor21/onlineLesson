package com.example.lesson10.entity.university;

import lombok.*;

import javax.persistence.*;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 21.03.2022 9:23
 * Project : lesson7
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Faculty faculty;

}
