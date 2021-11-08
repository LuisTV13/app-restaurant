package com.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.entity.Platillos;
import com.restaurant.repository.PlatillosRepository;

@Service
public class PlatilloServiceImpl implements PlatilloService {
	
	@Autowired
	private PlatillosRepository platillorepo;

	@Override
	public List<Platillos> listarPlatillos() {
		// TODO Auto-generated method stub
		return platillorepo.findAll();
	}

	@Override
	public List<Platillos> listarPlatillosPorInicial(String detalle_pro) {
		// TODO Auto-generated method stub
		return platillorepo.listarPlatilloPorInicial(detalle_pro);
	}

	@Override
	public Platillos registrarActualizarPlatillo(Platillos obj) {
		// TODO Auto-generated method stub
		return platillorepo.save(obj);
	}

	

	@Override
	public void eliminarPlatillo(int codigo_pro) {
		 platillorepo.deleteById(codigo_pro);
		
	}

	@Override
	public Optional<Platillos> buscarPorId(int codigo_pro) {
		// TODO Auto-generated method stub
		return platillorepo.findById(codigo_pro);
	}

}
