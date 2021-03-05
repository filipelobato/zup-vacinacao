package com.zup.vacinacao.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name= "vacinacao")
public class Vacinacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nomeVacina;
	
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime dataVacinacao;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	public Vacinacao(Long id, String nomeVacina, LocalDateTime dataVacinacao, Usuario usuario) {
		this.id = id;
		this.nomeVacina = nomeVacina;
		this.dataVacinacao = dataVacinacao;
		this.usuario = usuario;
	}

	public Vacinacao(String nomeVacina, Usuario usuario) {
		this.nomeVacina = nomeVacina;
		this.usuario = usuario;
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

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
