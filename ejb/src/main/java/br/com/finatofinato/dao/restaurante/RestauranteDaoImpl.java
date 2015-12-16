package br.com.finatofinato.dao.restaurante;

import java.util.List;

import br.com.finatofinato.dao.common.EMHelper;
import br.com.finatofinato.model.Restaurante;

public class RestauranteDaoImpl extends EMHelper implements RestauranteDao {

    public List<Restaurante> listar() {
    	List<Restaurante> result = getEntityManager().createQuery("SELECT r FROM Restaurante r").getResultList();
    	return result;
    }
    
    public Restaurante inserir(Restaurante restaurante) {
    	getEntityManager().persist(restaurante);
    	return restaurante;
    }
    
}
