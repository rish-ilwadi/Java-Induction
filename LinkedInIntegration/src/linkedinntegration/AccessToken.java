package linkedinntegration;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.servlet.http.HttpSession;

/*
 * public class AccessToken
 * Used for sending Post request to LinkedIn for getting access token
 */
public class AccessToken {
	
	public String getAccessToken(String code){
		
		HttpURLConnection connection = null;
		Properties property = new Properties();
		FileInputStream file = null;
		URL url = null;
		BufferedReader in = null;
		String token = null;
		try{
			/*
			 * Opening properties file
			 */
			file = new FileInputStream("E:/Workspace2/LinkedInIntegration/connection.properties");
			property.load(file);
			String newUrl = "https://www.linkedin.com/uas/oauth2/accessToken?grant_type="+property.getProperty("grant_type")+"&code="
					+ ""+code+"&redirect_uri="+property.getProperty("redirect_uri")+"&client_id="+property.getProperty("client_id")+"&client_secret="
					+property.getProperty("client_secret");
			/*
			 * Establishing connection & sending request
			 */
			url = new URL(newUrl);
			connection = (HttpURLConnection) url.openConnection();
			
			//Setting up HTTP headers
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		
			
			//Reading Response using InputStreamReader
			
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);   //Reading response
			}
			token=response.toString(); //records contains Access token in JSON format


		}catch(FileNotFoundException exception){
			exception.printStackTrace();
		}
		catch(MalformedURLException exception){
			exception.printStackTrace();
		}
		catch(IOException exception){
			exception.printStackTrace();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		finally{
			try {
				in.close();
			} catch (IOException exception) {
				
				exception.printStackTrace();
			}
			
		}
		
		return token;
		
		
	}
}
