package com.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restaurant.entity.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
	// Para Consulta
		@Query("select d from tb_usuario d where "
				+ "( :p_cod_Ingreso is '' or d.cod_Ingreso = :p_cod_Ingreso ) and "
				+ "( :p_clave_usuario is '' or d.clave_usuario like :p_clave_usuario ) ")
		public abstract List<Usuario> consultaUsuarioPorCodClaveIngreso(
									 	@Param("p_cod_Ingreso") String cod_Ingreso, 
									 	@Param("p_clave_usuario") String clave_usuario);
		
		//Para el CRUD
		public List<Usuario> findByCod_Ingreso(String cod_Ingreso);
		public List<Usuario> findByNombre_usu(String nombre_usu);
		public List<Usuario> findByNombre_usuLike(String nombre_usu);
	
}
