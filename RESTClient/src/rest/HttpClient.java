package rest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
/*
 * public class HttpClient
 * Used for creating a REST Web Service Client
 * Using HttpURLConnection
 */
public class HttpClient {

	public static void main(String []args) throws IOException{
		
		String employeeName = "{\"employeeName\":\"Rishab\"}";
		JSONObject input = new JSONObject(employeeName);
		System.out.println(input);
		BufferedReader in = null;
		DataOutputStream out = null;
		HttpURLConnection connection;
		try{
		    /*
		     * Establishing connection with the REST Web service
		     * using HttpURLConnection
		     */
			URL url = new URL("http://localhost:8080/RESTservices/rest/employee/getrecords");
			connection = (HttpURLConnection) url.openConnection();
			/*
			 * Setting HTTP Headers
			 */
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
		    out = new DataOutputStream(connection.getOutputStream());
			out.writeBytes(input.toString());
			out.flush();
			
			//Reading Response using InputStreamReader
			
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);   //Reading response
			}
			String records=response.toString();
			System.out.println(records); //Printing the response
			
		}catch(MalformedURLException exception){
			exception.printStackTrace();

		}finally{
	        out.close();
			in.close();
		}
	}
}
