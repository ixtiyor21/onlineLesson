package com.example.lesson10.task1.repository;

import com.example.lesson10.task1.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 12:09
 * Project : lesson10
 */
@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {

    Page<Room> findAllByHotelId(Integer hotelId, Pageable pageable);
}
