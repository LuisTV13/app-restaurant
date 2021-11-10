package com.restaurant.service;

import java.util.List;
import java.util.Optional;

import com.restaurant.entity.Usuario;

public interface UsuarioService {

	public abstract List<Usuario> listaPorCodIngreso(String cod_Ingreso);
	public abstract List<Usuario> consultaUsuarioPorCodClaveIngreso(String cod_Ingreso, String clave_usuario);
	public abstract Usuario insertaActualizaUsuario(Usuario obj);
	public abstract Optional<Usuario> buscaPorCod(int cod_usu);
	public abstract List<Usuario> listaPorNombre(String nombre_usu);
	public abstract List<Usuario> listaPorNombreLike(String nombre_usu);
}
