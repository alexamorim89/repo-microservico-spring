package com.local.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.local.hroauth.entities.Usuario;
import com.local.hroauth.feignclients.UsuarioFeignClient;

@Service
public class UsuarioService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioFeignClient usuarioFeignClient;
	
	
	public Usuario findByEmail(String email) {
		Usuario usuario = this.usuarioFeignClient.findByEmail(email).getBody();
		if(usuario == null) {
			logger.error("Email nao encontrado: " + email);
			throw new IllegalArgumentException("Email nao encontrado");
		}
		logger.info("Email encontrado: " + email);
		return usuario;
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioFeignClient.findByEmail(username).getBody();
		if(usuario == null) {
			logger.error("Email nao encontrado: " + username);
			throw new UsernameNotFoundException("Email nao encontrado");
		}
		logger.info("Email encontrado: " + username);
		return usuario;
	}
	
}