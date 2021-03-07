package com.zup.vacinacao.api.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zup.vacinacao.domain.service.CadastroVacinacaoService;
import com.zup.vacinacao.dto.VacinacaoDTO;

@RestController
@RequestMapping("/vacinacoes")
public class VacinacaoController {

	private CadastroVacinacaoService cadastroVacinacao;
	
	public VacinacaoController(CadastroVacinacaoService cadastroVacinacao) {
		this.cadastroVacinacao = cadastroVacinacao;
	}
	
	@PostMapping
	public ResponseEntity<VacinacaoDTO> adicionar(@RequestBody @Valid VacinacaoDTO dto) {
		VacinacaoDTO vacinacaoDTO = dto.semID();
		
		vacinacaoDTO = cadastroVacinacao.salvar(vacinacaoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(vacinacaoDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(vacinacaoDTO);
	}
	
}
