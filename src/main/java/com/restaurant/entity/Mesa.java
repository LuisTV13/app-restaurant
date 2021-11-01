package com.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mesa")
public class Mesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_mesa;
	private int capacidad;
	private int id_tipoest;
	
	public int getCod_mesa() {
		return cod_mesa;
	}
	public void setCod_mesa(int cod_mesa) {
		this.cod_mesa = cod_mesa;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getId_tipoest() {
		return id_tipoest;
	}
	public void setId_tipoest(int id_tipoest) {
		this.id_tipoest = id_tipoest;
	}
	

	
	
	
	
}
