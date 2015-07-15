package Collections;

/*
 * 
 * 
 */
import java.util.*;
import java.io.*;
public class Books {
  
	private String bookName;
	private int bookNo;
	private double price;
	 /*
     * Method: getBookName()
     * returns String.
     * Access Specifier: protected
     * Used for receiving the BookName.
     */
    protected String getBookName(){
    	return bookName;
    }
    /*
     * Method: getBookNo()
     * returns int.
     * Access Specifier: protected
     * Used for receiving the BookNo
     */
    protected int getBookNo(){
    	return bookNo;
    }
    /*
     * Method: getPrice()
     * returns int
     * Access Specifier: protected
     * returns the price of the book
     */
    protected double getPrice(){
    	return price;
    }
	/*
     * Method: setBook(String,int,int)
     * setBook() Overloaded
     * takes 3 arguments, BookName-String, BookNo-int,Price-int.
     * returns nothing.
     * Access Specifier: public
     * throws ArithmeticException
     * 
     * Used for setting the details of Books.
     * throws ArithmeticException
     * 
     */
	public void setBook(String bookName,int bookNo,double price){
		
        if(bookNo<10000||bookNo>99999){
            throw new ArithmeticException("BookNo OUT OF RANGE"); //Throws ArithmeticException when BookNo is out of Range [10000,99999]
	    }
	    else if(price<0){
	    	throw new ArithmeticException("Negative Price Not Accepted"); //Throws ArithmeticException when Price is Negative
	    }
	    else{
	    	this.bookName=bookName;
	        this.bookNo=bookNo;
	        this.price=price;
	    }
		
    }
	/*
	 * main() method 
	 * throws IOException
	 */
	public static void main(String []args)throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //Used for taking Inputs as Book Details from the user
		String bookName;
		int bookId;
		double price;
		int counter; //For Taking No. of books as input
		System.out.println("Enter No of Books to be added");
		counter=Integer.parseInt(reader.readLine());
		ArrayList <Books>list  = new <Books> ArrayList(); //For Storing various Books
		//Taking various books as inputs & adding them to the List
		//can throw ArithmeticException on ID & Price
		while(counter>0){
			try{
				System.out.println("Enter Book Name");
				bookName=reader.readLine();
				System.out.println("Enter Book Id");
				bookId=Integer.parseInt(reader.readLine());
				System.out.println("Enter Price");
				price=Double.parseDouble(reader.readLine());
	             Books book=new Books();
		        book.setBook(bookName, bookId, price);
				list.add(book);
				counter--;
			}catch(ArithmeticException exception){
			    
				System.out.println(exception.getMessage());
			}
			catch(NullPointerException except){
				
				System.out.println(except.getMessage());
			}
		    
		}
		ShowBook show=new ShowBook(); 
		show.displayBook(list);//Displays the contents in the ArrayList
		reader.close();
		
		
		
	}

	
}
