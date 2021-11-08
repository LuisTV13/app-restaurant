package com.restaurant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.Constantes.Constantes;
import com.restaurant.entity.Platillos;
import com.restaurant.service.PlatilloService;

@RestController
@RequestMapping("/restaurante/platillos")
public class PlatillosController {
	
	@Autowired 
	private PlatilloService platilloservice; 
	
	
	@GetMapping("/filtroinicial")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listarPlatillosPorInicial(@RequestParam (value = "detalle_pro", required = false, defaultValue = "") String detalle_pro){
		
		Map<String,Object> salida = new HashMap<String, Object>(); 
		
		try {
			List<Platillos> lista = platilloservice.listarPlatillosPorInicial(detalle_pro+"%");
			
			if(CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen elementos para la consulta");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Se tienen : " +lista.size() + " platillos");
			}
		}catch (Exception e) {
		  salida.put("mensaje", "Error : "+e.getMessage());
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Platillos>> listarPlatillos(){
		List<Platillos> lista = platilloservice.listarPlatillos();
		
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> RegistrarActualizarPlatillo(@RequestBody Platillos obj){
		
		Map<String, Object> salida = new HashMap<>();
		
		try {
			Platillos objsalida = platilloservice.registrarActualizarPlatillo(obj);
			if(objsalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			} 
			
		}catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminar/{paramId}")
	@ResponseBody
	public ResponseEntity<Platillos> eliminarPlatillo(@PathVariable("paramId") int codigo_pro){
		
		Optional<Platillos> optPlatillo = platilloservice.buscarPorId(codigo_pro);
		
		if(optPlatillo.isPresent()) {
			platilloservice.eliminarPlatillo(codigo_pro);
			
			Optional<Platillos> optSalida = platilloservice.buscarPorId(codigo_pro);
			
			if(optSalida.isPresent()) {
				return ResponseEntity.badRequest().build();
			}else {
				return ResponseEntity.ok(optPlatillo.get());
			}
		}else {
			return ResponseEntity.badRequest().build();
		}
		
	
	}	

}
