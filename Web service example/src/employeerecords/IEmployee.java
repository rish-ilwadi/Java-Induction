package employeerecords;

import javax.jws.WebMethod;
import javax.jws.WebService;

/*
 * public interface IEmployee
 * Used as an End Point Interface
 * 
 */
@WebService
public interface IEmployee {

	@WebMethod
	public int getSalary(String employeeName);
}
