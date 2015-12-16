package br.com.finatofinato.bean.resultados;

import java.util.List;

import br.com.finatofinato.model.Restaurante;
import br.com.finatofinato.model.Resultados;
import br.com.finatofinato.model.Votacao;

public interface ResultadosInterface {
	
    public List<Restaurante> restaurantesJaUtilizados(Votacao votacao);
    
    public List<Resultados> resultadosDepoisDe(Integer data);
    public Resultados inserirResultado(Resultados resultados);
    
}
