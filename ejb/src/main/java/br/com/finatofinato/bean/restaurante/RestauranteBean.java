/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finatofinato.bean.restaurante;

import java.util.List;

import javax.ejb.Stateless;

import br.com.finatofinato.bean.common.EMHelper;
import br.com.finatofinato.model.Restaurante;

@Stateless
public class RestauranteBean extends EMHelper implements RestauranteRemote, RestauranteLocal {

    public List<Restaurante> listar() {
    	List<Restaurante> result = getEntityManager().createQuery("SELECT r FROM Restaurante r").getResultList();
    	return result;
    }
    
    public Restaurante inserir(Restaurante restaurante) {
    	getEntityManager().persist(restaurante);
    	return restaurante;
    }
    
}
