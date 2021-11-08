package com.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restaurant.entity.Mesa;


public interface MesaRepository  extends JpaRepository<Mesa, Integer> {
	
	/*@Query(" select m from mesa m where "
			+ "(:m_cod is 0 or m.cod_mesa = :m_cod )")
	public abstract List<Mesa> listarMesasPorCodigo(@Param("m_cod") int m_cod);*/
}
