package br.com.finatofinato.json;

import java.io.Serializable;

public class RestauranteJson implements Serializable {
	private Integer _id;
	private String nome;
	
	public Integer get_id() {
		return _id;
	}
	public void set_id(Integer _id) {
		this._id = _id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
