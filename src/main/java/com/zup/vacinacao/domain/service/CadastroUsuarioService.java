package com.zup.vacinacao.domain.service;

import org.springframework.stereotype.Service;

import com.zup.vacinacao.domain.exception.BusinessException;
import com.zup.vacinacao.domain.model.Usuario;
import com.zup.vacinacao.domain.repository.UsuarioRepository;
import com.zup.vacinacao.dto.UsuarioDTO;

@Service
public class CadastroUsuarioService {
	
	private static final String MENSAGEM_CPF_JA_EXISTENTE = "Este CPF já existe na base de dados";
	private static final String MENSAGEM_EMAIL_JA_EXISTENTE = "Este email já existe na base de dados";
	
	private UsuarioRepository usuarioRepository;
	
	public CadastroUsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository; 
	}
	
	public UsuarioDTO salvar(UsuarioDTO dto) {
		this.validarUsuario(dto);

		Usuario usuario = dto.toDomainModel();
		usuario = usuarioRepository.save(usuario);
		
		return new UsuarioDTO(usuario); 
	}
	
	public void validarUsuario(UsuarioDTO dto) {
		validarCPF(dto);
		validarEmail(dto);
	}
	
	public void validarCPF(UsuarioDTO dto) {
		boolean existirCPF = usuarioRepository.existsByCpf(dto.getCpf());
		
		if (existirCPF) {
			throw new BusinessException(MENSAGEM_CPF_JA_EXISTENTE);
		}
	}
	
	public void validarEmail(UsuarioDTO dto) {
		boolean existirEmail = usuarioRepository.existsByEmail(dto.getEmail());
		
		if (existirEmail) {
			throw new BusinessException(MENSAGEM_EMAIL_JA_EXISTENTE);
		}
	}
	
}
