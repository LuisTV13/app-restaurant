package com.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.entity.Usuario;
import com.restaurant.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public List<Usuario> listaUsuarios() {
		return repository.findAll();
	}
/*
	@Override
	public List<Usuario> buscarPorCod_usu(int cod_usu) {
		return repository.buscarPorCod_usu(cod_usu);
	}*/
	@Override
	public List<Usuario> consultaUsuarioPorCodClaveIngreso(String cod_Ingreso, String clave_usuario) {
		return repository.consultaUsuarioPorCodClaveIngreso(cod_Ingreso,clave_usuario);
	}
	@Override
	public Usuario insertaActualizaUsuario(Usuario obj) {
		return repository.save(obj);
	}
	@Override
	public Optional<Usuario> buscaPorCod(int cod_usu) {
		return repository.findById(cod_usu);
	}
	@Override
	public List<Usuario> listaPorEstado(int estado) {
		return repository.findByEstado(estado);
	}
	@Override
	public List<Usuario> listaPorNombreLike(String nombre_usu) {
		return repository.findByNombre_usuLike(nombre_usu);
	}
}
