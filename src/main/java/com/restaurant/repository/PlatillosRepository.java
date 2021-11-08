package com.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;}
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.quey.Param;

import com.restaurant.entity.Platillos;


public interface PlatillosRepository extends JpaRepository<Platillos, Integer> {
	
	@Query("Select a from Platillos a where detalle_pro like :fil")
	public abstract List<Alumno> buscarpornombre(@Param("fil")String filtro);

}
