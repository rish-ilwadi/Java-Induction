package employeerecords;

import javax.xml.ws.Endpoint;
/*
 * public class EmployeePublisher
 * 
 * Used for publishing the Employee class object on a url i.e. for hosting a web service
 * 
 */
public class EmployeePublisher {

	public static void main(String[] args) {
	
		Endpoint.publish("http://localhost:8282/getsalary", new Employee());

	}

}
