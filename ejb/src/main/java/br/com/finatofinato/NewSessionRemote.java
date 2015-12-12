package br.com.finatofinato;

import javax.ejb.Remote;

@Remote
public interface NewSessionRemote {

	public String foo();
}
