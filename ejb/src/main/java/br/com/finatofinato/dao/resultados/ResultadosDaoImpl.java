package br.com.finatofinato.dao.resultados;

import java.util.List;

import br.com.finatofinato.dao.common.EMHelper;
import br.com.finatofinato.model.Restaurante;
import br.com.finatofinato.model.Resultados;
import br.com.finatofinato.model.Votacao;

public class ResultadosDaoImpl extends EMHelper implements ResultadosDao {

	public List<Restaurante> restaurantesJaUtilizados(Votacao votacao) {
		String sql = "SELECT r FROM Restaurante r WHERE r NOT IN (SELECT rs.restaurante FROM Resultados rs WHERE rs.data > :data)";
		List<Restaurante> result = getEntityManager().createQuery(sql).setParameter("data", votacao.getData()).getResultList();
		return result;
	}

	public List<Resultados> resultadosDepoisDe(Integer data) {
		String sql = "SELECT r FROM Resultados r WHERE r.data > :data)";
		List<Resultados> result = getEntityManager().createQuery(sql).setParameter("data", data).getResultList();
		return result;
	}
	
    public Resultados inserirResultado(Resultados resultados) {
    	getEntityManager().persist(resultados);
    	return resultados;
    }
	
}
