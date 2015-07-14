package Library;
import java.io.*;
/*
 * package Library
 * imports java.lang,java.io Package
 * 
 * public class Books
 * implements interface Runnable
 * 
 * implements public void Run() method
 * 
 * Used for writing the Book Names in a file using threads
 * 
 */
public class Books implements Runnable{

	private String bookName;
     private FileWriter file;
	/*
	 * Method: protected synchronized String getBookName()
	 * returns String
	 * 
	 * Access Specifier: protected
	 * is synchronized
	 * 
	 * Used for returning the Book Name.
	 * 
	 */
	protected synchronized String getBookName(){
		
		return this.bookName;
	}
	
	/*
	 * Method: protected synchronized void setBookName(String bookName)
	 * 
	 * takes one argument of type String
	 * returns nothing
	 * 
	 * Used for setting the Book Name in String bookName data member
	 */
	protected void setBookName(String bookName){
		
		this.bookName=bookName;
	}
	
	/*
	 * 
	 * main() method 
	 * throws InterruptedException,IOException
	 */

	public static void main(String[] args )throws InterruptedException, IOException{
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String name;
		
		/*
		 * provide name of Book 1 as input 
		 */
		
		Books book1=new Books();
		System.out.println("Enter a Book Name:  ");
		name=reader.readLine();
		book1.setBookName(name);
		
		/*
		 * provide name of Book 2 as input
		 */

		Books book2=new Books();
		System.out.println("Enter a Book Name:  ");
		name=reader.readLine();
		book2.setBookName(name);
		//creating 200 threads which start writing a file
	    for(int counter=0;counter<100;counter++){
		 
		    new Thread(book1).start();	 
		    new Thread(book2).start();
		    
	    }
	}
	
	
	/*
	 * Method: public void run()
	 * returns nothing, 
	 * returns no arguments
	 * overrides public void run() of Runnable interface
	 * 
	 * used for writing the Book Names on a file
	 */
	public void run() {
		try{
		     file=new FileWriter("BookName.txt",true);
			file.write("\n\n");
			file.write("\n\nBookName : "+this.getBookName()+"  " );
			
		}catch(FileNotFoundException exception){
			
			System.out.println(exception.getMessage()+" Create a new file");
		}
		catch(IOException ioException){
			
			System.out.println(ioException.getMessage());
		}
           finally{
                file.flush();
                file.close();
                   
           }
		
	}


}
