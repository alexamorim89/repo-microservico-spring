package com.local.hruser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.hruser.entities.Usuario;
import com.local.hruser.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	
}
