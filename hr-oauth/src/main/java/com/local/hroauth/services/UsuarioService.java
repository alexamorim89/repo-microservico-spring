package com.local.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.hroauth.entities.Usuario;
import com.local.hroauth.feignclients.UsuarioFeignClient;

@Service
public class UsuarioService {
	
	private static Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioFeignClient usuarioFeignClient;
	
	public Usuario findByEmail(String email) {
		Usuario usuario = this.usuarioFeignClient.findByEmail(email).getBody();
		if(usuario == null) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email nao encontrado");
		}
		logger.info("Email encontrado: " + email);
		return usuario;
	}
	
}
