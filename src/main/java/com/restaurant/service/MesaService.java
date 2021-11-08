package com.restaurant.service;

import java.util.List;

import com.restaurant.entity.Mesa;

public interface MesaService  {

	public abstract List<Mesa> listarMesas();
	
	public abstract List<Mesa> listarMesasPorCodigo(int m_cod);
	
	public abstract Mesa registrarMesa(Mesa obj);
	
	public abstract Mesa desactivarMesa(Mesa obj);

}
