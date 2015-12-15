package br.com.finatofinato;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
	 
	 
public class EJBAppClientUtil {

	public static void main(String[] args) {
    	TesteRemote bean = doLookup();
        String retorno = bean.foo();
        System.out.println(retorno);
    }

	 
    private static TesteRemote doLookup() {
        Context context = null;
        TesteRemote bean = null;

        try {
        	Properties properties = new Properties();
        	
        	//6
        	//properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			//properties.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			//properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			
			//7
        	properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        	properties.put(Context.PROVIDER_URL, "remote://localhost:4447");
        	
        	properties.put("jboss.naming.client.ejb.context", true);
        	
        	properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        	properties.put(Context.SECURITY_PRINCIPAL,"appuser");
        	properties.put(Context.SECURITY_CREDENTIALS,"password");
	                	
        	context = new InitialContext(properties);
        	
        	NamingEnumeration<NameClassPair> list = context.list("");
        	System.out.println(list.hasMore());
        	
        	
        	List<String> teste = new ArrayList<String>();
        	teste.add("ejb:ear-0.0.1-SNAPSHOT/ejb-0.0.1-SNAPSHOT/TesteBean!br.com.finatofinato.TesteRemote");
        	
        //	teste.add("ejb:ear-0.0.1-SNAPSHOT/ejb-0.0.1-SNAPSHOT/NewSessionBean!br.com.finatofinato.NewSessionLocal");
        	
        	
        	/*
        	teste.add("ear-0.0.1-SNAPSHOT/NewSessionBean/remote");
        	teste.add("ear-0.0.1-SNAPSHOT/NewSessionBean/remote-br.com.finatofinato.dbserver.NewSessionRemote");
        	teste.add("ear-0.0.1-SNAPSHOT/NewSessionBean/local");
        	teste.add("ear-0.0.1-SNAPSHOT/NewSessionBean/local-br.com.finatofinato.dbserver.NewSessionLocal");

        	bbbbb - EJB3.x Default Remote Business Interface
        	aaaaa/remote-br.com.finatofinato.dbserver.NewSessionRemote - EJB3.x Remote Business Interface
        	aaaaa/local - EJB3.x Default Local Business Interface
        	aaaaa/local-br.com.finatofinato.dbserver.NewSessionLocal - EJB3.x Local Business Interface
        	*/
        	
			bean = (TesteRemote) context.lookup(teste.get(0));

        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
	

