package com.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.entity.Mesa;


public interface MesaRepository  extends JpaRepository<Mesa, Integer> {

}
