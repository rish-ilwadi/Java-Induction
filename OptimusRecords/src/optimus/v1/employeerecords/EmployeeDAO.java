package optimus.v1.employeerecords;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
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
	private Logger log;
	public EmployeeDAO(){
		log = Logger.getLogger(EmployeeDAO.class);
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
	}
	/*
	 * method: public String getEmployeeDetails(String getEmployee)
	 * Used for getting the details of a particular employee
	 * Takes String in JSON format as parameter
	 * Returns String in JSON format containing employee's records 
	 */
	public String getEmployeeDetails(String getEmployee){
		
		log.debug("Starting fetching employee details");
		employee = new JSONObject(getEmployee);
		log.info("Received JSON Object containing name of employee & email ");
		try{
			/*
			 * setting up logging statements
			 */
			log.info("Searching in the database");
			/*
			 * Establishing connection with the database
			 */
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			newSession = factory.openSession();
			newTransaction = newSession.beginTransaction();
			log.info("executing query");
			/*
			 * Executing query for retrieving the records
			 */
			Query getQuery = newSession.createQuery("FROM Employee WHERE name=:name AND email=:email ");
			getQuery.setParameter("name", employee.getString("employeeName"));
			getQuery.setParameter("email", employee.getString("email"));
			log.info("listing the results");
			List <Employee> list;
			list = getQuery.list();
			Iterator <Employee> iterator = list.iterator();
			while(iterator.hasNext()){
				employeeDetails = (Employee)iterator.next();
				
			}
			newTransaction.commit();
			newSession.close();
		
			
		}catch(HibernateException exception){
			log.error("exception occured\n"+exception.getMessage());
		}
		log.warn("employee details might be null");
		if(employeeDetails!=null){
			
			log.info("Converting employee details in json & sending back to the client");
			output = new JSONObject();
			output.put("employeeCode", employeeDetails.getEmployeeCode());
			output.put("name", employeeDetails.getName());
			output.put("email", employeeDetails.getEmail());
			output.put("address", employeeDetails.getAddress());
			output.put("mobileNo", employeeDetails.getMobileNo());
			output.put("salary", employeeDetails.getSalary());
			
			return output.toString();
			
		}
		log.warn("no employee found");
		return null;
	
		
	}
	/*
	 * method: public int addEmployee(String employeeRecords)
	 * Takes String in JSON format containing records to be added as parameter
	 * Returns employeeCode of added employee
	 */
	public int addEmployee(String employeeRecords){
		
		employee = new JSONObject(employeeRecords);
		log.debug("Received details of employee to be added");
		int employeeCode=0;
		try{
			
			log.info("Connecting with database");
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			newSession = factory.openSession();
			newTransaction = newSession.beginTransaction();
			log.info("Adding records into the database");
			employeeDetails = new Employee();
			employeeDetails.setName(employee.getString("employeeName"));
			employeeDetails.setEmail(employee.getString("email"));
			employeeDetails.setMobileNo(employee.getLong("mobileNo"));
			employeeDetails.setSalary(employee.getLong("salary"));
			employeeDetails.setAddress(employee.getString("address"));
			
			employeeCode=(int)newSession.save(employeeDetails);
			newTransaction.commit();
			log.info("Records added");
		}catch(HibernateException exception){
			
			log.error("Exception occured\n"+exception.getMessage());
		}
		finally{
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
		log.debug("Received details of employee whose records are to be updated");
		try{
			log.info("Connecting with database");
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			newSession = factory.openSession();
			newTransaction = newSession.beginTransaction();
			log.info("Updating records into the database");
			Query updateQuery = newSession.createQuery("UPDATE Employee SET name =:name ,email =:email, mobileNo =:mobileNo, salary =:salary, address =:address WHERE employeeCode =:employeeCode");
			updateQuery.setParameter("name", employee.getString("employeeName"));
			updateQuery.setParameter("email", employee.getString("email"));
			updateQuery.setParameter("mobileNo", employee.getLong("mobileNo") );
			updateQuery.setParameter("salary",  employee.getLong("salary"));
			updateQuery.setParameter("address", employee.getString("address"));
			updateQuery.setParameter("employeeCode", employee.getInt("employeeCode"));
			updateQuery.executeUpdate();
			newTransaction.commit();
			log.info("Records updated for the employee in the database");
		}catch(HibernateException exception){
			log.error("Exception occured\n"+exception.getMessage());
			
		}
		finally{
			newSession.close();
			return "Done";
		}
		
	}
}
