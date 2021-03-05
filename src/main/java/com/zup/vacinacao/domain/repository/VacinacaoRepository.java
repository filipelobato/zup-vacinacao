package com.zup.vacinacao.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.vacinacao.domain.model.Vacinacao;

public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long> { 
	
}
