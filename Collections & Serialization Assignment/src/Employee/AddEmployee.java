package Employee;

/*
 * package Employee
 * 
 * public class AddEmployee
 * 
 * Used for storing the details of employees
 */

public class AddEmployee {

	//Data Members
	private int id;
	private String name;
	private String department;
	/*
	 * Getter method: protected int getId()
	 * returns the value of Id of employee
	 */
	protected int getId(){
		return this.id;
	}
	/*
	 * Getter method: protected String getName()
	 * returns the name of employee
	 */
	protected String getName(){
		return this.name;
	}
	/*
	 * Getter method: protected String getDepartment()
	 * returns Department name
	 */
	protected String getDepartment(){
		return this.department;
	}
	/*
	 * Setter method: public void setName(String name)
	 * used for setting the employee's name
	 */
	public void setName(String name){
		
		this.name=name;
	}
	/*
	 * Setter method: public void setId(int id)
	 * used for setting the employee's id
	 */
	public void setId(int id){
		this.id=id;
	}
	/*
	 * Setter method: public void setDepartment(String department)
	 * used for setting the department of employee by comparing the value with enum Department
	 */
	public void setDepartment(String department)throws EmployeeException{
	
		for(Department dept :Department.values()){
			 
			if(department.equals((String)dept.name())){
				
				this.department=(String)dept.name();
			}
		}
		if(this.department==null){			
				throw new EmployeeException("Wrong Department Name!! Please add employee again (Departments: IT,Operations,Sales).");
	    }
		
	}
} 
