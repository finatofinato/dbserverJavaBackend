package br.com.finatofinato.dao.votacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import br.com.finatofinato.dao.common.EMHelper;
import br.com.finatofinato.model.Votacao;

public class VotacaoDaoImpl extends EMHelper implements VotacaoDao {

    public List<Votacao> listar() {
    	List<Votacao> result = getEntityManager().createQuery("SELECT v FROM Votacao v").getResultList();
    	return result;
    }
    
    public Votacao inserir(Votacao votacao) {
    	getEntityManager().persist(votacao);
    	return votacao;
    }
    
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
	
}
