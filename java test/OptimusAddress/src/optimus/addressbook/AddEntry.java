package optimus.addressbook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEntry
 */
@WebServlet("/addentry")
public class AddEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PrintWriter out;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
		out.println("GET Method implementation");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname;
		String lname;
		long phoneNo;
		String address;
		String email;
		fname = request.getParameter("fname");
		lname = request.getParameter("lname");
		phoneNo = Long.parseLong(request.getParameter("phoneNo"));
		address = request.getParameter("address");
		email = request.getParameter("email");
		
		String check = new AddressDAO().addEntry(fname, lname, phoneNo, address, email);
		if(check.equals("Done")){
			response.sendRedirect("adminhome.jsp");
		}
		else{
			response.sendRedirect("error.jsp");
		}
	}

}
