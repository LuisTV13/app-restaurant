package com.restaurant.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "boleta")
public class Boleta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idBoleta;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date fecha_boleta;
	private Socio codigo_so;
	private Mesa cod_mesa;
	private Usuario cod_usu;
	
	
	public int getIdBoleta() {
		return idBoleta;
	}
	public void setIdBoleta(int idBoleta) {
		this.idBoleta = idBoleta;
	}
	public Date getFecha_boleta() {
		return fecha_boleta;
	}
	public void setFecha_boleta(Date fecha_boleta) {
		this.fecha_boleta = fecha_boleta;
	}
	public Socio getCodigo_so() {
		return codigo_so;
	}
	public void setCodigo_so(Socio codigo_so) {
		this.codigo_so = codigo_so;
	}
	public Mesa getCod_mesa() {
		return cod_mesa;
	}
	public void setCod_mesa(Mesa cod_mesa) {
		this.cod_mesa = cod_mesa;
	}
	public Usuario getCod_usu() {
		return cod_usu;
	}
	public void setCod_usu(Usuario cod_usu) {
		this.cod_usu = cod_usu;
	}
	
	
	
	
	
}
