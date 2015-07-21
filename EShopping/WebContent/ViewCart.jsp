<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="EShopping.LogIn"%>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="EShopping.ShowProducts" %>
    <%@ page import="EShopping.Cart" %>
    <%@ page import="java.io.PrintWriter" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EShopping</title>
</head>
<body>

<h1>E Shopping</h1>
<br><br>
<p>Welcome&nbsp;<%
	LogIn newLogIn;
	newLogIn=(LogIn)session.getAttribute("LogIn");
	out.println(newLogIn.getEmail());
%><p>

<p>View Cart</p>
<br><br>
<center><table>
<tr><td>Product Name</td><td>Price</td><td>Quantity</td><br>
<%
	PrintWriter output=response.getWriter();
    Cart cart;
	cart=new Cart();
	cart.viewCart(session,output);
	
%>

<a href="Home.jsp">Add More Products</a>&nbsp;&nbsp;<a href="Checkout.jsp">Proceed to CheckOut</a>&nbsp;&nbsp;<a href="CancelShopping">Cancel Shopping</a>

</body>
</html>