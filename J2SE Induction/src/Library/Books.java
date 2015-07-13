package Library;
/*
 * Package Name: Library
 * Imports java.lang Package
 * public Class Books
 * Used to store the details of books in the library
 * 
 */
public class Books {
	
	//Implementation of Encapsulation
	
	private String BookName;
	private int BookNo;
	private int Price;
	/*
	 * Default Constructor: Books()
	 */
	Books(){
		this.BookName="";
		this.BookNo=0;
		this.Price=0;
	}
	/*
	 * Constructor: Books(String,int),
	 * Takes Two Arguments: BookName-String, BookNo-int
	 * Used for initialization of BookName & BookNo 
	 */
    Books(String BookName, int BookNo,int Price){
    	this.BookName=BookName;
    	this.BookNo=BookNo;
    	this.Price=Price;
    }
    /*
     * Method: getBookName()
     * returns String.
     * Access Specifier: protected
     * Used for receiving the BookName.
     */
    protected String getBookName(){
    	return BookName;
    }
    /*
     * Method: getBookNo()
     * returns int.
     * Access Specifier: protected
     * Used for receiving the BookNo
     */
    protected int getBookNo(){
    	return BookNo;
    }
    /*
     * Method: getPrice()
     * returns int
     * Access Specifier: protected
     * returns the price of the book
     */
    protected int getPrice(){
    	return Price;
    }
    /*
     * Method: setBook(String,int)
     * takes 2 arguments, BookName-String, BookNo-int.
     * returns nothing.
     * Access Specifier: public
     * throws ArithmeticException
     * 
     * Used for setting the details of Books.
     * 
     */
    
	public void setBook(String BookName,int BookNo){
		
	        if(BookNo<10000||BookNo>99999){
	            throw new ArithmeticException("BookNo OUT OF RANGE"); //Throws ArithmeticException when BookNo is out of Range [10000,99999]
		    }
		    else{
		    	this.BookName=BookName;
		        this.BookNo=BookNo;
		    }
			
	}
	/*
     * Method: setbook(String,int,int)
     * setBook() Overloaded
     * takes 3 arguments, BookName-String, BookNo-int,Price-int.
     * returns nothing.
     * Access Specifier: public
     * throws ArithmeticException
     * 
     * Used for setting the details of Books.
     * 
     */
	public void setBook(String BookName,int BookNo,int Price){
		
        if(BookNo<10000||BookNo>99999){
            throw new ArithmeticException("BookNo OUT OF RANGE"); //Throws ArithmeticException when BookNo is out of Range [10000,99999]
	    }
	    else if(Price<0){
	    	throw new ArithmeticException("Negative Price Not Accepted"); //Throws ArithmeticException when Price is Negative
	    }
	    else{
	    	this.BookName=BookName;
	        this.BookNo=BookNo;
	        this.Price=Price;
	    }
		
    }

}

