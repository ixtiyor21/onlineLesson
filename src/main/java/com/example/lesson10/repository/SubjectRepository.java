package com.example.lesson10.repository;

import com.example.lesson10.entity.university.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 21.03.2022 14:18
 * Project : lesson8
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    boolean existsByName(String name);
}
