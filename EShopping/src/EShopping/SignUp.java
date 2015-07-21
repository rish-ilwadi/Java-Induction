package EShopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUp
 * 
 * Used for registering a person's records into the database
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
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
		

		PrintWriter out;
		out=response.getWriter();
		String name;
		String address;
		String gender;
		long mobile;
		String email;
		String password;
		name=request.getParameter("Name");
		address=request.getParameter("Address");
	    mobile=Long.parseLong(request.getParameter("Mobile"));
	    gender=request.getParameter("Gender");
		email=request.getParameter("email");
		password=request.getParameter("pass");
		HttpSession session;
		Connection connection = null;
		LogIn newLogIn;
		newLogIn=new LogIn();
		try{
			connection=newLogIn.connectionString();
			PreparedStatement statement=connection.prepareStatement("INSERT INTO User_Details(Name,email,password,Address,Mobile,Gender)VALUES(?,?,?,?,?,?)");
			statement.setString(1,name);
			statement.setString(2,email);
			statement.setString(3,password);
			statement.setString(4,address);
			statement.setLong(5,mobile);
			statement.setString(6,gender);
			statement.executeUpdate();
			
			response.sendRedirect("Register.jsp");
			
		
		} catch(ClassNotFoundException exception){
			//out.println("Error occured in connecting to the database. "+exception.getMessage());
			//response.sendRedirect("Error.jsp");
			exception.printStackTrace();
		}
		catch(SQLException sql){
			
			//response.sendRedirect("Error.jsp");
			sql.printStackTrace();
		}
		finally{
			try {
				connection.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				//out.println("Error occured in connecting to the database. "+sqlException.getMessage());
			//	response.sendRedirect("Error.jsp");
			}
			catch(NullPointerException nullPointer){
				//out.println("Error occured in connecting to the database. "+nullPointer.getMessage());
				nullPointer.printStackTrace();
			}
		}
	}

}
