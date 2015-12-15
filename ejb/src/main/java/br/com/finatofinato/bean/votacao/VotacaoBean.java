/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finatofinato.bean.votacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.finatofinato.bean.common.EMHelper;
import br.com.finatofinato.model.Restaurante;
import br.com.finatofinato.model.Resultados;
import br.com.finatofinato.model.Votacao;

@Stateless
public class VotacaoBean extends EMHelper implements VotacaoRemote, VotacaoLocal {

    public List<Votacao> listar() {
    	List<Votacao> result = getEntityManager().createQuery("SELECT v FROM Votacao v").getResultList();
    	return result;
    }
    
    public Votacao inserir(Votacao votacao) {
    	getEntityManager().persist(votacao);
    	return votacao;
    }
    
	@Override
	public List<Votacao> pesquisar(Votacao votacao) {
		StringBuilder sql = new StringBuilder("SELECT v FROM Votacao v WHERE 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		
		if (votacao.getId() != null) {
			sql.append("AND v.id = :id ");
			params.put("id", votacao.getId());
		}
		if (votacao.getData() != null) {
			sql.append("AND v.data = :data ");
			params.put("data", votacao.getData());
		}
		if (votacao.getEmail() != null) {
			sql.append("AND v.email = :email ");
			params.put("email", votacao.getEmail());
		}
		if (votacao.getRestaurante() != null) {
			sql.append("AND v.restaurante.id = :restauranteId ");
			params.put("restauranteId", votacao.getRestaurante().getId());
		}
		
		Query query = getEntityManager().createQuery(sql.toString());
		setParameters(query, params);
		List<Votacao> result = query.getResultList();
		return result;
	}
	
	@Override
	public List<Restaurante> restaurantesJaUtilizados(Votacao votacao) {
		String sql = "SELECT r FROM Restaurante r WHERE r NOT IN (SELECT rs.restaurante FROM Resultados rs WHERE rs.data > :data)";
		List<Restaurante> result = getEntityManager().createQuery(sql).setParameter("data", votacao.getData()).getResultList();
		return result;
	}

	@Override
	public List<Resultados> resultados(Resultados resultados) {
		String sql = "SELECT r FROM Resultados r WHERE r.data > :data)";
		List<Resultados> result = getEntityManager().createQuery(sql).setParameter("data", resultados.getData()).getResultList();
		return result;
	}
	
	@Override
    public Resultados inserirResultado(Resultados resultados) {
    	getEntityManager().persist(resultados);
    	return resultados;
    }
	
}
