package com.local.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.local.hruser.entities.Usuario;
import com.local.hruser.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){		
		Usuario usuario = usuarioService.findById(id);
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<Usuario> findByEmail(@RequestParam(name = "email" , defaultValue = "") String email){		
		Usuario usuario = usuarioService.findByEmail(email);
		return ResponseEntity.ok(usuario);
	}
	
}