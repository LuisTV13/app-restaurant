package com.restaurant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.Constantes.Constantes;
import com.restaurant.entity.Usuario;
import com.restaurant.service.UsuarioService;

@RestController
@RequestMapping("/rest/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	private UsuarioService Service;

	@GetMapping("/listaUsuarioPorDescripcionLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Usuario>> listaReclamoPorDescripcionLike(@PathVariable("nom") String nombre_usu) {

		List<Usuario> lista = null;
		try {
			if (nombre_usu.equals("todos")) {
				lista = Service.listaUsuarios();
			}else {
				lista = Service.listaPorNombreLike("%"+nombre_usu+"%");	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}

	@PostMapping("/registraUsuario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaProveedor(@RequestBody Usuario obj) {

		
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCod_usu() != 0) {
				salida.put("mensaje", "El codigo del ususario debe ser cero");
				return ResponseEntity.ok(salida);
			}

			List<Usuario> lista = null;

			/*lista = Service.buscarPorCod_usu(obj.getCod_usu());
			if (!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "El Usuario ya existe : " + obj.getCod_usu());
				return ResponseEntity.ok(salida);
			}*/
			lista = Service.listaPorEstado(obj.getEstado());
			if (!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "Registro exitoso" );
				Service.insertaActualizaUsuario(obj);
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
	public ResponseEntity<Map<String, Object>> actualizaUsuario(@RequestBody Usuario obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCod_usu() == 0) {
				salida.put("mensaje", "El ID del reclamo debe ser diferente cero");
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
	
	@PostMapping("/loginUsuario/{cod}/{pass}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> login(@PathVariable("cod") String cod_Ingreso,@PathVariable("pass") String clave_usuario) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Usuario> lista = null;
			lista = Service.consultaUsuarioPorCodClaveIngreso(cod_Ingreso,clave_usuario);
			if (!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "Usuario Logeado");
				return ResponseEntity.ok(salida);
			}else {
				salida.put("mensaje", "Usuario no existe o contraseña incorrecta");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
