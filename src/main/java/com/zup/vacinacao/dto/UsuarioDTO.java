package com.zup.vacinacao.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.vacinacao.domain.model.Usuario;

public class UsuarioDTO {
	
	private Long id;
	
	@NotBlank(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@Email(message = "{campo.email.valido}")
	@NotBlank(message = "{campo.email.obrigatorio}")
	private String email;
	
	@CPF(message = "{campo.cpf.valido}")
	@NotBlank(message = "{campo.cpf.obrigatorio}")
	private String cpf;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	public UsuarioDTO(String nome, String email, String cpf, LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public UsuarioDTO semID() {
		return new UsuarioDTO(this.getNome(), this.getEmail(), this.getCpf(), this.getDataNascimento());
	}
	
	public UsuarioDTO(Usuario entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();
		this.dataNascimento = entity.getDataNascimento();
	}
	
	public Usuario toDomainModel() {
		return new Usuario(
			this.getId(), 
			this.getNome(), 
			this.getEmail(), 
			this.getCpf(),
			this.getDataNascimento());
	}

	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
}
