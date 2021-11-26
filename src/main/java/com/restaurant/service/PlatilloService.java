package com.restaurant.service;

import java.util.List;
import java.util.Optional;

import com.restaurant.entity.Platillos;

public interface PlatilloService   {
	
	public abstract List<Platillos> listarPlatillos();
	
	public abstract List<Platillos> listarPlatillosPorInicial( String detalle_pro);
	
	public abstract Platillos registrarActualizarPlatillo(Platillos obj); 
	
	public abstract void eliminarPlatillo (int codigo_pro);
	
	public Optional<Platillos> buscarPorId(int codigo_pro);
	
	

}
