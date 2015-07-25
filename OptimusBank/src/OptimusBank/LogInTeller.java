package OptimusBank;

import OptimusBank.CustomerDB;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogInTeller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email;
		String password;
		email=request.getParameter("email");
		password=request.getParameter("password");
		int check;
		CustomerDB checkUser=new CustomerDB();
		check=checkUser.checkLogIn(email,password);
		if(check>0){
			response.sendRedirect("Home.jsp");
		}
		else{
			response.sendRedirect("Error.jsp");
		}
		
	}

}
