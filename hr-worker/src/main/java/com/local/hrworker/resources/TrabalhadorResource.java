package com.local.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.hrworker.entities.Trabalhador;
import com.local.hrworker.services.TrabalhadorService;

@RestController
@RequestMapping(value = "/workers")
public class TrabalhadorResource {
	
	@Autowired
	private TrabalhadorService trabalhadorService;
	
	@GetMapping
	public ResponseEntity<List<Trabalhador>> findAll(){
		List<Trabalhador> list = trabalhadorService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trabalhador> findById(@PathVariable Long id){
		Trabalhador trabalhador = trabalhadorService.findById(id);
		return ResponseEntity.ok(trabalhador);
	}
}
