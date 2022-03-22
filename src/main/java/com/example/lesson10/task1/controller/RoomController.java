package com.example.lesson10.task1.controller;

import com.example.lesson10.task1.entity.Room;
import com.example.lesson10.task1.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 12:09
 * Project : lesson10
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomRepository repository;

    @GetMapping("/{hotelId}")
    public Page<Room> getRoomsByHotelId(@PathVariable Integer hotelId, @RequestParam Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Room> roomPage = repository.findAllByHotelId(hotelId, pageable);
        return roomPage;
    }
}
