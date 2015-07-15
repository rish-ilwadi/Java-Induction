package Collect;

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
	
} 
