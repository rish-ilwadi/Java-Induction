package linkedinntegration;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;


@WebServlet("/sharepost")
/*
 * public class SharePost extends HttpServlet
 * Used for sending a post share request to LinkedIn using access token 
 */
public class SharePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		out = response.getWriter();
		out.println("Get method implementation");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpURLConnection connection = null;
		URL url = null;
		BufferedReader in = null;
		String records = null;
		HttpSession session = request.getSession();
		String token=(String)session.getAttribute("token");
		JSONObject json = new JSONObject(token);
		String accessToken = json.getString("access_token");
		out=response.getWriter();
		System.out.println(accessToken);
		DataOutputStream dout = null;
		FileInputStream file =null;
		File openFile;
		
	
		try{
			String newUrl = "https://api.linkedin.com/v1/people/~/shares?format=json&oauth2_access_token="+accessToken;
			/*
			 * Establishing connection & sending request
			 */
			url = new URL(newUrl);
			connection = (HttpURLConnection) url.openConnection();
			
			//Setting up HTTP headers
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("x-li-format", "json");
			dout = new DataOutputStream(connection.getOutputStream());
			String post = "{\"comment\": \"Check out developer.linkedin.com!\",\"content\": { \"title\": \"LinkedIn Developers Resources\", \"description\": \"Leverage LinkedIn's APIs to maximize engagement\",\"submitted-url\": \"https://developer.linkedin.com\",  \"submitted-image-url\": \"https://example.com/logo.png\" }, \"visibility\": {\"code\": \"anyone\" }  }";
            dout.writeBytes(post);
            dout.flush();

			
			//Reading Response using InputStreamReader
			
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer read = new StringBuffer();
 
			while ((inputLine = in.readLine()) != null) {
				read.append(inputLine);   //Reading response
			}
			records=read.toString(); //records contains Access token in JSON format

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
		response.sendRedirect("profile.jsp?records="+records);
	}

}
