package com.zup.vacinacao.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.vacinacao.domain.model.Usuario;
import com.zup.vacinacao.domain.model.Vacinacao;

public class VacinacaoDTO {
	
	private Long id;
	
	@NotBlank(message = "{campo.nome.obrigatorio}")
	private String nomeVacina;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataVacinacao;
	
	@NotNull(message = "{campo.usuario.obrigatorio}")
	private Usuario usuario;
	
	public VacinacaoDTO semID() {
		return new VacinacaoDTO(this.getNomeVacina(), this.getUsuario());
	}

	public VacinacaoDTO(String nomeVacina, Usuario usuario) {
		this.nomeVacina = nomeVacina;
		this.usuario = usuario;
	}
	
	public VacinacaoDTO(Vacinacao entity) {
		this.id = entity.getId();
		this.nomeVacina= entity.getNomeVacina();
		this.dataVacinacao = entity.getDataVacinacao();
		this.usuario = entity.getUsuario();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNomeVacina() {
		return nomeVacina;
	}

	public LocalDateTime getDataVacinacao() {
		return dataVacinacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Vacinacao toDomainModel() {
		return new Vacinacao(
				this.getId(),
				this.getNomeVacina(),
				this.getDataVacinacao(),
				this.getUsuario());
	}
	
}
