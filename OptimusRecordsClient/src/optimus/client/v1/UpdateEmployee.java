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
import org.json.JSONArray;
import org.json.JSONObject;
/*
 * public class UpdateEmployee
 * Used for updating the details of an employee
 */
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;  
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
		out.println("Get Method implementation");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Logger log = Logger.getLogger(AddEmployee.class);
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
		/*
		 * Creating JSON object for admin's login credentials 
		 * 
		 */
		log.debug("Started the doPost method of UpdateEmployee");
		log.info("Fetching admin login credentials & converting them to JSON Object");
		JSONObject admin = new JSONObject();
		admin.put("userName", request.getParameter("userName"));
		admin.put("password", request.getParameter("password"));
		HttpSession session = request.getSession();
		JSONObject json = new JSONObject((String)session.getAttribute("records"));
		
		log.info("Fetchinhg details of employee to be updated & converting to JSON Object");
		JSONObject employee = new JSONObject();
		/*
		 * Creating JSON object updated Employee's Details
		 */
		
		
		employee.put("employeeCode", json.getInt("employeeCode"));
		employee.put("employeeName",request.getParameter("employeeName"));
		employee.put("email", request.getParameter("email"));
		employee.put("mobileNo", Long.parseLong(request.getParameter("mobileNo")));
		employee.put("salary", Long.parseLong(request.getParameter("salary")));
		employee.put("address", request.getParameter("address"));

		log.info("Adding the admin login credentials JSON Object & employee details JSON object to JSON array");
		JSONArray newEmployee = new JSONArray();
		newEmployee.put(0,admin);
		newEmployee.put(1,employee);
		/*
	     * Establishing connection with the REST Web service
	     * using HttpURLConnection
	     */
		log.info("Establishing HttpURLConnection with the Web service");
		URL url = new URL("http://localhost:8080/OptimusRecords/optimus/v1/employeerecords/employeedetails/updateemployeedetails");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		log.info("Connection established");
		log.info("Sending JSONArray to web service");
		
		/*
		 * Setting HTTP Headers
		 */
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
	    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		out.writeBytes(newEmployee.toString());
		out.flush();
		
		//Reading Response using InputStreamReader
		log.info("Reading response");
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer employeeDetails = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			employeeDetails.append(inputLine);   //Reading response
		}
		inputLine = employeeDetails.toString();
		JSONObject result = new JSONObject(inputLine);
		int check;
		check = result.getInt("Result");
		if(check<0){
			log.error("Admin authentication failed or an error occured");
			response.sendRedirect("/OptimusRecordsClient/authenticationerror.jsp");
		}
		else{
			log.info("Employee Updated");
			response.sendRedirect("/OptimusRecordsClient/employee.jsp");
		}
	}	
}


