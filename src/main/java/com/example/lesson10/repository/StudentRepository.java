package com.example.lesson10.repository;

import com.example.lesson10.entity.university.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 11:22
 * Project : lesson10
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Page<Student> findAllByGroup_Faculty_University_Id(Integer universityId, Pageable pageable);

    Page<Student> findAllByGroup_FacultyId(Integer facultyId,Pageable pageable);

    Page<Student> findAllByGroupId(Integer groupId,Pageable pageable);

}
