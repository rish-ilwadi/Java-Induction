package optimus.v1.employeerecords;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;
/*
 * public class EmployeeDAO
 * Contains methods for performing various operations on Employee POJO & EmployeeRecords table
 */
public class EmployeeDAO {
	
	
	private Configuration config;
	private SessionFactory factory;
	private Session newSession;
	private Transaction newTransaction;
	private JSONObject employee;
	private Employee employeeDetails=null;
	private JSONObject output;
	
	/*
	 * method: public String getEmployeeDetails(String getEmployee)
	 * Used for getting the details of a particular employee
	 * Takes String in JSON format as parameter
	 * Returns String in JSON format containing employee's records 
	 */
	public String getEmployeeDetails(String getEmployee){
		
		employee = new JSONObject(getEmployee);
	
		try{
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			newSession = factory.openSession();
			newTransaction = newSession.beginTransaction();
			Query getQuery = newSession.createQuery("FROM Employee WHERE name=:name AND email=:email ");
			getQuery.setParameter("name", employee.getString("employeeName"));
			getQuery.setParameter("email", employee.getString("email"));
			List <Employee> list;
			list = getQuery.list();
			Iterator <Employee> iterator = list.iterator();
			while(iterator.hasNext()){
				employeeDetails = (Employee)iterator.next();
				
			}
			newTransaction.commit();
			newSession.close();
		
			
		}catch(Error exception){
			exception.printStackTrace();
		}
		if(employeeDetails!=null){
			output = new JSONObject();
			output.put("employeeCode", employeeDetails.getEmployeeCode());
			output.put("name", employeeDetails.getName());
			output.put("email", employeeDetails.getEmail());
			output.put("address", employeeDetails.getAddress());
			output.put("mobileNo", employeeDetails.getMobileNo());
			output.put("salary", employeeDetails.getSalary());
			
			return output.toString();
			
		}
		return null;
	
		
	}
	/*
	 * method: public int addEmployee(String employeeRecords)
	 * Takes String in JSON format containing records to be added as parameter
	 * Returns employeeCode of added employee
	 */
	public int addEmployee(String employeeRecords){
		
		employee = new JSONObject(employeeRecords);
		int employeeCode=0;
		try{
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			newSession = factory.openSession();
			newTransaction = newSession.beginTransaction();
			employeeDetails = new Employee();
			employeeDetails.setName(employee.getString("employeeName"));
			employeeDetails.setEmail(employee.getString("email"));
			employeeDetails.setMobileNo(employee.getLong("mobileNo"));
			employeeDetails.setSalary(employee.getLong("salary"));
			employeeDetails.setAddress(employee.getString("address"));
			
			employeeCode=(int)newSession.save(employeeDetails);
			newTransaction.commit();
		}catch(Exception exception){
			
			exception.printStackTrace();
		}finally{
			newSession.close();
			return employeeCode;
		}
		
	}
	/*
	 * method: public String updateEmployee(String employeeRecords)
	 * Takes String in JSON format containing the updated employee records
	 */
	public String updateEmployee(String employeeRecords){
		
		employee = new JSONObject(employeeRecords);
		try{
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			newSession = factory.openSession();
			newTransaction = newSession.beginTransaction();
			Query updateQuery = newSession.createQuery("UPDATE Employee SET name =:name ,email =:email, mobileNo =:mobileNo, salary =:salary, address =:address WHERE employeeCode =:employeeCode");
			updateQuery.setParameter("name", employee.getString("employeeName"));
			updateQuery.setParameter("email", employee.getString("email"));
			updateQuery.setParameter("mobileNo", employee.getLong("mobileNo") );
			updateQuery.setParameter("salary",  employee.getLong("salary"));
			updateQuery.setParameter("address", employee.getString("address"));
			updateQuery.setParameter("employeeCode", employee.getInt("employeeCode"));
			updateQuery.executeUpdate();
			newTransaction.commit();
			
		}catch(Exception exception){
			exception.printStackTrace();
			
		}
		finally{
			newSession.close();
			return "Done";
		}
		
	}
}
