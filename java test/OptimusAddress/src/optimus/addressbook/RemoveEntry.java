package optimus.addressbook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveEntry
 */
@WebServlet("/removeentry")
public class RemoveEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PrintWriter out;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
		out.println("GET Method implementation");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname;
		String lname;
		String email;
		fname = request.getParameter("fname");
		lname = request.getParameter("lname");
		email = request.getParameter("email");
		int check;
		check = new AddressDAO().removeEntry(fname,lname,email);
		if(check < 1){
			response.sendRedirect("error.jsp");
		}
		else{
			response.sendRedirect("adminhome.jsp");
		}
	}

}
