package com.local.hrpayroll.entities;

import java.io.Serializable;

public class Trabalhador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;
	
	private Double rendaDiaria;

	public Trabalhador() {
		// TODO Auto-generated constructor stub
	}
	
	public Trabalhador(Long id, String nome, Double rendaDiaria) {
		this.id = id;
		this.nome = nome;
		this.rendaDiaria = rendaDiaria;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabalhador other = (Trabalhador) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}