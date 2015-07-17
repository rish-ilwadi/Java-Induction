package counter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogIn
 * Used for counting the no of logged in users
 */
@WebServlet("/LogIn")

public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected static ArrayList <HttpSession>list=new <HttpSession>ArrayList();
    /**
     * Default constructor. 
     */
    public LogIn() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		String email;
		String password;
		int counter;
		counter=1;
		/*
		 * Value of email & password received using request.getParameter()
		 */
		email=request.getParameter("email");      
		password=request.getParameter("password");
		HttpSession session;
		ListIterator<HttpSession> iterator=list.listIterator();
		session=request.getSession(); //creating a HttpSession
		session.setAttribute("email", email); 
		session.setMaxInactiveInterval(5);
		list.add(session);
		counter=list.size();
		

	  response.sendRedirect("Welcome.jsp?counter="+counter);
	}	

}

   