package employeerecords;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

/*
 * public class Employee implements IEmployee
 * used for creating a SOAP Web Service
 * 
 * Overrides public int getSalary(String employeeName) 
 * method 
 * 
 */
@WebService(endpointInterface="employeerecords.IEmployee")
public class Employee implements IEmployee{

	
	private Map employeeMap; //Map For storing records of Employees
	
	/*
	 * Initializing records into the Map using Constructor
	 */
	public Employee(){
		
		super();
		employeeMap=new HashMap();
		employeeMap.put("Rishab",30000);
		employeeMap.put("Sunil",28000);
	}
	
	/*
	 * method public int getSalary(String employeeName)
	 * 
	 * Used as @WebMethod
	 * 
	 * Takes employeeName as input & returns its salary
	 * 
	 */
	@Override
	@WebMethod
	public int getSalary(String employeeName){
		
		 Iterator <String>keyIterator=employeeMap.keySet().iterator();
		 int salary;
		 String name;
		 while(keyIterator.hasNext()){
			 
			 name=(String)keyIterator.next();
			 if(name.equals(employeeName)){
				 salary=(int)employeeMap.get(name);
				 return salary;
			 }
		
		 }
		 return 0;
	}
	
	

}
