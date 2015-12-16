/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finatofinato.bean.resultados;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.finatofinato.dao.resultados.ResultadosDao;
import br.com.finatofinato.model.Restaurante;
import br.com.finatofinato.model.Resultados;
import br.com.finatofinato.model.Votacao;

@Stateless
public class ResultadosBean implements ResultadosRemote, ResultadosLocal {

	@Inject
	private ResultadosDao resultadosDao;
	
	@Override
	public List<Restaurante> restaurantesJaUtilizados(Votacao votacao) {
		return resultadosDao.restaurantesJaUtilizados(votacao);
	}

	@Override
	public List<Resultados> resultadosDepoisDe(Integer data) {
		return resultadosDao.resultadosDepoisDe(data);
	}
	
	@Override
    public Resultados inserirResultado(Resultados resultados) {
    	return resultadosDao.inserirResultado(resultados);
    }
	
}
