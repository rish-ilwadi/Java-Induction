package EShopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowProducts
 * Contains methods used for displaying the products in each category
 */
@WebServlet("/ShowProducts")
public class ShowProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private long categoryId;
       
    public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProducts() {
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
	
	      long categoryId=Long.parseLong(request.getParameter("categories"));
	      response.sendRedirect("ShowProducts.jsp?category="+categoryId);
		
	}
	/*
	 * method: public ResultSet showProducts(long categoryId,HttpSession session)
	 * 
	 * Used for displaying the products in each category. Takes category Id & session as input
	 */
			
	public ResultSet showProducts(long categoryId,HttpSession session){
		
		Connection connect;
		LogIn newLogIn;
		newLogIn=(LogIn)session.getAttribute("LogIn");
		try {
			connect=newLogIn.connectionString();
		
			Statement statement=connect.createStatement();
			ResultSet set=statement.executeQuery("SELECT product_id, product_name,category_name,price,quantity FROM Product_Details	INNER JOIN Product_Categories ON Product_Details.category_id="
				+ "Product_Categories.category_id WHERE Product_Details.category_id="+categoryId);
			return set;
		} catch (ClassNotFoundException | SQLException exception) {
			
			return null;
		}

	}
	/*
	 * method: public ResultSet presentCategory(long categoryId,HttpSession session)
	 * 
	 * Used for getting the name of the present selected category
	 */
	public ResultSet presentCategory(long categoryId,HttpSession session){
		
		Connection connect;
		LogIn newLogIn;
		newLogIn=(LogIn)session.getAttribute("LogIn");
		try {
			connect=newLogIn.connectionString();
		
			Statement statement=connect.createStatement();
			ResultSet set=statement.executeQuery("SELECT category_name FROM Product_Categories WHERE category_id="+categoryId);
			return set;
		} catch (ClassNotFoundException | SQLException exception) {
			
			return null;
		}
		
		

	}
	/*
	 * method: public ResultSet showOtherCategories(long categoryId,HttpSession session)
	 * 
	 * Used for getting the categories other than the selected category 
	 * 
	 */
	public ResultSet showOtherCategories(long categoryId,HttpSession session){
		
		Connection connect;
		LogIn newLogIn;
		newLogIn=(LogIn)session.getAttribute("LogIn");
		try {
			connect=newLogIn.connectionString();
		
			Statement statement=connect.createStatement();
			ResultSet set=statement.executeQuery("SELECT * FROM Product_Categories WHERE category_id <>"+categoryId);
			return set;
		} catch (ClassNotFoundException | SQLException exception) {
			
			return null;
		}
	}

}
