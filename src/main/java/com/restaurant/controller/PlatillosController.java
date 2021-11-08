package com.restaurant.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlatillosController {
	
	@RequestMapping("/verCrudPlatillos")
	public String ver() {
		return "crudPlatillos";
	}
	
	@RequestMapping("/consultaCrudPlatillos")
	public String consulta(Strign filtro, HttpSession session) {
		List<Platillos> data = service.buscaporNombre(filtro +"%");
		session.setAttribute("platillos", data)
		return "crudPlatillos";
	}
	
	@RequestMapping("/registraActualizaPlatillos")
	public String registra(Platillos obj) {
		service.registraActualizaPlatillos(obj);
		session.setAttribute("Mensaje", "Registro Existoso")
		return "redirec:salida";
	}
	
	@RequestMapping("/eliminaCrudPlatillos")
	public String elimina(Integer id, HttpSession session) {
		service.eliminaPlatillos(obj);
		session.setAttribute("Mensaje", "Eliminacion Existosa")
		return "redirec:salida";
	}
	
	
	@RequestMapping("/salida")
	public String listarTodos(HttpSession session) {
		List<Platillos> data = service.listarTodos()
		session.setAttribute("platillos", data)
		return "crudPlatillos";
	}
	

}
