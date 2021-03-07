package com.local.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.local.hrpayroll.entities.Pagamento;

@Service
public class PagamentoService {
	
	public Pagamento getPagamento(long trabalhadorId, int dias) {
		return new Pagamento("Bob", 200.0, dias);
	}
	
}
