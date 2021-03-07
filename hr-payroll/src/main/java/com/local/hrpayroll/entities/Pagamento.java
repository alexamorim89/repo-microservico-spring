package com.local.hrpayroll.entities;

import java.io.Serializable;

public class Pagamento implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Double rendaDiaria;
	private Integer dias;
	
	public Pagamento() {
		// TODO Auto-generated constructor stub
	}
	
	public Pagamento(String nome, Double rendaDiaria, Integer dias) {
		this.nome = nome;
		this.rendaDiaria = rendaDiaria;
		this.dias = dias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getRendaDiaria() {
		return rendaDiaria;
	}

	public void setRendaDiaria(Double rendaDiaria) {
		this.rendaDiaria = rendaDiaria;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public double getTotal() {
		return dias * rendaDiaria;
	}
	
}