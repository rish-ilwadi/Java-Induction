package OptimusBank;

/*
 * 
 * public class WrongAccountTypeException 
 * extends java.io.Exception
 * 
 */
public class WrongAccountTypeException extends Exception {


	/**
	 * EmployeeException class used for generating Excetions which occur during calculation of 
	 * Employee's Salary or during cLeaves Count
	 */
	private static final long serialVersionUID = 787172381237074711L;
    
	/*
	 * A default constructor public WrongAccountTypeException()
	 * for generating exception without a message
	 */
	public WrongAccountTypeException(){
		super();
	}
	/*
	 * A parameterized Constructor: public WrongAccountTypeException(String Message)
	 * takes one argument of type String.
	 * 
	 * Used for generating exception with a user defined message
	 */
	public WrongAccountTypeException(String message){
		super(message);
	}
}
