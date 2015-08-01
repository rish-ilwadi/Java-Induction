package optimus.v1.employeerecords;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


import javax.ws.rs.QueryParam;

import org.json.JSONArray;
import org.json.JSONObject;

@Path("/employeedetails")
public class EmployeeDetails {

	@POST
	@Path("/getemployeedetails")
	@Produces("application/json")
	/*
	 * method: public String getEmployeeDetails(String employee)
	 * Used for getting employee details based upon the employee Name & email sent in JSON format 
	 * Returns a String in JSON format containing employee's Details
	 * Takes Request using GET method
	 */
	public String getEmployeeDetails(String employee){
	
		
		EmployeeDAO getEmployee = new EmployeeDAO();
		String employeeDetails = getEmployee.getEmployeeDetails(employee);
		return employeeDetails;
	}
	@POST
	@Path("/addemployeedetails")
	@Consumes("application/json")
	@Produces("application/json")
	/*
	 * method: public String addEmployeeDetails(String employee)
	 * Takes a String in JSONArray format containing loginCredentials & employeeDetails
	 * Requires admin login for access
	 * Used for adding a new employee
	 * Returns a String containing employeeCode of new Employee in JSON format
	 * else returns -1. If Authentication failed or employee not added
	 */
	public String addEmployeeDetails(String employee ){
		
		int check;
		JSONArray json = new JSONArray(employee);
		check = new AdminDAO().checkAdmin(json.getJSONObject(0).toString());
		JSONObject out = new JSONObject();
		if(check == 1){
			int employeeCode;
			employeeCode = new EmployeeDAO().addEmployee(json.getJSONObject(1).toString());
			out.put("Result", employeeCode);
		}else{
			out.put("Result", check);
		} 
		return out.toString();
	}
	@POST
	@Path("/updateemployeedetails")
	@Consumes("application/json")
	@Produces("application/json")
	/*
	 * method: public String updateEmployeeDetails(String employee)
	 * Takes a String in JSONArray format containing loginCredentials & employeeDetails
	 * Requires admin login for access
	 * Used for updating the employee records
	 * Returns a String containing message in JSON format 
	 * else returns -1. If Authentication failed or employee not updated
	 */
	public String updateEmployeeDetails(String employee){
		
		int check;
		JSONArray json = new JSONArray(employee);
		check = new AdminDAO().checkAdmin(json.getJSONObject(0).toString());
		JSONObject out=new JSONObject();
		if(check == 1){
			String message;
			message = new EmployeeDAO().updateEmployee(json.getJSONObject(1).toString());
			
		}
		out.put("Result", check);
		return out.toString();
	}
}
