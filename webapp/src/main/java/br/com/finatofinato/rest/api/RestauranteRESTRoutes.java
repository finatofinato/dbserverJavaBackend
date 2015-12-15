package br.com.finatofinato.rest.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.finatofinato.bean.restaurante.RestauranteRemote;
import br.com.finatofinato.json.RestauranteJson;
import br.com.finatofinato.model.Restaurante;
import br.com.finatofinato.rest.converter.RestauranteConverter;

@Path("/restaurante")
public class RestauranteRESTRoutes {
	
	@EJB
	private RestauranteRemote remote;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		List<Restaurante> models = remote.listar();
		List<RestauranteJson> jsons = RestauranteConverter.modelToJson(models);
		return Response.status(200).entity(jsons).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserir(String document) {
    	RestauranteJson json = RestauranteConverter.stringToJson(document);
		Restaurante model = RestauranteConverter.jsonToModel(json);
		model = remote.inserir(model);
		json = RestauranteConverter.modelToJson(model);
		return Response.status(200).entity(json).build();
	}

}
