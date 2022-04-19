import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Sending get request
		URL url = new URL("https://apirest-pacientes.herokuapp.com/swagger-ui.html#!/pacientes45resources/listarPacientesUsingGET");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		//mesma informaçoes no header postman
		//campo do token  				key 							 value
		conn.setRequestProperty("API-KEY-AQUI", "54d75sa178f7487f1d78f77tr44198as87ed4f7");
		
		conn.setRequestProperty("Accept", "application/json");
		
		conn.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String output;

		StringBuffer response = new StringBuffer();
		while ((output = in.readLine()) != null) {
			response.append(output);
		}
		
		// printing result from response
		
		JSONObject obj = new JSONObject(response.toString());
		
		int id = obj.getInt("id");
		
		JSONObject obj_currency = obj.getJSONObject("currency");
		
		String code = obj_currency.getString("code");
		
		int id_de_atta = obj.getJSONArray("quote-request-attachments").getJSONObject(0).getJSONArray("attachments").getJSONObject(0).getInt("id");
		
		//business-partners
		
		String atti_de_business = obj.getJSONArray("business-partners").getJSONObject(0).getString("attitude");
		
		System.out.println(id);
		
		System.out.println(code);
		
		System.out.println(id_de_atta);
		
		System.out.println(atti_de_business);
		
		//criar for para trazer o "id", "description" e "state"

		in.close();
	}
}
