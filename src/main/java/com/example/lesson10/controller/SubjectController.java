package com.example.lesson10.controller;

import com.example.lesson10.entity.university.Subject;
import com.example.lesson10.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 21.03.2022 14:16
 * Project : lesson8
 */
@RestController
@RequestMapping(value = "/subject")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody Subject subject){
        boolean existsByName = subjectRepository.existsByName(subject.getName());
        if (existsByName) {
            return "This subject already exist";
        }
        subjectRepository.save(subject);
        return "Subject added";
    }

    @GetMapping()
    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

}
