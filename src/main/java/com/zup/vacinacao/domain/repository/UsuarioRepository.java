package com.zup.vacinacao.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.vacinacao.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Boolean existsByCpf(String cpf);
	
	Boolean existsByEmail(String email);
	
}
