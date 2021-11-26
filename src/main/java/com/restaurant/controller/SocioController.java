package com.restaurant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cibertec.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.restaurant.entity.Socio;
import com.restaurant.service.SocioService;

@RestController
@RequestMapping("/restaurante/socio")
public class SocioController {
   
	@Autowired
	private SocioService socioservice;
	
	
	@GetMapping("/filtroestado")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listSocioPorEstado(@RequestParam (value = "estado_so", required = false , defaultValue = "") String estado_so){
		
		Map<String,Object> salida = new HashMap<String, Object>();
		
		try {
			List<Socio> lista = socioservice.listarSociosPorEstado(estado_so);
			if(CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existe elementos para la consulta");
			} else {
				salida.put("lista", lista);
				salida.put("mensaje", "Se tiene : "+lista.size()+" socios");
			}
			
		}catch (Exception e) {
		    salida.put("mensaje", "Error : "+e.getMessage());
			
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Socio>> listarSocios(){
		
		List<Socio> lista = socioservice.listarSocios();
		
		
		return ResponseEntity.ok(lista);
		
	}
	
	
	
	
	@PostMapping
	@ResponseBody 
	public ResponseEntity<Map<String, Object>> RegistrarSocio (@RequestBody Socio obj){
	
	    Map<String, Object> salida = new HashMap<>();
	    
	    try {
	     Socio objsalida = socioservice.registrarSocio(obj);
	     if(objsalida == null) {
	    	 salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
	     } else {
	    	 salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
	     }
	    } catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
	     
		return ResponseEntity.ok(salida);
	
	
	}
	
	
	@PostMapping("/desactivar")
	@ResponseBody 
	public ResponseEntity<Map<String, Object>> DesactivarSocio(@RequestBody Socio obj){
	
	    Map<String, Object> salida = new HashMap<>();
	    
	    try {
	     Socio objsalida = socioservice.desactivarSocio(obj);
	     if(objsalida == null) {
	    	 salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
	     } else {
	    	 salida.put("mensaje", "Se desactivó correctamente");
	     }
	    } catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
	     
		return ResponseEntity.ok(salida);
	
	
	}
	
	
}
