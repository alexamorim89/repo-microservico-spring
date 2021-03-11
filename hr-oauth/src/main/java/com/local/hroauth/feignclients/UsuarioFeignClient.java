package com.local.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.local.hroauth.entities.Usuario;


@Component
@FeignClient(name = "hr-user", path = "/usuarios")
public interface UsuarioFeignClient {

	@GetMapping(value = "/search")
	public ResponseEntity<Usuario> findByEmail(@RequestParam(name = "email" , defaultValue = "") String email);
	
	
}
