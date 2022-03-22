package com.example.lesson10.entity.university;

import lombok.*;

import javax.persistence.*;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 21.03.2022 10:00
 * Project : lesson7
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToOne(optional = false)
    private Address address;

}
