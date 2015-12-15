package br.com.finatofinato.rest.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.com.finatofinato.json.RestauranteJson;
import br.com.finatofinato.json.VotacaoJson;
import br.com.finatofinato.model.Restaurante;
import br.com.finatofinato.model.Votacao;

public class VotacaoConverter implements Serializable {
	private static Gson gson = new Gson();
	
    public static List<VotacaoJson> modelToJson(List<Votacao> models) {
    	List<VotacaoJson> result = new ArrayList<VotacaoJson>();
    	for (Votacao model : models) {
    		VotacaoJson json = new VotacaoJson();
    		json.set_id(model.getId());
    		json.setData(model.getData());
    		json.setEmail(model.getEmail());
    		if (model.getRestaurante() != null) {
    			RestauranteJson restauranteJson = RestauranteConverter.modelToJson(model.getRestaurante());
    			json.setRestaurante(restauranteJson);
    		}
    		result.add(json);
    	}
    	return result;
    }
    
    public static VotacaoJson modelToJson(Votacao model) {
		VotacaoJson json = new VotacaoJson();
		json.set_id(model.getId());
		json.setData(model.getData());
		json.setEmail(model.getEmail());
		if (model.getRestaurante() != null) {
			RestauranteJson restauranteJson = RestauranteConverter.modelToJson(model.getRestaurante());
			json.setRestaurante(restauranteJson);
		}
    	return json;
    }
    
    public static VotacaoJson stringToJson(String document) {
    	VotacaoJson json = gson.fromJson(document, VotacaoJson.class);
    	return json;
    }
    
    public static List<Votacao> jsonToModel(List<VotacaoJson> jsons) {
    	List<Votacao> result = new ArrayList<Votacao>();
    	for (VotacaoJson json : jsons) {
    		Votacao model = new Votacao();
    		model.setId(json.get_id());
    		model.setData(json.getData());
    		model.setEmail(json.getEmail());
    		if (json.getRestaurante() != null) {
	    		Restaurante restaurante = RestauranteConverter.jsonToModel(json.getRestaurante());
	    		model.setRestaurante(restaurante);
    		}
    		result.add(model);
    	}
    	return result;
    }
    
    public static Votacao jsonToModel(VotacaoJson json) {
    	Votacao model = new Votacao();
		model.setId(json.get_id());
		model.setData(json.getData());
		model.setEmail(json.getEmail());
		if (json.getRestaurante() != null) {
			Restaurante restaurante = RestauranteConverter.jsonToModel(json.getRestaurante());
			model.setRestaurante(restaurante);
		}
    	return model;
    }
}
