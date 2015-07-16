package serialize;

import Collect.EmployeeException;
import java.io.*;

/*
 * package serialize
 * public class Employee implements java.io.serializable
 * 
 * Implements serialization having details of employee
 * having id & name as data members
 * Id serializable & name transient
 * 
 */

public class Employee implements Serializable {
	
	private static final long serialVersionUID = 5798257252170896932L;
	//Data Members
	public int id;
    public transient String name;
	/*
	 * Getter method: protected int getId()
	 * 
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
	 * throws EmployeeException
	 */
	public void setId(int id)throws EmployeeException{
		if(id <= 0 ||id > 65535){
			throw new EmployeeException("Invalid ID");
		}
		this.id=id;
			
	}
	/*
	 * Serializes Employee object & writes the contents into Employee.ser file 
	 * using FileOutputStream & ObjectOutputStream
	 */
	public static void main(String []args){
		try{
			Employee employee=new Employee();
			employee.setName("Rishab");
			employee.setId(12345);
		
		
			FileOutputStream file=new FileOutputStream("C:\\Users\\optimus154.OPTIMUSDOM\\AppData\\Local\\Temp\\Employee.ser"); //Opening file Employee.ser
			ObjectOutputStream out=new ObjectOutputStream(file);//Opening ObjectOutputStream
			out.writeObject(employee);//Writing object to the file
			out.close();
			file.close();
		}catch(FileNotFoundException fileNotFound){
			System.out.println(fileNotFound.getMessage());
		}
		catch(IOException exception){
			System.out.println(exception.getMessage());
		}
		catch(EmployeeException empException){
			System.out.println(empException.getMessage());
		}
		
	}
		

}
