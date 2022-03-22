package com.example.lesson10.controller;

import com.example.lesson10.dto.StudentDto;
import com.example.lesson10.entity.university.Address;
import com.example.lesson10.entity.university.Group;
import com.example.lesson10.entity.university.Student;
import com.example.lesson10.repository.AddressRepository;
import com.example.lesson10.repository.GroupRepository;
import com.example.lesson10.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 11:14
 * Project : lesson10
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    GroupRepository groupRepository;

    //1.Vazirlik
    @GetMapping("/forMinistry")
    public Page<Student> getStudentForMinistry(@RequestParam int page){
        Pageable pageable=PageRequest.of(page,10);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage;
    }

    //2.University
    @GetMapping("/forUniversity/{universityId}")
    public Page<Student> getStudentForUniversity(@PathVariable Integer universityId, @RequestParam int page){
        Pageable pageable=PageRequest.of(page,10);
        Page<Student> studentPage = studentRepository.findAllByGroup_Faculty_University_Id(universityId,pageable);
        return studentPage;
    }


    //3.Faculty dekanat
    @GetMapping("/forFaculty/{facultyId}")
    public Page<Student> getStudentForFaculty(@PathVariable Integer facultyId, @RequestParam int page){
        Pageable pageable=PageRequest.of(page,10);
        Page<Student> studentPage = studentRepository.findAllByGroup_FacultyId(facultyId,pageable);
        return studentPage;
    }

    //4.Group owner
    @GetMapping("/forGroup/{groupId}")
    public Page<Student> getStudentForGroup(@PathVariable Integer groupId, @RequestParam int page){
        Pageable pageable=PageRequest.of(page,10);
        Page<Student> studentPage = studentRepository.findAllByGroupId(groupId,pageable);
        return studentPage;
    }

    @PostMapping()
    public String addStudent(@RequestBody StudentDto studentDto){
        Student student=new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        Optional<Address> addressOptional = addressRepository.findById(studentDto.getAddressId());
        if(addressOptional.isEmpty()){
            return "Address not found";
        }
        student.setAddress(addressOptional.get());

        Optional<Group> groupOptional = groupRepository.findById(studentDto.getGroupId());
        if(groupOptional.isEmpty()){
            return "Group not found";
        }
        student.setGroup(groupOptional.get());
        studentRepository.save(student);
        return "Student added";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isEmpty())
            return "Student not found";
        studentRepository.delete(studentOptional.get());
        return "Student deleted";
    }

    @PutMapping("/{id}")
    public String editStudent(@PathVariable Integer id,@RequestBody StudentDto studentDto){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isEmpty())
            return "Student not found";
        Student student = studentOptional.get();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());

        Optional<Address> addressOptional = addressRepository.findById(studentDto.getAddressId());
        if(addressOptional.isEmpty()){
            return "Address not found";
        }
        student.setAddress(addressOptional.get());

        Optional<Group> groupOptional = groupRepository.findById(studentDto.getGroupId());
        if(groupOptional.isEmpty())
            return "Group not found";
        student.setGroup(groupOptional.get());

        studentRepository.save(student);
        return "Student edited";
    }

}
