package br.com.finatofinato.dao.votacao;

import java.util.List;

import br.com.finatofinato.model.Votacao;

public interface VotacaoDao {

	public List<Votacao> listar();
    public Votacao inserir(Votacao votacao);
	public List<Votacao> pesquisar(Votacao votacao);
    
}
