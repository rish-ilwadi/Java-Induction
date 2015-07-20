package EShopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	

    private String email;
	private String password;
	public Map <Long,Integer>map; 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
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
		// TODO Auto-generated method stub
		
		LogIn newLogIn;
		newLogIn=new LogIn();

		String email; 
		email=request.getParameter("email");
		String password;
		password=request.getParameter("password");
		newLogIn.setEmail(email);
		newLogIn.setPassword(password);
		HttpSession session;
		Connection connection = null;
		try{
			
			connection=newLogIn.connectionString();
			PreparedStatement statement=connection.prepareStatement("SELECT email,password FROM User_Details WHERE email=? AND password=?");
			statement.setString(1,newLogIn.getEmail());
			statement.setString(2,newLogIn.getPassword());
			ResultSet set=statement.executeQuery();
			if(set.next()){
				session=request.getSession();
				session.setAttribute("LogIn",newLogIn);
				newLogIn.map=new LinkedHashMap();
				session.setAttribute("Cart",newLogIn.map);
				response.sendRedirect("Home.jsp");
			}
			else{
				response.sendRedirect("LoginFailed.jsp");
			}
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
	public Connection connectionString()throws ClassNotFoundException,SQLException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url;
		url="jdbc:sqlserver://localhost:1433;databaseName=EShopping;user=sa;password=optimus@123";
		
        Connection connection = DriverManager.getConnection(url);
        return connection;
		
	}
	public ResultSet catalogue()throws ClassNotFoundException,SQLException{
		
		Connection connect;
		connect=this.connectionString();
		Statement statement=connect.createStatement();
		ResultSet set=statement.executeQuery("Select category_id, category_name from Product_Categories");
		return set;
		
    }
}


