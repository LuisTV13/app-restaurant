package com.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.entity.Platillos;

public interface PlatillosRepository extends JpaRepository<Platillos, Integer> {

}
