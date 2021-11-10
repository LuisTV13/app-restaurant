package com.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_usu;
	private String nombre_usu;
	private String apellido_usu;
	private String cod_Ingreso;
	private String clave_usuario;
	private String Estado;
	
	
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public int getCod_usu() {
		return cod_usu;
	}
	public void setCod_usu(int cod_usu) {
		this.cod_usu = cod_usu;
	}
	public String getNombre_usu() {
		return nombre_usu;
	}
	public void setNombre_usu(String nombre_usu) {
		this.nombre_usu = nombre_usu;
	}
	public String getApellido_usu() {
		return apellido_usu;
	}
	public void setApellido_usu(String apellido_usu) {
		this.apellido_usu = apellido_usu;
	}
	public String getCod_Ingreso() {
		return cod_Ingreso;
	}
	public void setCod_Ingreso(String cod_Ingreso) {
		this.cod_Ingreso = cod_Ingreso;
	}
	public String getClave_usuario() {
		return clave_usuario;
	}
	public void setClave_usuario(String clave_usuario) {
		this.clave_usuario = clave_usuario;
	}
	

}
