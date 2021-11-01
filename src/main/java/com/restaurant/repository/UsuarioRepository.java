package com.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.entity.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

}
