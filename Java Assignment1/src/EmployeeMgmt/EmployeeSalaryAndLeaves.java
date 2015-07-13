package EmployeeMgmt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*
 * package EmployeeMgmt
 * imports java.lang, java.IOBufferedReader, java.io.InputStreamReader, java.io.IOEXception
 * public class EmployeeSalaryAndLeaves extends abstract class ComputeLeaves
 * 
 * Used for calculating the salary and compute leaves of the Employee in an organisation
 * 
 * Contains main() function
 * 
 *
 */

public class EmployeeSalaryAndLeaves extends ComputeLeaves {
	
	private double Salary; // A data member for storing the salary
	
	/*
	 *Method: public double calcSalary(double,int,int,int)
	 *returns double and takes 4 arguments. 
	 * 
	 * Extended by class EmployeeSalaryAndLeaves
	 * Abstract method of class ComputLeaves
	 * 
	 * Used for calculating the salary of employees
	 * 	 
	 * 
	 */
    public double calcSalary(double BasicSalary,int HRA,int DA,int PF){
    
    	return (BasicSalary+HRA+DA-PF);
    }
	
    /*
     * main() function. 
     * Uses BufferedReader for inputs, throws IOException
     * User to provide inputs Basic Salary,HRA,DA,PF and Leave Request
     */
	public static void main(String[] args)throws IOException {
		
		try{
		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		    double BasicSalary;
		    int HRA;
		    int DA;
		    int PF;
		    /*
		     * Provide Inputs for Basic Salary, HRA, DA, PF
		     */
		    System.out.println("Enter Basic Salary:\n");
		    BasicSalary=Double.parseDouble(br.readLine());
		    System.out.println("Enter HRA:\n");
		    HRA=Integer.parseInt(br.readLine());
		    System.out.println("Enter DA:\n");
		    DA=Integer.parseInt(br.readLine());
		    System.out.println("Enter PF:\n");
		    PF=Integer.parseInt(br.readLine());
		    /*
		     * If Basic Salary less then HRA or DA or PF 
		     * then Throw an EmployeeException
		     */
		    
		    if(BasicSalary<HRA||BasicSalary<DA||BasicSalary<PF){
		    	throw new EmployeeException("Basic Salary cant be less than HRA,DA or PF");
		    }
		    
		    /*
		     * If Basic Salary or HRA or DA or PF is negative
		     * then Throw an EmployeeException
		     */
		    
		    if(DA<0||HRA<0||BasicSalary<0||PF<0){
	    		throw new EmployeeException("(Basic Salary,HRA,DA,PF) cant be negative");
	    	}

		    EmployeeSalaryAndLeaves esl=new EmployeeSalaryAndLeaves();
		    esl.Salary=esl.calcSalary(BasicSalary,HRA,DA,PF); //Call calcSalary() method to calculate the salary		    
		    	    
		    int LeaveRequest;
		    /*
		     * Provide Input for Leave Request
		     */
		    System.out.println("Enter No. of Leaves request: ");
		    
		    
		    LeaveRequest=Integer.parseInt(br.readLine());
            /*
             * If Leave Request out of range [1,15]	then throw an EmployeeException	    
             */
		    if(LeaveRequest<=0||LeaveRequest>15){
		    	
		    	throw new EmployeeException("Leave Request should be between [1-15]");
		    }
		    	
		    ComputeLeaves cl=new EmployeeSalaryAndLeaves();
		    
		    int LeaveAcceptance=0;
		    LeaveAcceptance=cl.countLeaves(LeaveRequest); //Call for method countLeaves implemented in abstract class ComputeLeaves
		    System.out.println("Salary="+esl.Salary);
		    if(LeaveAcceptance==0){
		    	System.out.println("\n\nLeaves Cross Max Leaves Limit.\nRequest Cant be Accepted");
		    }
		    else if(LeaveAcceptance==1){
		    	System.out.println("\n\nLeaves Request Accepted.\nLeave Granted.\nTotal Leaves Consumed="+cl.getLeaves());
		    }
		    /*
		     * If LeaveAcceptance !=0 or 1 then throw an EmployeeException
		     */
		    else{
		    	throw new EmployeeException("Wrong Value Returned For Leave Acceptance");
		    }
	
		    		    
		 }catch(EmployeeException ee){
			
			System.out.println(ee.getMessage());
		}
		finally{
			System.out.println("Done!!");
		}
		
	}
		
}


