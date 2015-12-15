package br.com.finatofinato.rest.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.com.finatofinato.json.RestauranteJson;
import br.com.finatofinato.model.Restaurante;

public class RestauranteConverter implements Serializable {
	private static Gson gson = new Gson();
	
    public static List<RestauranteJson> modelToJson(List<Restaurante> models) {
    	List<RestauranteJson> result = new ArrayList<RestauranteJson>();
    	for (Restaurante model : models) {
    		RestauranteJson json = new RestauranteJson();
    		json.set_id(model.getId());
    		json.setNome(model.getNome());
    		result.add(json);
    	}
    	return result;
    }
    
    public static RestauranteJson modelToJson(Restaurante model) {
		RestauranteJson json = new RestauranteJson();
		json.set_id(model.getId());
		json.setNome(model.getNome());
    	return json;
    }
    
    public static RestauranteJson stringToJson(String document) {
    	RestauranteJson json = gson.fromJson(document, RestauranteJson.class);
    	return json;
    }
    
    public static List<Restaurante> jsonToModel(List<RestauranteJson> jsons) {
    	List<Restaurante> result = new ArrayList<Restaurante>();
    	for (RestauranteJson json : jsons) {
    		Restaurante model = new Restaurante();
    		model.setId(json.get_id());
    		model.setNome(json.getNome());
    		result.add(model);
    	}
    	return result;
    }
    
    public static Restaurante jsonToModel(RestauranteJson json) {
    	Restaurante model = new Restaurante();
		model.setId(json.get_id());
		model.setNome(json.getNome());
    	return model;
    }
    
}
