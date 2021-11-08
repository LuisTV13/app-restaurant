package com.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.entity.Mesa;
import com.restaurant.repository.MesaRepository;

@Service
public class MesaServiceImpl implements MesaService {
	
	@Autowired
	private MesaRepository mesarepo;
	
	@Override
	public Mesa registrarMesa(Mesa obj) {		
		return mesarepo.save(obj);
	}
	/*@Override
	public List<Mesa> listarMesasPorCodigo(int m_cod) {		
		return mesarepo.listarMesasPorCodigo(m_cod);
	}*/

	@Override
	public List<Mesa> listarMesas() {
		return mesarepo.findAll();
	}

	@Override
	public Mesa desactivarMesa(Mesa obj) {		
		return mesarepo.save(obj);
	}
}
