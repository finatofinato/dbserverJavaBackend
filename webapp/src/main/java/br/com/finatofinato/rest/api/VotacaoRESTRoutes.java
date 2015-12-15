package br.com.finatofinato.rest.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.finatofinato.bean.votacao.VotacaoRemote;
import br.com.finatofinato.json.RestauranteJson;
import br.com.finatofinato.json.ResultadosJson;
import br.com.finatofinato.json.VotacaoJson;
import br.com.finatofinato.model.Restaurante;
import br.com.finatofinato.model.Resultados;
import br.com.finatofinato.model.Votacao;
import br.com.finatofinato.rest.converter.RestauranteConverter;
import br.com.finatofinato.rest.converter.ResultadosConverter;
import br.com.finatofinato.rest.converter.VotacaoConverter;

@Path("/")
public class VotacaoRESTRoutes {
	
	@EJB
	private VotacaoRemote remote;
	
	@GET
	@Path("/votacao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarVotacoes() {
		List<Votacao> models = remote.listar();
		List<VotacaoJson> jsons = VotacaoConverter.modelToJson(models);
		return Response.status(200).entity(jsons).build();
	}
	
	@POST
	@Path("/votacao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserirVotacao(String document) {
		VotacaoJson json = VotacaoConverter.stringToJson(document);
		Votacao model = VotacaoConverter.jsonToModel(json);
		model = remote.inserir(model);
		json = VotacaoConverter.modelToJson(model);
		return Response.status(200).entity(json).build();
	}

	@POST
	@Path("/votacaos/pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarVotacoes(String document) {
		VotacaoJson json = VotacaoConverter.stringToJson(document);
		Votacao model = VotacaoConverter.jsonToModel(json);
		List<Votacao> models = remote.pesquisar(model);
		List<VotacaoJson> jsons = VotacaoConverter.modelToJson(models);
		return Response.status(200).entity(jsons).build();
	}

	@POST
	@Path("/votacaos/restaurantesJaUtilizados")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarRestaurantesJaUtilizados(String document) {
		VotacaoJson json = VotacaoConverter.stringToJson(document);
		Votacao model = VotacaoConverter.jsonToModel(json);
		
		List<Restaurante> models = remote.restaurantesJaUtilizados(model);
		List<RestauranteJson> jsons = RestauranteConverter.modelToJson(models);
		
		return Response.status(200).entity(jsons).build();
	}
	
	@POST
	@Path("/votacaos/resultados")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarResultados(String document) {
		ResultadosJson json = ResultadosConverter.stringToJson(document);
		Resultados model = ResultadosConverter.jsonToModel(json);
		List<Resultados> models = remote.resultados(model);
		List<ResultadosJson> jsons = ResultadosConverter.modelToJson(models);
		return Response.status(200).entity(jsons).build();
	}

	@POST
	@Path("/votacaos/resultado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserirResultado(String document) {
		ResultadosJson json = ResultadosConverter.stringToJson(document);
		Resultados model = ResultadosConverter.jsonToModel(json);
		model = remote.inserirResultado(model);
		json = ResultadosConverter.modelToJson(model);
		return Response.status(200).entity(json).build();
	}

}
