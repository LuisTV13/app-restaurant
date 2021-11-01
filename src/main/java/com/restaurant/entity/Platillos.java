package com.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "platillos")
public class Platillos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_pro;
	private String detalle_pro;
	private int stock_pro;
	private double precioxuni_pro;
	
	
	
	
	public int getCodigo_pro() {
		return codigo_pro;
	}
	public void setCodigo_pro(int codigo_pro) {
		this.codigo_pro = codigo_pro;
	}
	public String getDetalle_pro() {
		return detalle_pro;
	}
	public void setDetalle_pro(String detalle_pro) {
		this.detalle_pro = detalle_pro;
	}
	public int getStock_pro() {
		return stock_pro;
	}
	public void setStock_pro(int stock_pro) {
		this.stock_pro = stock_pro;
	}
	public double getPrecioxuni_pro() {
		return precioxuni_pro;
	}
	public void setPrecioxuni_pro(double precioxuni_pro) {
		this.precioxuni_pro = precioxuni_pro;
	}


}
