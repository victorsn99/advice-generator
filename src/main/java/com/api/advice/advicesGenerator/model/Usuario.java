package com.api.advice.advicesGenerator.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Conselho> conselhos;

	public Usuario() {
	}

	public Usuario(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conselho> getConselhos() {
		return conselhos;
	}

	public void setConselhos(List<Conselho> conselhos) {
		this.conselhos = conselhos;
	}
}
