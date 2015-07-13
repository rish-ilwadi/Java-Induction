package Library;

/*
 * package Library
 * public interface ICalculate
 * 
 * Contains abstract methods for calculating Total Price of Books
 */

public interface ICalculate {

	/*
	 * Method compareBooks()
	 * Access Specifier public
	 * Abstract
	 * Used for providing comparison between two books
	 * Takes Books type Object as input 
	 * returns nothing
	 */
	public void compareBooks(Books b);
}
