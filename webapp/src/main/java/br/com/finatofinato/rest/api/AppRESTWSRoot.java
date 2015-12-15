package br.com.finatofinato.rest.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/restapp")
public class AppRESTWSRoot extends Application {
	
	//enable cors
	//http://software.dzhuvinov.com/cors-filter-configuration.html
/*
	private Set<Object> singletons = new HashSet<Object>();
	
	public AppRESTWSRoot() {
		singletons.add(new RestauranteRESTRoutes());
		singletons.add(new VotacaoRESTRoutes());
		singletons.add(new VotacaosRESTRoutes());
		singletons.add(new NewSessionRESTWS2());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}*/
}
