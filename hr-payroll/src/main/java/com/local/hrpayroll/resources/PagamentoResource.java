package com.local.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.hrpayroll.entities.Pagamento;
import com.local.hrpayroll.services.PagamentoService;

@RestController
@RequestMapping(value = "/payments")
public class PagamentoResource {

	@Autowired
	private PagamentoService pagamentoService;
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Pagamento> getPayment(
			@PathVariable("workerId") Long id, 
			@PathVariable("days") Integer dias){
		
		Pagamento pagamento = pagamentoService.getPagamento(id, dias);		
		return ResponseEntity.ok(pagamento);
	}
	
}
