package EShopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CancelShopping
 * 
 * Used for performing the rollbacks after the client has requested for cancellation of shopping
 */
@WebServlet("/CancelShopping")
public class CancelShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelShopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session;
		session=request.getSession();
		LogIn newLogIn=(LogIn)session.getAttribute("LogIn");
		int quantity;
		int totalQuantity=0;
		long productId;
		ResultSet set;
		Connection connect = null;
		try {
			connect=newLogIn.connectionString();
		
			Map map=(Map)session.getAttribute("Cart");
			Iterator iterator=map.entrySet().iterator();
			/*
			 * Updating the quantity by adding the quantity of items of User's cart & emptying the cart
			 */
			while(iterator.hasNext()){
				Map.Entry entry=(Entry) iterator.next();
				productId=(long)entry.getKey();
				quantity=(int)entry.getValue();
				Statement statement=connect.createStatement();
				set=statement.executeQuery("SELECT quantity FROM Product_Details WHERE product_id="+productId);
				while(set.next()){
			
					totalQuantity=set.getInt(1);
					totalQuantity+=quantity;
					
				}
				statement.executeUpdate("UPDATE Product_Details SET quantity="+totalQuantity+" WHERE product_id="+productId);
			}
			map.clear();
			response.sendRedirect("Home.jsp");
		}catch(ClassNotFoundException | SQLException exception){
			exception.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
