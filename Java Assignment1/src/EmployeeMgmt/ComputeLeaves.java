package EmployeeMgmt;

/*
 * package EmployeeMgmt
 * imports java.lang package
 * public abstract class ComputeLeaves
 * 
 * implements ICalculateLeaves
 * 
 * Provides body for method countLeaves()
 * 
 * Contains abstract method calcSalary()
 * 
 * Contains a final static data member MaxLeaves with value=15
 * 
 */

public abstract class ComputeLeaves implements ICalculateLeaves {
	
	
	private final static int maxLeaves=15; //A constant MaxLeaves with value 15
	private int leaves; //Data Member for storing Leaves Taken
	/*
	 * Method: public abstract double calcSalary(double,int,int,int)
	 * takes 4 arguments
	 * returns double
	 * 
	 * Standard method for calculating the salary
	 */
	public abstract double calcSalary(double basicSalary,int hra,int da,int pf);
	/*
	 * Method: public int countLeaves(int)
	 * takes 1 argument Leave Request
	 * and returns an integer with value 0 or 1 for Leave Acceptance
	 * 
	 * Used for counting the leaves
	 */
	public int countLeaves(int leavesRequest){
		
		if ((this.leaves+leavesRequest)>maxLeaves){
			return 0;
	    }
		else{
			
		    this.leaves=this.leaves+leavesRequest;
		}
		
		return 1;
	}
	
	/*
	 * Method: public int getLeaves()
	 * returns integer, no. of Leaves taken
	 * takes no argument
	 */
	public int getLeaves(){
		
		return this.leaves;
	}
}
