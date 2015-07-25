package OptimusBank;

import OptimusBank.CustomerDB;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpTeller
 */
@WebServlet("/SignUpTeller")
public class SignUpTeller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String customerName;
		String email;
		String password;
		char gender = 0;
		Date dateOfBirth=null;
		String address;
		String city;
		String state;
		String pin;
		String fax;
		String telephoneNo;
		int check;
		customerName=request.getParameter("customerName");
		email=request.getParameter("email");
		password=request.getParameter("password");
	//	gender=request.getParameter("gender");
		address=request.getParameter("address");
		city=request.getParameter("city");
		state=request.getParameter("state");
		pin=request.getParameter("pin");
		fax=request.getParameter("fax");
		telephoneNo=request.getParameter("telephoneNo");
		CustomerDB user=new CustomerDB();
		check=user.addUser(customerName,email,password,gender,address,city,state,pin,fax,telephoneNo,dateOfBirth);
		if(check>0){
			
			response.sendRedirect("Home.jsp");
		}
		else{
			response.sendRedirect("Error.jsp");
		}
		
	}

}
