package com.local.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.local.hrpayroll.entities.Pagamento;
import com.local.hrpayroll.entities.Trabalhador;

@Service
public class PagamentoService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Pagamento getPagamento(long trabalhadorId, int dias) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(trabalhadorId));
		
		Trabalhador trabalhador = restTemplate.getForObject(workerHost + "/workers/{id}", Trabalhador.class, uriVariables);
		
		return new Pagamento(trabalhador.getNome(), trabalhador.getRendaDiaria(), dias);
	}
	
}
