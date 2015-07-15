package Employee;
/*
 * package Employee
 * public class ShowEmployee
 * 
 * Used for Displaying Employees whose Department is Not Sales
 */
import java.util.*;
import java.io.*;
public class ShowEmployee {

	
	public static void main(String []args)throws IOException{
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in)); //Used for Taking inputs from the user the Employee Details
		//Including Name,id,department
		String name;
		String department;
		int id;
		int totalEmployees;
		//Provide No. of Employees
		System.out.println("Enter no. of new Employees: ");
		totalEmployees=Integer.parseInt(reader.readLine());
		System.out.println("\n");
	    AddEmployee employee;
		ArrayList <AddEmployee> list=new <AddEmployee> ArrayList();
		Map <Integer,String> map=new <Integer,String> LinkedHashMap();
		//Provide Details of Employee
		//Can throw EmployeeException: Department Invalid
		for(int counter = 1 ; counter <= totalEmployees; counter++){
			try{
				System.out.println("Employee "+counter+"\n\n");
				System.out.println("Enter Employee Name");
				name=reader.readLine();
				System.out.println("Enter Employee ID ");
				id=Integer.parseInt(reader.readLine());
				System.out.println("Enter Department: ");
				department=reader.readLine();
				employee=new AddEmployee();
				employee.setName(name);
				employee.setId(id);
				employee.setDepartment(department);
				list.add(employee);  //Employee Added in a list
				map.put(employee.getId(),employee.getName()); //Id & Name added in map as (Key,Value) pair 
			}catch(EmployeeException exception){
				
				System.out.println(exception.getMessage());
				counter--;
			}

		}	
		new ShowEmployee().show(map,list);
		reader.close();
		
		
	}
	/*
	 * Method: public void show(Map map,ArrayList list)
	 * returns nothing takes a Map & ArrayList as arguments
	 * 
	 * Retrieve Details of Employees from Map & List & check for Employees whose department is not sales 
	 */
	public void show(Map map, ArrayList list){
		
	     Iterator <AddEmployee>iterator=list.iterator(); //Iterator for ArrayList 
	     Iterator <Integer>keyIterator=map.keySet().iterator(); //Iterator for LinkedHashMap
	     AddEmployee employee;
	     String name;
	     int id;
	     int counter;
	     counter=0;
	     System.out.println("List of Employees who are not in Sales:\n");
	     /*
	      * Checking & printing for employees whose Department is not Sales
	      */
	     try{
	    	 while(iterator.hasNext() || keyIterator.hasNext()){
	    	 
	    		 employee=(AddEmployee)iterator.next();
	    		 id=(int)keyIterator.next();
	    		 name=(String)map.get(id);
	    	 
	    		 if(employee.getId()==id && employee.getName().equals(name)){
	    		 
	    		 
	    			 if(employee.getDepartment().equals((String)Department.Sales.name())){
	    		 
	    				 continue;
	    			 }
	    			 else{
	    				 System.out.println(id+"\t"+name);
	    				 counter++;
	    			 }
	    		 }
	    	 }
	      }catch(Exception exception){
	    	  System.out.println(exception.getMessage());
	      }
	     finally{
	    	 System.out.println("\nNo. of Employees= "+counter);
	     }
	}
}
