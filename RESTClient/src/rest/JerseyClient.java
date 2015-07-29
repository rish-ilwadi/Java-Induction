package rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class JerseyClient {
	
	public static void main(String [] args){
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/RESTServices/rest/getsalary");
        String employeeName="{\"employeeName\":\"Sunil\"}";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, employeeName);
		
		if(response.getStatus()!=200){
			
			System.out.println(response.getEntity(String.class));
		}
		else{
	
			String records = response.getEntity(String.class);
 
		}
	}
	
	
}
