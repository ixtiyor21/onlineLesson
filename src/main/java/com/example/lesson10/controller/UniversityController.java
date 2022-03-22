package com.example.lesson10.controller;

import com.example.lesson10.dto.UniversityDto;
import com.example.lesson10.entity.university.Address;
import com.example.lesson10.entity.university.University;
import com.example.lesson10.repository.AddressRepository;
import com.example.lesson10.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 21.03.2022 10:19
 * Project : lesson7
 */
@RestController
public class UniversityController {

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    AddressRepository addressRepository;

    @RequestMapping(value = "/university",method = RequestMethod.GET)
    public List<University> getUniversities(){
        return universityRepository.findAll();
    }

    @RequestMapping(value = "/university/{id}",method = RequestMethod.GET)
    public University getUniversity(@PathVariable Integer id){
        Optional<University> optionalUniversity = universityRepository.findById(id);
        if (optionalUniversity.isEmpty()) {
            return new University();
        }
        return optionalUniversity.get();
    }

    @RequestMapping(value = "/university",method = RequestMethod.POST)
    public String addUniversity(@RequestBody UniversityDto universityDto){
        Address address=new Address();
        address.setCity(universityDto.getCity());
        address.setDistrict(universityDto.getDistrict());
        address.setStreet(universityDto.getStreet());
        Address saveAddress = addressRepository.save(address);
        University university=new University();
        university.setName(universityDto.getName());
        university.setAddress(saveAddress);
        universityRepository.save(university);
        return "Successfully added";
    }

    @RequestMapping(value = "/university/{id}",method = RequestMethod.DELETE)
    public String deleteUniversity(@PathVariable Integer id){
        Optional<University> optionalUniversity = universityRepository.findById(id);
        if (optionalUniversity.isEmpty()) {
            return "University not found";
        }
        universityRepository.delete(optionalUniversity.get());
        return "Successfully deleted";
    }

    @RequestMapping(value = "/university/{id}",method = RequestMethod.PUT)
    public String editUniversity(@PathVariable Integer id,UniversityDto universityDto){
        Optional<University> optionalUniversity = universityRepository.findById(id);
        if (optionalUniversity.isEmpty()) {
            return "University not found";
        }
        University university=optionalUniversity.get();
        university.setName(universityDto.getName());

        Address address = university.getAddress();
        address.setCity(universityDto.getCity());
        address.setDistrict(universityDto.getDistrict());
        address.setStreet(universityDto.getStreet());
        addressRepository.save(address);

        //university.setAddress(address);
        universityRepository.save(university);
        return "University updated";
    }


}
