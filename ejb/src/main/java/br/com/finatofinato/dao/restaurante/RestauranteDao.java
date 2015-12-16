package br.com.finatofinato.dao.restaurante;

import java.util.List;

import br.com.finatofinato.model.Restaurante;

public interface RestauranteDao {
	
	public List<Restaurante> listar();
    public Restaurante inserir(Restaurante restaurante); 

}
