package com.example.lesson10.task1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 12:06
 * Project : lesson10
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;

    private Integer floor;

    private String size;

    @ManyToOne
    private Hotel hotel;
}
