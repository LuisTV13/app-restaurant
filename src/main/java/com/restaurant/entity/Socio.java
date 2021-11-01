package com.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "socio")
public class Socio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_so;
	private String nombre_so;
	private String apellido_so;
	private String dni_so;
	private String telefono_so;
	
	
	public int getCodigo_so() {
		return codigo_so;
	}
	public void setCodigo_so(int codigo_so) {
		this.codigo_so = codigo_so;
	}
	public String getNombre_so() {
		return nombre_so;
	}
	public void setNombre_so(String nombre_so) {
		this.nombre_so = nombre_so;
	}
	public String getApellido_so() {
		return apellido_so;
	}
	public void setApellido_so(String apellido_so) {
		this.apellido_so = apellido_so;
	}
	public String getDni_so() {
		return dni_so;
	}
	public void setDni_so(String dni_so) {
		this.dni_so = dni_so;
	}
	public String getTelefono_so() {
		return telefono_so;
	}
	public void setTelefono_so(String telefono_so) {
		this.telefono_so = telefono_so;
	}
	

}
