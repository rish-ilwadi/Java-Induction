package Collections;
/*
 * package Collections 
 * public class ShowBook
 * 
 * Used for displaying the details of Books stored in ArrayList
 */
import java.util.*;
public class ShowBook {
    
	private Books book;
	/*
	 * method: public void displayBook(ArrayList <Books>list)
	 * takes an ArrayList of Books objects as Input
	 * 
	 * Used for displaying various Books.
	 */
	public void displayBook(ArrayList <Books>list){
		
		Iterator <Books>iterator=list.iterator();
		while(iterator.hasNext()){
			book=(Books)iterator.next();
			System.out.println("Book Name: "+book.getBookName()+"\nBook No: "+book.getBookNo()+"\nBook Price:"+book.getPrice());
		}
	}
	
}
