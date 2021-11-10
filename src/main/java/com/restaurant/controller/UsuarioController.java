package com.restaurant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.Constantes.Constantes;
import com.restaurant.entity.Usuario;
import com.restaurant.service.UsuarioService;

@RestController
@RequestMapping("/rest/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	private Logger log = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService Service;

	@GetMapping("/consultaUsuarioIngreso")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaPrDniNombreUbigeoConParametros(
			@RequestParam(value = "cod_Ingreso", required = false, defaultValue = "") String cod_Ingreso,
			@RequestParam(value = "clave_usuario", required = false, defaultValue = "") String clave_usuario) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Usuario> lista = Service.consultaUsuarioPorCodClaveIngreso(cod_Ingreso, "%"+clave_usuario);
			if(CollectionUtils.isEmpty(lista)){
				salida.put("mensaje", "Usuario incorrecto");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Usuario loggeado");
			}
		} catch (Exception e) {
			salida.put("mensaje", "Error : " + e.getMessage());
		}
		
		return ResponseEntity.ok(salida);
	}
	

	@PostMapping("/registraUsuario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> registroUsuario(@RequestBody Usuario obj) {
		log.info("==> insertaDocente ==> ID : " + obj.getCod_usu());
		log.info("==> insertaDocente ==> Nombre : " + obj.getNombre_usu());
		log.info("==> insertaDocente ==> Apellido : " + obj.getApellido_usu());
		log.info("==> insertaDocente ==> Codigo Ingreso : " + obj.getCod_Ingreso());
		log.info("==> insertaDocente ==> Clave : " + obj.getClave_usuario());
		log.info("==> insertaDocente ==> Estado : " + obj.getEstado());
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCod_usu() != 0) {
				salida.put("mensaje", "El codigo del usuario debe ser cero");
				return ResponseEntity.ok(salida);
			}

			List<Usuario> lista = null;

			lista = Service.listaPorCodIngreso(obj.getCod_Ingreso());
			if (!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "El codigo de ingreso ya existe : " + obj.getCod_Ingreso());
				return ResponseEntity.ok(salida);
			}
			lista = Service.listaPorNombre(obj.getNombre_usu());
			if (!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "El Nombre ya existe : " + obj.getNombre_usu());
				return ResponseEntity.ok(salida);
			}

			Usuario objSalida = Service.insertaActualizaUsuario(obj);
			if (objSalida == null) {
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

	@PutMapping("/actualizaUsuario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaDocente(@RequestBody Usuario obj) {
		log.info("==> actualizaDocente ==> ID : " + obj.getCod_usu());
		log.info("==> insertaDocente ==> Nombre : " + obj.getNombre_usu());
		log.info("==> insertaDocente ==> Apellido : " + obj.getApellido_usu());
		log.info("==> insertaDocente ==> Codigo Ingreso : " + obj.getCod_Ingreso());
		log.info("==> insertaDocente ==> Clave : " + obj.getClave_usuario());
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCod_usu() == 0) {
				salida.put("mensaje", "El codigo del usuario debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			Usuario objSalida = Service.insertaActualizaUsuario(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizaEstadoUsuario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaEstadoDocente(@RequestBody Usuario obj) {
		log.info("==> actualizaDocente ==> ID : " + obj.getCod_usu());
		log.info("==> insertaDocente ==> Estado : " + obj.getEstado());
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCod_usu() == 0) {
				salida.put("mensaje", "El codigo del usuario debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			
			Optional<Usuario> optUsuario =  Service.buscaPorCod(obj.getCod_usu());
			if (optUsuario.isEmpty()) {
				salida.put("mensaje", "No existe usuario con ese codigo: " + obj.getCod_usu());
				return ResponseEntity.ok(salida);
			}
			
			Usuario objActualiza = optUsuario.get();
			objActualiza.setEstado(obj.getEstado());
			
			Usuario objSalida = Service.insertaActualizaUsuario(objActualiza);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	
}
