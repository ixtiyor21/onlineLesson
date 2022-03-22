package com.example.lesson10.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 11:53
 * Project : lesson10
 */
@Getter
@Setter
@ToString
public class StudentDto {
    private String firstName;
    private String lastName;
    private Integer addressId;
    private Integer groupId;
}
