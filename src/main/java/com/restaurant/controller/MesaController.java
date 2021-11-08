package com.restaurant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.util.Constantes;
import com.restaurant.entity.Mesa;
import com.restaurant.service.MesaService;

@RestController
@RequestMapping("/restaurante/mesa")
@CrossOrigin(origins ="http://localhost:4200")
public class MesaController {
	
	@Autowired
	private MesaService mesaservice;
	
	/*@GetMapping("/filtroMesas")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listarMesasPorCodigo(
			@RequestParam(value = "m_cod",required = false, defaultValue = "0") int m_cod){		
		Map<String,Object> salida = new HashMap<>();		
		try {
			List<Mesa> lista = mesaservice.listarMesasPorCodigo(m_cod);
			if(CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existe elementos para la consulta");
			} else {
				salida.put("lista", lista);
				salida.put("mensaje", "Se tiene : "+lista.size()+" mesas");
			}			
		}catch (Exception e) {
		    salida.put("mensaje", "Error : "+e.getMessage());			
		}		
		return ResponseEntity.ok(salida);
	}*/
	
	@GetMapping("/listaMesas")
	@ResponseBody
	public ResponseEntity<List<Mesa>> listarMesas(){		
		List<Mesa> lista = mesaservice.listarMesas();	
		return ResponseEntity.ok(lista);		
	}
	
	@PostMapping("/registrarMesa")
	@ResponseBody 
	public ResponseEntity<Map<String, Object>> RegistrarMesa (@RequestBody Mesa obj){	
	    Map<String, Object> salida = new HashMap<>();	    
	    try {
	    	Mesa objsalida = mesaservice.registrarMesa(obj);
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
	
	
	@PostMapping("/desactivarMesa")
	@ResponseBody 
	public ResponseEntity<Map<String, Object>> DesactivarSocio(@RequestBody Mesa obj){	
	    Map<String, Object> salida = new HashMap<>();	    
	    try {
	    	Mesa objsalida = mesaservice.desactivarMesa(obj);
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
