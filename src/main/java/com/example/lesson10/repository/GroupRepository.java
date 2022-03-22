package com.example.lesson10.repository;

import com.example.lesson10.entity.university.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 21.03.2022 19:18
 * Project : lesson8
 */
@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {
    List<Group> findAllByFaculty_UniversityId(Integer faculty_university_id);

    @Query("select g from groups g where g.faculty.university.id=:universityId")
    List<Group> getGroupsByUniversityId(Integer universityId);

    @Query(value = "select * from groups g join faculty f on f.id=g.faculty_id join university u on u.id=f.university_id where u.id=:universityId",nativeQuery = true)
    List<Group> getGroupsByUniversityIdNative(Integer universityId);
}
