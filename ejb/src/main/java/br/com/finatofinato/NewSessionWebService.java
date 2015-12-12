package br.com.finatofinato;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(name="DBServerWS")
public class NewSessionWebService {
	@EJB
	private NewSessionRemote ejb;
	
	public String getHello() {
		return ejb.foo();
	}
}
