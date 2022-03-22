package com.example.lesson10.repository;

import com.example.lesson10.entity.university.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 21.03.2022 10:33
 * Project : lesson7
 */
@Repository
public interface UniversityRepository extends JpaRepository<University,Integer> {
}
