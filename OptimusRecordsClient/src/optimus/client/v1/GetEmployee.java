package optimus.client.v1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONObject;
/*
 * public class GetEmployee
 * Used for getting the details of a employee
 */

public class GetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PrintWriter out;  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		out = response.getWriter();
		out.println("Post Method implementation");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Logger log = Logger.getLogger(GetEmployee.class);
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
		
		/*
		 * Creting JSON object for the employee whose details are to be fetched
		 */
		log.debug("Started the doGet method of GetEmployee");
		log.info("Fetchinhg name & email of employee whose details are to be fetched & converting to JSON Object");
		JSONObject employee = new JSONObject();

		employee.put("employeeName",request.getParameter("employeeName"));
		employee.put("email", request.getParameter("email"));
	
		/*
	     * Establishing connection with the REST Web service
	     * using HttpURLConnection
	     */
		log.info("Establishing HttpURLConnection with the Web service");
		URL url = new URL("http://localhost:8080/OptimusRecords/optimus/v1/employeerecords/employeedetails/getemployeedetails");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		log.info("Connection established");
		log.info("Sending JSONObject to web service");
		/*
		 * Setting HTTP Headers
		 */
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
	    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		out.writeBytes(employee.toString());
		out.flush();
		log.info("Reading response");
		//Reading Response using InputStreamReader

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer employeeDetails = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			employeeDetails.append(inputLine);   //Reading response
		}
		log.info("Employee details fetched");
		String records = employeeDetails.toString();
		HttpSession session = request.getSession();
		session.setAttribute("records",records);
		response.sendRedirect("/OptimusRecordsClient/employeedetails.jsp");
	}

}
