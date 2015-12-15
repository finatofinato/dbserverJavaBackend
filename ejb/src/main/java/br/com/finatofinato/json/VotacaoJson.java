package br.com.finatofinato.json;

import java.io.Serializable;

public class VotacaoJson implements Serializable {
	private Integer _id;
	private Integer data;
	private String email;
	private RestauranteJson restaurante;
	
	public Integer get_id() {
		return _id;
	}
	public void set_id(Integer _id) {
		this._id = _id;
	}
	
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public RestauranteJson getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(RestauranteJson restaurante) {
		this.restaurante = restaurante;
	}
}