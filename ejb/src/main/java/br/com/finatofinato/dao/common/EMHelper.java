package br.com.finatofinato.dao.common;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class EMHelper implements Serializable {
	private EntityManagerFactory emf;
    @PersistenceContext
    private EntityManager em;
	

    public EntityManager getEntityManager() {
    	if (this.emf == null)
    		this.emf = Persistence.createEntityManagerFactory("dbserver");
    	
    	if (this.em == null)
    		this.em = this.emf.createEntityManager();

    	return this.em;
    }
    
    public void setParameters(Query query, Map<String, Object> params) {
    	Set<String> keySet = params.keySet();
    	
    	for (String paramName: keySet) {
    		Object paramValue = params.get(paramName);
    		query.setParameter(paramName, paramValue);
    	}
    }
}
