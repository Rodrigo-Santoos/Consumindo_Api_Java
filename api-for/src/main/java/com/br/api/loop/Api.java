package com.br.api.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Api {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//criar for para trazer o "id", "description" e "state"

//--conexao API
		//setando get requisiçao
//											URL API
		URL url = new URL("https://viacep.com.br/ws/08151000/json/");
		HttpURLConnection cone = (HttpURLConnection) url.openConnection();
		
		//mesma informaçoes no header postman

		//campo do token  				key 							 value
		//cone.setRequestProperty("API-KEY-AQUI", "54d75sa178f7487f1d78f77tr44198as87ed4f7");
		
		cone.setRequestProperty("Accept", "application/json");
		
		cone.setRequestMethod("GET");


		BufferedReader in = new BufferedReader(new InputStreamReader(cone.getInputStream()));
		String output;

		StringBuffer response = new StringBuffer();
		while ((output = in.readLine()) != null) {
			response.append(output);
		}
		
//--mostrando resultado
		
		JSONObject obj = new JSONObject(response.toString());
		//loop percorrendo todo Json
		for(int i = 0; i < obj.names().length(); i++){


//			System.out.println("key = " + obj.names().getString(i) + " value = " + obj.get(obj.names().getString(i)));
//			System.out.println(obj.opt("id"));
//			System.out.println(obj.opt("description"));
//			System.out.println(obj.opt("state"));
//			System.out.println();

			//System.out.println(obj.get(obj.names().getString(i)).getClass());

			//if para trazer as informaçoes que eu preciso
			if(obj.get(obj.names().getString(i)) == obj.get("cep")) {
				//System.out.println(obj.get(obj.names().getString(i)));
				System.out.println(obj.opt("cep"));

			} else 	if(obj.get(obj.names().getString(i)) == obj.get("bairro")) {
				//System.out.println(obj.get(obj.names().getString(i)));
				System.out.println(obj.opt("bairro"));
				
			}  else if(obj.get(obj.names().getString(i)) == obj.get("ibge")) {
				//System.out.println(obj.get(obj.names().getString(i)));
				System.out.println(obj.opt("ibge"));
			}
		}
	}

}

