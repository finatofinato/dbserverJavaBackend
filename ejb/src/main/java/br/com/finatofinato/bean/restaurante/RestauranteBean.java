/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finatofinato.bean.restaurante;

import javax.ejb.Stateless;

import com.google.gson.Gson;

@Stateless
public class RestauranteBean implements RestauranteRemote, RestauranteLocal {

    public String foo() {
    	System.out.println("entrou foo!!!");
    	Gson gson = new Gson();
    	String retorno = gson.toJson(new Retorno("mostrando json"));
    	return retorno;
    }

    class Retorno {
    	private String mensagem;
    	public Retorno(String mensagem) {
    		this.mensagem = mensagem;
    	}
    }
}
