package com.local.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.hrpayroll.entities.Pagamento;
import com.local.hrpayroll.services.PagamentoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PagamentoResource {

	@Autowired
	private PagamentoService pagamentoService;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Pagamento> getPayment(
			@PathVariable("workerId") Long id, 
			@PathVariable("days") Integer dias){
		
		Pagamento pagamento = pagamentoService.getPagamento(id, dias);		
		return ResponseEntity.ok(pagamento);
	}
	
	public ResponseEntity<Pagamento> getPaymentAlternative(Long id, Integer dias){
		Pagamento pagamento = new Pagamento("Brann", 400.0, dias);
		return ResponseEntity.ok(pagamento);
	}
	
	
}
