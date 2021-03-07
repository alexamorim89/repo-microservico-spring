package com.local.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.hrpayroll.entities.Pagamento;
import com.local.hrpayroll.entities.Trabalhador;
import com.local.hrpayroll.feignclients.TrabalhadorFeignClient;

@Service
public class PagamentoService {
	
	@Autowired
	private TrabalhadorFeignClient trabalhadorFeignClient;
	
	public Pagamento getPagamento(long trabalhadorId, int dias) {
		
		Trabalhador trabalhador = trabalhadorFeignClient.findById(trabalhadorId).getBody();		
		return new Pagamento(trabalhador.getNome(), trabalhador.getRendaDiaria(), dias);
	}
	
}
