package Library;

/*
 * package Library
 * imports java.lang
 * 
 * final class-Can't be inherited
 * public class GetBooks
 * extends class Books
 * 
 */
final class GetBooks extends Books implements ICalculate{
	
	/*
	 * Method showBookDetails
	 * returns nothing
	 * 
	 * Used to display Book Details
	 */
	public void showBookDetails(){
		String BookName;
		int BookNo;
		int Price;
		BookName=this.getBookName(); //Inherits Class Books, No need to create Object of Books class
		BookNo=this.getBookNo(); 
		Price=this.getPrice();
		System.out.println(BookName+" "+BookNo+" "+Price);
		
	}
	/*
	 * Method compareBooks()
	 * Access Specifier public
	 * Belongs to ICalculate Interface
	 * Implementation of compareBooks() method
	 * 
	 * Takes Books type Object as input 
	 * returns nothing
	 * 
	 * Used for providing comparison between two books based on Price
	 */
	
	public void compareBooks(Books b){
		
		int Price1; //To get Price of Book 1
		int Price2; //To get Price of Book 2
		Price1=this.getPrice();
		Price2=b.getPrice();
		/*
		 * Comparing Prices of two books
		 */
		if(Price1<Price2){
		    System.out.println(b.getBookName()+" is Costlier than "+this.getBookName());
		}	
		else if(Price1==Price2){
			System.out.println(b.getBookName()+" has same price as "+this.getBookName());
			
		}
		else{
			System.out.println(this.getBookName()+" is Costlier than "+b.getBookName());
		}
	}

}
