package br.com.finatofinato.bean.votacao;

import java.util.List;

import br.com.finatofinato.model.Restaurante;
import br.com.finatofinato.model.Resultados;
import br.com.finatofinato.model.Votacao;

public interface VotacaoInterface {
	
	public List<Votacao> listar();
    public Votacao inserir(Votacao votacao);
    public List<Votacao> pesquisar(Votacao votacao);
    
    public List<Restaurante> restaurantesJaUtilizados(Votacao votacao);
    
    public List<Resultados> resultados(Resultados resultados);
    public Resultados inserirResultado(Resultados resultados);
    
}
