package com.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restaurant.entity.Platillos;

public interface PlatillosRepository extends JpaRepository<Platillos, Integer> {
	
	
	
	@Query(" select p from Platillos p where "
			+ "(:p_nom is '' or p.detalle_pro like :p_nom )")
	public abstract List<Platillos> listarPlatilloPorInicial(@Param ("p_nom") String detalle_pro);
	
	

	
	
	

}
