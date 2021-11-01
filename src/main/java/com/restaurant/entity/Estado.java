package com.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_tipoest;
	private String des_tipo;
	
	
	public int getId_tipoest() {
		return id_tipoest;
	}
	public void setId_tipoest(int id_tipoest) {
		this.id_tipoest = id_tipoest;
	}
	public String getDes_tipo() {
		return des_tipo;
	}
	public void setDes_tipo(String des_tipo) {
		this.des_tipo = des_tipo;
	}


}
