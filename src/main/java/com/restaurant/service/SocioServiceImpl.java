package com.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.entity.Socio;
import com.restaurant.repository.SocioRepository;


@Service
public class SocioServiceImpl  implements  SocioService{

	
	@Autowired
	private SocioRepository sociorepo;
	
	
	public Socio registrarSocio(Socio obj) {

		
		return sociorepo.save(obj);
	}





	public List<Socio> listarSociosPorEstado(String estado_so) {
		
		return sociorepo.listarSocioPorEstado(estado_so);
	}





	@Override
	public List<Socio> listarSocios() {
		// TODO Auto-generated method stub
		return sociorepo.findAll();
	}





	@Override
	public Socio desactivarSocio(Socio obj) {
		
		return sociorepo.save(obj);
	}

}
