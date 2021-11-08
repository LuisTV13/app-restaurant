package com.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restaurant.entity.Socio;

public interface SocioRepository   extends JpaRepository<Socio, Integer>{
	
	
	@Query(" select s from Socio s where "
			+ "( :s_est is '' or s.estado_so = :s_est )")
	public abstract List<Socio> listarSocioPorEstado(@Param ("s_est") String estado_so  );
	
	
	
	

}
