package rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * public class Employee
 * Used for Creating a REST Web service for getting the various details of an employee
 */
@Path("/employee")
public class Employee {
	
	private static String organisationRecords = "{\"organisation\":\"Optimus\",\"employeeRecords\":[{\"employeeName\":\"Rishab\",\"Age\":22,\"salary\":40000,\"Place\":\"Bareilly\"},{\"employeeName\":\"Sunil\",\"Age\":23,\"salary\":38000,\"Place\":\"Bareilly\"}]}";
	/*
	 * method: public String getRecords(String employeeName)
	 * Handles Post Requests.
	 * Consumes & Produces in application/json content type 
	 * Takes employeeName as input (employeeName in JSON format)
	 * returns employee's records as String of JSONObject 
	 * (For HttpClient)
	 */
	@POST
	@Path("/getrecords")
	@Consumes("application/json")
	@Produces("application/json")
	public String getRecords(String employeeName){
		
		
		JSONObject organisation = new JSONObject(organisationRecords);   //Converting String to JSONObject
		JSONObject jsonInput = new JSONObject(employeeName);    //Converting String to JSONObject
		
		JSONArray jsonArray = organisation.getJSONArray("employeeRecords");
		int index = 0;
		/*
		 * Checks for employee's records in the Organisation JSON 
		 * & returns it as String of JSONObject 
		 */
		while(index < jsonArray.length()){
			
			if(jsonInput.getString("employeeName").equals(jsonArray.getJSONObject(index).getString("employeeName"))){
				
				return jsonArray.getJSONObject(index).toString();
			
			}
			index++;
		}
		return null;

	}

	@POST
	@Path("/getsalary")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getSalary(String employeeName){
		
		
		JSONObject organisation = new JSONObject(organisationRecords);   //Converting String to JSONObject
		JSONObject jsonInput = new JSONObject(employeeName);    //Converting String to JSONObject
		JSONArray jsonArray = organisation.getJSONArray("employeeRecords");
		JSONObject jsonOutput = new JSONObject();
		int index=0;
		/*
		 * Checks for employee's salary in the Organisation JSON 
		 * & returns it as String of JSONObject 
		 */
		while(index < jsonArray.length()){
			
			if(jsonInput.getString("employeeName").equals(jsonArray.getJSONObject(index).getString("employeeName"))){
				
					jsonOutput.put("employeeName",jsonArray.getJSONObject(index).getString("employeeName"));
					jsonOutput.put("salary",jsonArray.getJSONObject(index).getInt("salary"));
					return  Response.status(200).entity(jsonOutput.toString()).build();
			
			}
			index++;
		}
		return Response.status(404).entity("No Records").build();

	}

	
}
