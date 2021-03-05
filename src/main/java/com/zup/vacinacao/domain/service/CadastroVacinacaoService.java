package com.zup.vacinacao.domain.service;

import org.springframework.stereotype.Service;

import com.zup.vacinacao.domain.exception.BusinessException;
import com.zup.vacinacao.domain.model.Usuario;
import com.zup.vacinacao.domain.model.Vacinacao;
import com.zup.vacinacao.domain.repository.UsuarioRepository;
import com.zup.vacinacao.domain.repository.VacinacaoRepository;
import com.zup.vacinacao.dto.VacinacaoDTO;

@Service
public class CadastroVacinacaoService {

	private VacinacaoRepository vacinacaoRepository;
	private UsuarioRepository usuarioRepository;
	
	public CadastroVacinacaoService(VacinacaoRepository vacinacaoRepository, UsuarioRepository usuarioRepository) {
		this.vacinacaoRepository = vacinacaoRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	public VacinacaoDTO salvar(VacinacaoDTO dto) {
		Long usuarioId = dto.getUsuario().getId();
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new BusinessException("Usuário não encontrado."));
		
		Vacinacao vacinacao = dto.toDomainModel();		
		vacinacao.setUsuario(usuario);
		
		vacinacao = vacinacaoRepository.save(vacinacao);

		return new VacinacaoDTO(vacinacao); 
	}
}
