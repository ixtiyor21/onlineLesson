package com.example.lesson10.repository;

import com.example.lesson10.entity.university.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 21.03.2022 18:31
 * Project : lesson8
 */
@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Integer> {
    boolean existsByNameAndAndUniversityId(String name,Integer university_id);

    List<Faculty> findAllByUniversityId(Integer universit_id);

}
