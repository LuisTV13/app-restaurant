
package com.restaurant.entity;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detboleta")
public class DetBoleta implements Serializable {



	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ManyToOne
	@JoinColumn(name = "idBoleta")
	private Boleta idBoleta;
	@Id
	@ManyToOne
	@JoinColumn(name = "codigo_pro")
	private Platillos codigo_pro;
	private int cantidad;
	private double preciobol;
	
	
	public Boleta getIdBoleta() {
		return idBoleta;
	}
	public void setIdBoleta(Boleta idBoleta) {
		this.idBoleta = idBoleta;
	}
	public Platillos getCodigo_pro() {
		return codigo_pro;
	}
	public void setCodigo_pro(Platillos codigo_pro) {
		this.codigo_pro = codigo_pro;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPreciobol() {
		return preciobol;
	}
	public void setPreciobol(double preciobol) {
		this.preciobol = preciobol;
	}
}