package EmployeeMgmt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*
 * package EmployeeMgmt
 * imports java.lang, java.IOBufferedReader, java.io.InputStreamReader, java.io.IOException
 * public class EmployeeSalaryAndLeaves extends abstract class ComputeLeaves
 * 
 * Used for calculating the salary and compute leaves of the Employee in an organisation
 * 
 * Contains main() function
 * 
 *
 */

public class EmployeeSalaryAndLeaves extends ComputeLeaves {
	
	private double salary; // A data member for storing the salary
	
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
    public double calcSalary(double basicSalary,int hra,int da,int pf){
    
    	return (basicSalary+hra+da-pf);
    }
	
    /*
     * main() function. 
     * Uses BufferedReader for inputs, throws IOException
     * User to provide inputs Basic Salary,HRA,DA,PF and Leave Request
     */
	public static void main(String[] args)throws IOException {
		
		try{
		    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		    double basicSalary;
		    int hra;
		    int da;
		    int pf;
		    /*
		     * Provide Inputs for Basic Salary, HRA, DA, PF
		     */
		    System.out.println("Enter Basic Salary:\n");
		    basicSalary=Double.parseDouble(reader.readLine());
		    System.out.println("Enter HRA:\n");
		    hra=Integer.parseInt(reader.readLine());
		    System.out.println("Enter DA:\n");
		    da=Integer.parseInt(reader.readLine());
		    System.out.println("Enter PF:\n");
		    pf=Integer.parseInt(reader.readLine());
		    /*
		     * If Basic Salary less then HRA or DA or PF 
		     * then Throw an EmployeeException
		     */
		    
		    if(basicSalary < hra || basicSalary< da || basicSalary < pf){
		    	throw new EmployeeException("Basic Salary cant be less than HRA,DA or PF");
		    }
		    
		    /*
		     * If Basic Salary or HRA or DA or PF is negative
		     * then Throw an EmployeeException
		     */
		    
		    if(da < 0 || hra < 0 || basicSalary < 0 || pf < 0){
	    		throw new EmployeeException("(Basic Salary,HRA,DA,PF) cant be negative");
	    	}

		    EmployeeSalaryAndLeaves employee=new EmployeeSalaryAndLeaves();
		    employee.salary=employee.calcSalary(basicSalary,hra,da,pf); //Call calcSalary() method to calculate the salary		    
		    	    
		    int leaveRequest;
		    /*
		     * Provide Input for Leave Request
		     */
		    System.out.println("Enter No. of Leaves request: ");
		    
		    
		    leaveRequest=Integer.parseInt(reader.readLine());
            /*
             * If Leave Request out of range [1,15]	then throw an EmployeeException	    
             */
		    if(leaveRequest<=0||leaveRequest>15){
		    	
		    	throw new EmployeeException("Leave Request should be between [1-15]");
		    }
		    	
		    ComputeLeaves leaves=new EmployeeSalaryAndLeaves();
		    
		    int leaveAcceptance=0;
		    leaveAcceptance=leaves.countLeaves(leaveRequest); //Call for method countLeaves implemented in abstract class ComputeLeaves
		    System.out.println("Salary="+employee.salary);
		    if(leaveAcceptance==0){
		    	System.out.println("\n\nLeaves Cross Max Leaves Limit.\nRequest Cant be Accepted");
		    }
		    else if(leaveAcceptance==1){
		    	System.out.println("\n\nLeaves Request Accepted.\nLeave Granted.\nTotal Leaves Consumed="+leaves.getLeaves());
		    }
		    /*
		     * If leaveAcceptance !=0 or 1 then throw an EmployeeException
		     */
		    else{
		    	throw new EmployeeException("Wrong Value Returned For Leave Acceptance");
		    }
	
		    		    
		 }catch(EmployeeException exception){
			
			System.out.println(exception.getMessage());
		}
		finally{
			System.out.println("Done!!");
		}
		
	}
		
}


