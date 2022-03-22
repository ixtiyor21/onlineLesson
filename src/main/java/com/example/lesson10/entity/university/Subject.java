package com.example.lesson10.entity.university;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 21.03.2022 10:03
 * Project : lesson7
 */

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name;

}
