package com.zup.vacinacao.api.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zup.vacinacao.domain.service.CadastroUsuarioService;
import com.zup.vacinacao.dto.UsuarioDTO;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

	private CadastroUsuarioService cadastroUsuario;
	
	public UsuarioController(CadastroUsuarioService cadastroUsuario) {
		this.cadastroUsuario = cadastroUsuario;
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> adicionar(@RequestBody @Valid UsuarioDTO dto) {
		UsuarioDTO usuarioDTO = dto.semID();
		
		usuarioDTO = cadastroUsuario.salvar(usuarioDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuarioDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(usuarioDTO);
	}
}
