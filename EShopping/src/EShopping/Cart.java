package EShopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cart
 * 
 * Used for performing various operations on Cart maintained as a LinkedHashMap
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
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
		HttpSession session;
		session=request.getSession();
		long productId;
		int quantity;
		int totalQuantity=0;
		productId=Long.parseLong(request.getParameter("products"));
		quantity=Integer.parseInt(request.getParameter("quantity"));
		LogIn newLogIn;
		
		newLogIn=(LogIn)session.getAttribute("LogIn");
		Connection connect;
		ResultSet set;
		try {
			connect=newLogIn.connectionString();
		
			Statement statement=connect.createStatement();
			set=statement.executeQuery("SELECT quantity FROM Product_Details WHERE product_id="+productId);
			while(set.next()){
		
				totalQuantity=set.getInt(1);
			}
		
			Cart cart;
			cart=new Cart();

			if(quantity > 0 && quantity <= totalQuantity){
			
				Map map=cart.addToCart(productId, quantity, session);
				cart.updateInventory(session);
				response.sendRedirect("ViewCart.jsp");
			
			}else{
			
				response.sendRedirect("Home.jsp");
			}	
		} catch (ClassNotFoundException | SQLException e) {
			
			response.sendRedirect("Error.jsp");
		}	    
	}
	/*
	 * method: public Map addToCart(long productId,int quantity,HttpSession session)
	 * 
	 * Used for adding the product & its quantity to the cart maintained as a HashMap
	 */
	public Map addToCart(long productId,int quantity,HttpSession session){
		Map map;
		long mapProductId=0;
		int previousQuantity=0;
		map=(Map)session.getAttribute("Cart");
		Iterator iterator=map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry entry=(Entry) iterator.next();
			mapProductId=(long)entry.getKey();
			previousQuantity=(int)entry.getValue();
			if(mapProductId==productId){
				quantity=previousQuantity+quantity;
				
			}
		}
		map.put(productId,quantity);
		session.setAttribute("Cart",map);
		return map;
	}
	/*
	 * method: public void viewCart(HttpSession session, PrintWriter out)throws ClassNotFoundException, SQLException
	 * 
	 * Used for displaying the conetents of the cart & calculating the total price
	 * 
	 */
	public void viewCart(HttpSession session, PrintWriter out)throws ClassNotFoundException, SQLException{
		Map map;
		ResultSet set;
		map=(Map)session.getAttribute("Cart");
		LogIn newLogIn;
		newLogIn=(LogIn)session.getAttribute("LogIn");
		long productId;
		int quantity;
		Connection connect;
		connect=newLogIn.connectionString();
		double totalPrice=0;
		double price;
		Iterator iterator=map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry entry=(Entry) iterator.next();
			productId=(long)entry.getKey();
			quantity=(int)entry.getValue();
			Statement statement=connect.createStatement();
			set=statement.executeQuery("SELECT product_name,price FROM Product_Details WHERE product_id="+productId);
		    while(set.next()){
		    	out.println("<br><tr><td>"+set.getString(1)+"</td><td>"+set.getFloat(2)+"</td><td>"+quantity+"</td></tr></table>");
		    	price=set.getFloat(2);
		    	totalPrice+=(price*quantity);
		    	
		    }
		}    
		out.println("<br><tr>Total Price=</tr>"+totalPrice);
		
	}
	/*
	 * method: public void updateInventory(HttpSession session)
	 * 
	 * Used for updating the inventory as the person has put various items into his cart
	 */
	public void updateInventory(HttpSession session){
		
		ResultSet set;
		LogIn newLogIn;
		newLogIn=(LogIn)session.getAttribute("LogIn");
		Connection connect;
		try {
			connect=newLogIn.connectionString();
		
			Map map=(Map)session.getAttribute("Cart");
			long productId;
			int quantity;
			int totalQuantity=0;
			Iterator iterator=map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry entry=(Entry) iterator.next();
				productId=(long)entry.getKey();
				quantity=(int)entry.getValue();
				Statement statement=connect.createStatement();
				set=statement.executeQuery("SELECT quantity FROM Product_Details WHERE product_id="+productId);
				while(set.next()){
			
					totalQuantity=set.getInt(1);
			
					if(quantity <= totalQuantity && totalQuantity > 0){
				
						totalQuantity=totalQuantity-quantity;
					}	
			
				
				}
				statement.executeUpdate("UPDATE Product_Details SET quantity="+totalQuantity+" WHERE product_id="+productId);
			}
		} catch (ClassNotFoundException | SQLException exception) {
				
		}
		
	}

}
