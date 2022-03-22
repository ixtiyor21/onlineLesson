package com.example.lesson10.entity.university;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 21.03.2022 11:38
 * Project : lesson7
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String City;

    private String District;

    private String Street;


}
