package optimus.addressbook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetEntry
 */
@WebServlet("/getentry")
public class GetEntry extends HttpServlet {
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
		
		Address address;
		address = new AddressDAO().getEntry(fname, lname, email);
		HttpSession session = request.getSession();
		session.setAttribute("Address", address);
		response.sendRedirect("addressdetails.jsp");
		
	}

}
