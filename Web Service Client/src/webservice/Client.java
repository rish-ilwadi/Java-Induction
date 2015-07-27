package webservice;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/*
 * public class Client 
 *
 * Used for sending a request for the Web Service by sending a SOAP envelope & printing the result  
 */
public class Client {

	/*
	 * method public void sendPost()
	 *  Used for sending a Http request as POST to the wsdl url. 
	 *  
	 *  A SOAP envelope is sent with the request & the response is printed as output
	 */
	
	public void sendPost() throws IOException{
		
		String wsdlURL="http://localhost:8282/getsalary?wsdl";
		URL url=new URL(wsdlURL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //Creating Http connection
		//setting HTTP header parameters
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "text/xml");
		connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		connection.setDoOutput(true);
		FileReader file = null;
		BufferedReader reader=null;
		DataOutputStream output;
		BufferedReader in=null;
		try{
			
			file=new FileReader("C:\\SOAP Envelope.txt"); //Reading SOAP Envelope from a file
			reader = new BufferedReader(file);  
			output=new DataOutputStream(connection.getOutputStream());
			System.out.println(output);
			String content;
			while((content=reader.readLine())!=null){
				
				System.out.println(content);
				output.writeBytes(content); //Writing data to DataOutputStream
			}
			output.flush(); //Data sent as a request
			output.close();
			file.close();
			reader.close();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Response Code : ");
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);   //Reading response
			}
			in.close();
	 
			//printing response
			System.out.println(response.toString());

			 
		
		}catch(FileNotFoundException exception){
			
			exception.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		
		Client newClient = new Client();
		try {
			newClient.sendPost();  //Calling sendPost() method
		} catch (MalformedURLException exception) {
			
			exception.printStackTrace();
		} catch (IOException ioException) {
			
			ioException.printStackTrace();
		}

	}

}
