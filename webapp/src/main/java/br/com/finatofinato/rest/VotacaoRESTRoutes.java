package br.com.finatofinato.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.finatofinato.NewSessionRemote;

@Path("/votacaoroutes")
public class VotacaoRESTRoutes {
	
	@EJB
	private NewSessionRemote remote;
	
	@GET
	@Path("/{param1}")
	@Produces(MediaType.APPLICATION_JSON)
	public String methodGet(@PathParam("param1") String param1) {
		System.out.println("param1 : " + param1);
		return remote.foo();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response methodPost(String str) {
		
		System.out.println("produto: " + str);
		Gson gson = new Gson();
    	Produto produto = gson.fromJson(str, Produto.class);
    	System.out.println("produto_id: " + produto.getId());
    	System.out.println("produto_nome: " + produto.getNome());
		System.out.println("=============================================");
		
		//String result = remote.foo();
		//return Response.status(200).entity(result).build();
		
		return Response.status(200).entity(produto).build();
	}
	
    class Produto {
    	private String id;
    	private String nome;
    	
    	public Produto() {
    		
    	}
    	
    	public String getId() {
			return id;
		}
    	public void setId(String id) {
			this.id = id;
		}
    	public String getNome() {
			return nome;
		}
    	public void setNome(String nome) {
			this.nome = nome;
		}
    }

}
