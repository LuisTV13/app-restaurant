package com.restaurant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.cibertec.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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
	

	@PostMapping("/registraProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaAlumno(@RequestBody Platillos obj) {
		
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCodigo_pro() == 0) {
				Platillos objSalida = platilloservice.registrarActualizarPlatillo(obj);
				if (objSalida == null) {
					salida.put("mensaje","Error al registrar");
				} else {
					salida.put("mensaje", "Exito al registrar");
				}	
			}else {
				salida.put("mensaje", "El IdProveedor debe ser cero");
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje","Error al registrar");
		}
		return ResponseEntity.ok(salida);
	}
	@PutMapping("/actualizaProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaProducto(@RequestBody Platillos obj) {
		
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCodigo_pro() != 0) {
				Platillos objSalida = platilloservice.registrarActualizarPlatillo(obj);
				if (objSalida == null) {
					salida.put("mensaje", "Error al actualizar");
				} else {
					salida.put("mensaje", "Se actualizo correctamente");
				}	
			}else {
				salida.put("mensaje", "El ID del Producto debe ser diferente cero");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje",  "Error al actualizar");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Platillos>> listProveedor(){
		List<Platillos> list = platilloservice.listarPlatillos();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/listaProductoPorId/{id}")
	@ResponseBody
	public ResponseEntity<Platillos> listaAlumnoPorId(@PathVariable("id") int idProducto){
		Platillos objProducto = null;
		try {
			 Optional<Platillos> optProducto =  platilloservice.buscarPorId(idProducto);
			 if (optProducto.isEmpty()) {
				 objProducto = new Platillos(); 
			 }else {
				 objProducto = optProducto.get();
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(objProducto);
	}
	
	@DeleteMapping("/eliminarProductoPorId/{id}")
	@ResponseBody
	public ResponseEntity<Boolean> eliminarProducto(@PathVariable("id") int idProducto){
		platilloservice.eliminarPlatillo(idProducto);
		return ResponseEntity.ok(!(platilloservice.buscarPorId(idProducto)!=null));
	}
	
	

}
