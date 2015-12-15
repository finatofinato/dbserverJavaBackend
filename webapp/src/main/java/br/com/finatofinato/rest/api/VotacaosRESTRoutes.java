package br.com.finatofinato.rest.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.finatofinato.json.VotacaoJson;

@Path("/votacaos")
public class VotacaosRESTRoutes {

	@POST
	@Path("/pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarVotacoes(String document) {
		Gson gson = new Gson();
		List<VotacaoJson> lista = new ArrayList<VotacaoJson>();
		lista.add(gson.fromJson(document, VotacaoJson.class));		
		
		return Response.status(200).entity(lista).build();
	}

	@POST
	@Path("/restaurantesJaUtilizados")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarRestaurantesJaUtilizados(String document) {
		Gson gson = new Gson();
		List<VotacaoJson> lista = new ArrayList<VotacaoJson>();
		lista.add(gson.fromJson(document, VotacaoJson.class));		
		
		return Response.status(200).entity(lista).build();
	}
	
}
