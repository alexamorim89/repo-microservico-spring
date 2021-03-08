package com.local.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.local.hrpayroll.entities.Trabalhador;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface TrabalhadorFeignClient {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trabalhador> findById(@PathVariable Long id);
	
}
