package com.local.hrworker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.hrworker.entities.Trabalhador;
import com.local.hrworker.repository.TrabalhadorRepository;

@Service
public class TrabalhadorService {

	@Autowired
	private TrabalhadorRepository trabalhadorRepository;
	
	public List<Trabalhador> findAll(){
		return trabalhadorRepository.findAll();
	}

	public Trabalhador findById(Long id) {
		return trabalhadorRepository.findById(id).get();
	}
	
}
