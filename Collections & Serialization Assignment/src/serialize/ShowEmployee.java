package serialize;

import java.io.*;
/*
 * package serialize
 * public class ShowEmployee
 * 
 * Used for deserializing the object of Employee class & showing its contents by reading from file Employee.ser using ObjectInputStream
 */
public class ShowEmployee {

	public static void main(String []args){
		
		Employee employee=null;
		try{
			FileInputStream file=new FileInputStream("C:\\Users\\optimus154.OPTIMUSDOM\\AppData\\Local\\Temp\\Employee.ser"); //Opening file in Input Stream
			ObjectInputStream in=new ObjectInputStream(file); //Opening ObjectInputStream
			employee=(Employee)in.readObject(); //Reading Object
			in.close();
			file.close();
			
		}catch(FileNotFoundException fileNotFound){
			
			System.out.println(fileNotFound.getMessage());
			
		}
		catch(IOException exception){
			
			System.out.println(exception.getMessage());
			
		}
		catch(ClassNotFoundException classNotFound){
			
			System.out.println(classNotFound.getMessage());
		   
		}
		/*
		 * Displaying contents of deserialized object
		 */
		System.out.println("Name= "+employee.name);
		System.out.println("Id= "+employee.id);

	}
}
