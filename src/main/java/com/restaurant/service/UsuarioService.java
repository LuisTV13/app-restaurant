package com.restaurant.service;

import java.util.List;
import java.util.Optional;

import com.restaurant.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> listaUsuarios();
	//public abstract List<Usuario> buscarPorCod_usu(int cod_usu);
	public abstract List<Usuario> consultaUsuarioPorCodClaveIngreso(String cod_Ingreso, String clave_usuario);
	public abstract Usuario insertaActualizaUsuario(Usuario obj);
	public abstract Optional<Usuario> buscaPorCod(int cod_usu);
	public abstract List<Usuario> listaPorEstado(int estado);
	public abstract List<Usuario> listaPorNombreLike(String nombre_usu);
}
