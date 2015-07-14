package EmployeeMgmt;

/*
 * package EmployeeMgmt
 * import java.lang package
 * public class EmployeeException 
 * extends java.io.Exception
 * 
 */
public class EmployeeException extends Exception {


	/**
	 * EmployeeException class used for generating Excetions which occur during calculation of 
	 * Employee's Salary or during cLeaves Count
	 */
	private static final long serialVersionUID = 787172381237074711L;
    
	/*
	 * A default constructor public EmployeeException()
	 * for generating exception without a message
	 */
	public EmployeeException(){
		super();
	}
	/*
	 * A parameterized Constructor: public EmployeeException(String Message)
	 * takes one argument of type String.
	 * 
	 * Used for generating exception with a user defined message
	 */
	public EmployeeException(String message){
		super(message);
	}
}
