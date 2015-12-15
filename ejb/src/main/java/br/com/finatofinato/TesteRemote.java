package br.com.finatofinato;

import javax.ejb.Remote;

@Remote
public interface TesteRemote {

	public String foo();
}
