package com.local.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.hruser.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findByEmail(String email);
	
}
