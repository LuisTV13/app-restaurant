package com.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restaurant.entity.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
	// Para Consulta
		@Query("select d from Usuario d where "
				+ "( :p_cod_Ingreso is '' or d.cod_Ingreso = :p_cod_Ingreso ) and "
				+ "( :p_clave_usuario is '' or d.clave_usuario like :p_clave_usuario ) ")
		public abstract List<Usuario> consultaUsuarioPorCodClaveIngreso(
									 	@Param("p_cod_Ingreso") String cod_Ingreso, 
									 	@Param("p_clave_usuario") String clave_usuario);
		
		//Para el CRUD
		/*@Query("select d from Usuario d where "
				+ "( :p_cod_usu is 0 or d.cod_usu = :p_cod_usu ) ")
		public List<Usuario> buscarPorCod_usu(int cod_usu);*/
		
		public List<Usuario> findByEstado(int estado);
		
		@Query("select d from Usuario d where (:nom is '' or d.nombre_usu like :nom)")
		public List<Usuario> findByNombre_usuLike(@Param("nom") String nombre_usu);
	
}
