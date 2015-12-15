package br.com.finatofinato.rest.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.com.finatofinato.json.RestauranteJson;
import br.com.finatofinato.json.ResultadosJson;
import br.com.finatofinato.model.Restaurante;
import br.com.finatofinato.model.Resultados;

public class ResultadosConverter implements Serializable {
	private static Gson gson = new Gson();
	
    public static List<ResultadosJson> modelToJson(List<Resultados> models) {
    	List<ResultadosJson> result = new ArrayList<ResultadosJson>();
    	for (Resultados model : models) {
    		ResultadosJson json = new ResultadosJson();
    		json.set_id(model.getId());
    		json.setData(model.getData());
    		if (model.getRestaurante() != null) {
	    		RestauranteJson restauranteJson = RestauranteConverter.modelToJson(model.getRestaurante());
	    		json.setRestaurante(restauranteJson);
    		}
    		result.add(json);
    	}
    	return result;
    }
    
    public static ResultadosJson modelToJson(Resultados model) {
    	ResultadosJson json = new ResultadosJson();
		json.set_id(model.getId());
		json.setData(model.getData());
		if (model.getRestaurante() != null) {
			RestauranteJson restauranteJson = RestauranteConverter.modelToJson(model.getRestaurante());
			json.setRestaurante(restauranteJson);
		}
    	return json;
    }
    
    public static ResultadosJson stringToJson(String document) {
    	ResultadosJson json = gson.fromJson(document, ResultadosJson.class);
    	return json;
    }
    
    public static List<Resultados> jsonToModel(List<ResultadosJson> jsons) {
    	List<Resultados> result = new ArrayList<Resultados>();
    	for (ResultadosJson json : jsons) {
    		Resultados model = new Resultados();
    		model.setId(json.get_id());
    		model.setData(json.getData());
    		if (json.getRestaurante() != null) {
	    		Restaurante restaurante = RestauranteConverter.jsonToModel(json.getRestaurante());
	    		model.setRestaurante(restaurante);
    		}
    		result.add(model);
    	}
    	return result;
    }
    
    public static Resultados jsonToModel(ResultadosJson json) {
    	Resultados model = new Resultados();
		model.setId(json.get_id());
		model.setData(json.getData());
		if (json.getRestaurante() != null) {
			Restaurante restaurante = RestauranteConverter.jsonToModel(json.getRestaurante());
			model.setRestaurante(restaurante);
		}
    	return model;
    }
    
}
