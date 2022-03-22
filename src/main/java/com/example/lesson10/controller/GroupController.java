package com.example.lesson10.controller;

import com.example.lesson10.dto.GroupDto;
import com.example.lesson10.entity.university.Faculty;
import com.example.lesson10.entity.university.Group;
import com.example.lesson10.repository.FacultyRepository;
import com.example.lesson10.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 21.03.2022 19:17
 * Project : lesson8
 */
@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    FacultyRepository facultyRepository;

    //Vazirlik uchun
    @GetMapping
    public List<Group> getGroups(){
        return groupRepository.findAll();
    }

    //Universitet xodimi uchun
    @GetMapping("/byUniversityId/{universityId}")
    public List<Group> getGroupsByUniversityId(@PathVariable Integer universityId){
        List<Group> groups = groupRepository.getGroupsByUniversityIdNative(universityId);
        return groups;
    }

    @PostMapping
    public String addGroup(@RequestBody GroupDto groupDto){
        Group group=new Group();
        group.setName(groupDto.getName());

        Optional<Faculty> facultyOptional = facultyRepository.findById((groupDto.getFacultyId()));
        if (facultyOptional.isEmpty()) {
            return "Faculty not found";
        }
        group.setFaculty(facultyOptional.get());
        groupRepository.save(group);
        return "group added";
    }
}
