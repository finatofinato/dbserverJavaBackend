package br.com.finatofinato.bean.votacao;

import java.util.List;

import br.com.finatofinato.model.Votacao;

public interface VotacaoInterface {
	
	public List<Votacao> listar();
    public Votacao inserir(Votacao votacao);
    public List<Votacao> pesquisar(Votacao votacao);
    
}
