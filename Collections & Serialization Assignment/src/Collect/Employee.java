package Collect;
/*
 * Package Collect
 * public class Employee
 * 
 * Used for Adding details ID & Name of an Employee
 * And Displaying them in Sorted Order
 */
import java.util.*;
import java.io.*;

public class Employee {
		
	public static void main(String []args)throws IOException{
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in)); //Used for Taking inputs from the user the Employee Details
			//Including Name,id,department
			String name;
			int id;
			int totalEmployees;
			//Provide No. of Employees
			System.out.println("Enter no. of new Employees: ");
			totalEmployees=Integer.parseInt(reader.readLine());
			System.out.println("\n");
		    AddEmployee employee;
			Map <Integer,String> map=new <Integer,String> LinkedHashMap();
			//Provide Details of Employee
			//can throw EmployeeException
			for(int counter = 1 ; counter <= totalEmployees; counter++){
			
				try{
					System.out.println("Employee "+counter+"\n\n");
					System.out.println("Enter Employee Name");
					name=reader.readLine();
					System.out.println("Enter Employee ID ");
					id=Integer.parseInt(reader.readLine());
					employee=new AddEmployee();
					employee.setName(name);
					employee.setId(id);
					map.put(employee.getId(),employee.getName()); //Id & Name added in map as (Key,Value) pair 
				
				}catch(EmployeeException exception){
					System.out.println(exception.getMessage());
					counter--;
				}


			}	
			System.out.println(map+"\n\n");
			new Employee().show(map);
			reader.close();
			
			
			
	}
	/*
	 * method: public void show(Map <Integer,String>map)
	 * takes map as a input & displays the output in Sorted Order of Id(Key) 
	 * 
	 */
	public void show(Map <Integer,String>map){
		
		Map <Integer,String>sortedMap=new <Integer,String>TreeMap();
		Iterator keyIterator=map.keySet().iterator();
		int id;
		String name;
		while(keyIterator.hasNext()){
			
			id=(int)keyIterator.next();
			name=(String)map.get(id);
			sortedMap.put(id,name);
		}
		System.out.println(sortedMap);
		
	}

}
