package linkedinntegration;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

/*
 * public class ViewProfile extends HttpServlet
 * Used for sending view profile request to the LinkedIn using access token
 */
@WebServlet("/viewprofile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
	
		try{
			String newUrl = "https://api.linkedin.com/v1/people/~?format=json&oauth2_access_token="+accessToken;
			/*
			 * Establishing connection & sending request
			 */
			url = new URL(newUrl);
			connection = (HttpURLConnection) url.openConnection();
			
			//Setting up HTTP headers
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("x-li-format", "json");
		
			
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
