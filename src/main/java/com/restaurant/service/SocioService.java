package com.restaurant.service;

import java.util.List;

import com.restaurant.entity.Socio;

public interface SocioService {
	
	public abstract List<Socio> listarSocios();
	
	public abstract List<Socio> listarSociosPorEstado( String estado_so );
	
	public abstract Socio registrarSocio(Socio obj);
	
	public abstract Socio desactivarSocio(Socio obj);
	

}
