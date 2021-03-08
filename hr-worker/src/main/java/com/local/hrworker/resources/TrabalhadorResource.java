package com.local.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.hrworker.entities.Trabalhador;
import com.local.hrworker.services.TrabalhadorService;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class TrabalhadorResource {
	
	private static Logger logger = LoggerFactory.getLogger(TrabalhadorResource.class);
	
	@Value("${test.config}")
	private String testConfig;

	@Autowired
	private Environment env;
	
	@Autowired
	private TrabalhadorService trabalhadorService;
	
	
	@GetMapping
	public ResponseEntity<List<Trabalhador>> findAll(){
		List<Trabalhador> list = trabalhadorService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trabalhador> findById(@PathVariable Long id){
		
		/*
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Trabalhador trabalhador = trabalhadorService.findById(id);
		return ResponseEntity.ok(trabalhador);
	}
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs(){
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}
	
}
