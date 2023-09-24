package com.api.advice.advicesGenerator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Os atributos desse modelo foram gerados automaticamente pelo site
 * jsonschema2pojo.org. Para isso, usamos o JSON de retorno da API do ViaCEP.
 * 
 * @see <a href="https://www.jsonschema2pojo.org">jsonschema2pojo.org</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 */
@Entity
public class Conselho {

	@Id
	private Long id;

	@Column
	private String conselho;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Conselho() {
	}

	public Conselho(String conselho) {
		this.conselho = conselho;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConselho() {
		return conselho;
	}

	public void setConselho(String conselho) {
		this.conselho = conselho;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
