package com.example.lesson10.controller;

import com.example.lesson10.dto.FacultyDto;
import com.example.lesson10.entity.university.Faculty;
import com.example.lesson10.entity.university.University;
import com.example.lesson10.repository.FacultyRepository;
import com.example.lesson10.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 21.03.2022 18:22
 * Project : lesson8
 */
@RestController
@RequestMapping("/faculty")
public class FacultyController {


    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    UniversityRepository universityRepository;


    @GetMapping
    public List<Faculty> getFaculties() {
        return facultyRepository.findAll();
    }

    @PostMapping
    public String addFaculty(@RequestBody FacultyDto facultyDto) {
        boolean exists = facultyRepository.existsByNameAndAndUniversityId(facultyDto.getName(), facultyDto.getUniversityId());
        if (exists)
            return "This university such faculty exist";

        Faculty faculty = new Faculty();
        faculty.setName(facultyDto.getName());
        Optional<University> optionalUniversity = universityRepository.findById(facultyDto.getUniversityId());
        if (optionalUniversity.isEmpty()) {
            return "University not found";
        }
        faculty.setUniversity(optionalUniversity.get());
        facultyRepository.save(faculty);
        return "Faculty added";
    }

    @GetMapping("/byUniversityId/{universityId}")
    public List<Faculty> getFacultiesByUniversityId(@PathVariable Integer universityId) {
        List<Faculty> facultyList = facultyRepository.findAllByUniversityId(universityId);
        return facultyList;
    }

    @DeleteMapping("/{id}")
    public String deleteFaculty(@PathVariable Integer id) {
        try {
            facultyRepository.deleteById(id);
            return "Faculty deleted";
        } catch (Exception e) {
            return "Error in deleting";
        }
    }

    @PutMapping("/{id}")
    public String editFaculty(@PathVariable Integer id,@RequestBody FacultyDto facultyDto){
        Optional<Faculty> facultyOptional = facultyRepository.findById(id);
        if(facultyOptional.isEmpty()){
            return "Faculty not found";
        }
        Faculty faculty = facultyOptional.get();
        faculty.setName(facultyDto.getName());
        Optional<University> universityOptional = universityRepository.findById(facultyDto.getUniversityId());
        if (universityOptional.isEmpty()) {
            return "University not found";
        }
        faculty.setUniversity(universityOptional.get());
        facultyRepository.save(faculty);
        return "Faculty edited";


    }

}
