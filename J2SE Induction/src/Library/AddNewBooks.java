package Library;

import java.io.*;

/*
 * Package Name: Library 
 * Imports java.lang,java.io Package
 * 
 * public class AddNewBooks:
 * 
 * Used for adding details of New Books
 * Reads 3 values from command Line
 * Contains main()  
 * 
 */
public class AddNewBooks {
	
	/* 
	 * Main Function
	 */
	public static void main(String [] args)throws IOException{
		
		 
		/*
		 * try-catch-finally blocks for
		 * catching ArithmeticException thrown by setBook() method of class Books
		 */
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		    Books b=new Books();
		    String BookName;
		    BookName=br.readLine();
		    int BookNo;
		    BookNo=Integer.parseInt(br.readLine());
		    int BookPrice;
		    BookPrice=Integer.parseInt(br.readLine());
		    b.setBook(BookName,BookNo,BookPrice); //Adding Book "Head First-Kathy Sierra"
		    
		    //setBook() throws ArithmeticException
		    
	        System.out.println("Books Added\n\n");
	        System.out.println(b.getBookName()+" "+b.getBookNo()+" "+b.getPrice());
		    GetBooks g=new GetBooks();
	        g.setBook("SCJP-Kathy Sierra",12345); //Method setBook() of class Books implemented using GetBooks() through Inheritence
	        
	        //setBook() throws ArithmeticException
	        
	        System.out.println("Books Added\n\n");
	        g.showBookDetails();
	        System.out.println("\n\n");
	        g.compareBooks(b);
	        
		}catch(ArithmeticException ae){
			System.out.println(ae.getMessage()); //
		}
		finally{
			System.out.println("Done!!");
		}
	}

}
