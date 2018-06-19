package com.vetweb.cli;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vetweb.model.Especie;

public class EspecieCli {
	
	private Client client;
	
	private WebTarget especieResource;
	
	public EspecieCli() {
		client = new ResteasyClientBuilder().build();
		especieResource = client.target("http://localhost:8080/vetweb-api/").path("especies");
	}
	
	public List<Especie> getEspecies() {
		List<Especie> especies;
		Response response = especieResource
				.request()
				.get();
		try {
			especies = new ObjectMapper().readValue(response.readEntity(String.class), new TypeReference<List<Especie>>(){});
		} catch (IOException ioException) {
			throw new RuntimeException("Nao foi possivel converter o retorno do servico na entidade desejada. ");
		}
		return especies;
	}
	
}
