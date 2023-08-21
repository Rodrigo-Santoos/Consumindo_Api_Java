package com.br.consumoapiViaCEP.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.br.consumoapiViaCEP.model.Endereco;
import com.google.gson.Gson;

public class ViaCepService {
	
	//essa classe de servico que é responsavel por fazer a requisicao no https://viacep.com.br/
	
	public Endereco getEndereco(String cep) {
		
		Endereco endereco = null;
		
		HttpGet request = new HttpGet("https://viacep.com.br/ws/"+cep+"/json/"); //aqui dentro coloca a URL da API
		
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build(); 
				CloseableHttpResponse response = httpClient.execute(request)) {
			
			HttpEntity entity = response.getEntity();
			
			if(entity != null) {
				
				String result = EntityUtils.toString(entity);
				
				//conversao pata JSON
				Gson gson = new Gson();
				
				endereco = gson.fromJson(result, Endereco.class);
			}
			
		
		} catch (ClientProtocolException e) {
			System.out.println(e.getMessage());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return endereco;
	}

}
