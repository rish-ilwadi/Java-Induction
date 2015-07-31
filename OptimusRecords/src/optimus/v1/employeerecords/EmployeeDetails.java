package optimus.v1.employeerecords;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


import javax.ws.rs.QueryParam;

import org.json.JSONObject;

@Path("/employeedetails")
public class EmployeeDetails {

	@GET
	@Path("/getemployeedetails")
	@Produces("application/json")
	/*
	 * method: public String getEmployeeDetails(String employeeName, String email)
	 * Used for getting employee details based upon the employee Name & email 
	 * Returns a String in JSON format containing employee's Details
	 * Takes Request using GET method
	 */
	public String getEmployeeDetails(@QueryParam("employeeName") String employeeName, @QueryParam("email") String email){
	
		JSONObject employee = new JSONObject();
		employee.put("employeeName", employeeName);
		employee.put("email", email);
		
		EmployeeDAO getEmployee = new EmployeeDAO();
		String employeeDetails = getEmployee.getEmployeeDetails(employee.toString());
		return employeeDetails;
	}
	@POST
	@Path("/addemployeedetails")
	@Consumes("application/json")
	@Produces("application/json")
	/*
	 * method: public String addEmployeeDetails(String employeeRecords, String loginCredentials)
	 * Takes two Strings in JSON format employeeRecords & loginCredentials
	 * Requires admin login for access
	 * Used for adding a new employee
	 * Returns a String containing employeeCode of new Employee in JSON format
	 * else returns -1. If Authentication failed or employee not added
	 */
	public String addEmployeeDetails(String employeeRecords, String loginCredentials){
		
		int check;
		check = new AdminDAO().checkAdmin(loginCredentials);
		JSONObject out=new JSONObject();
		if(check == 1){
			int employeeCode;
			employeeCode = new EmployeeDAO().addEmployee(employeeRecords);
			out.put("Result", employeeCode);
		}else{
			out.put("Result", -1);
		} 
		return out.toString();
	}
	@POST
	@Path("/updateemployeedetails")
	@Consumes("application/json")
	@Produces("application/json")
	/*
	 * method: public String updateEmployeeDetails(String employeeRecords, String loginCredentials)
	 * Takes two Strings in JSON format employeeRecords & loginCredentials
	 * Requires admin login for access
	 * Used for updating the employee records
	 * Returns a String containing message in JSON format 
	 * else returns -1. If Authentication failed or employee not updated
	 */
	public String updateEmployeeDetails(String employeeRecords, String loginCredentials){
		
		int check;
		check = new AdminDAO().checkAdmin(loginCredentials);
		JSONObject out=new JSONObject();
		if(check == 1){
			String message;
			message = new EmployeeDAO().updateEmployee(employeeRecords);
			out.put("Result", message);
		}else{
			out.put("Result", "Admin Authentication Failed");
		} 
		return out.toString();
	}
}
