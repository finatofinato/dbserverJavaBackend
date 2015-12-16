/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finatofinato.bean.restaurante;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.finatofinato.dao.restaurante.RestauranteDao;
import br.com.finatofinato.model.Restaurante;

@Stateless
public class RestauranteBean implements RestauranteRemote, RestauranteLocal {
	
	@Inject
	private RestauranteDao restauranteDao;
	
    public List<Restaurante> listar() {
    	return restauranteDao.listar();
    }
    
    public Restaurante inserir(Restaurante restaurante) {
    	return restauranteDao.inserir(restaurante);
    }
    
}
