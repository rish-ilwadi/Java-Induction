//Deadlock Demonstration
package Library;

import java.io.*;
/*
 * package Library
 * imports java.lang,java.io packages
 * 
 * public class Client implements Runnable
 * 
 * Takes Inputs as Resource Name and Resource Id from the user and prints them using two threads 
 */
public class Client implements Runnable{
	
	private Resource resource;
	/*
	 * Method public void run() 
	 * overrides public void run() of Runnable Interface
	 * 
	 * returns nothing
	 * takes no arguments
	 * 
	 * Used for printing Resource Name and Resource Id using threads
	 */
	public void run(){
		
		String resourceName="";
		int resourceId=0;
		Resource resource1=this.resource;
		//If current thread is Thread1 then thread calls getResourceName() method of Resource class
		//else current thread calls getResourceId() method of Resource class
		if(Thread.currentThread().getName().equals("Thread1")){
			resourceName=resource1.getResourceName();
			System.out.println(resourceName+"\n");
		}
		else{
			resourceId=resource1.getResourceId();
			System.out.println(resourceId+"\n");
		}
		
	}
	/*
	 * method public void setResource(String resourceName,int resourceId)
	 * takes 2 arguments
	 * returns nothing
	 *
	 * Used for setting Resource Name & Resource Id 
	 *
	 */
	public void setResource(String resourceName,int resourceId){
		
		this.resource=new Resource();
		resource.setResourceName(resourceName);
		resource.setResourceId(resourceId);
	}
	/*
	 * main() method
	 * throws IOException, InterruptedException
	 */
	public static void main(String []args)throws IOException,InterruptedException{
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String resourceName;
		int resourceId;
		//Input Resource Name & Resource Id
		Client client=new Client();
		System.out.println("Enter Resource Name");
		resourceName=reader.readLine();
		System.out.println("Enter Resource ID");
		resourceId=Integer.parseInt(reader.readLine());
		client.setResource(resourceName,resourceId);
		//Start 2 new threads for client object
		Thread thread1=new Thread(client,"Thread1");
		Thread thread2=new Thread(client,"Thread2");
		thread1.start();
		thread2.start();
		
	}

}
