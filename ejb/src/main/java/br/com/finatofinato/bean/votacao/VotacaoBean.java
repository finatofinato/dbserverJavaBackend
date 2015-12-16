/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finatofinato.bean.votacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.finatofinato.dao.votacao.VotacaoDao;
import br.com.finatofinato.model.Votacao;

@Stateless
public class VotacaoBean implements VotacaoRemote, VotacaoLocal {

	@Inject
	private VotacaoDao votacaoDao;
	
    public List<Votacao> listar() {
    	return votacaoDao.listar();
    }
    
    public Votacao inserir(Votacao votacao) {
    	return votacaoDao.inserir(votacao);
    }
    
	@Override
	public List<Votacao> pesquisar(Votacao votacao) {
		return votacaoDao.pesquisar(votacao);
	}
	
}
