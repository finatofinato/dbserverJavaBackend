package br.com.finatofinato.bean.restaurante;

import java.util.List;

import br.com.finatofinato.model.Restaurante;

public interface RestauranteInterface {

	public List<Restaurante> listar();
    public Restaurante inserir(Restaurante restaurante);
	
}
