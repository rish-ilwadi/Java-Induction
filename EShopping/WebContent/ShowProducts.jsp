<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="EShopping.LogIn"%>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="EShopping.ShowProducts" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EShopping</title>
</head>
<body>
   <h1>EShopping</h1>
   <br><br>
   <p>Welcome <%
		LogIn newLogIn;
		newLogIn=(LogIn)session.getAttribute("LogIn");
		out.println(newLogIn.getEmail());
   %><p><br><br>
   <p>Products in category:&nbsp;
   <%
   	long categoryId;

    categoryId=Long.parseLong(request.getParameter("category"));
    ResultSet set;
    ShowProducts products;
    products=new ShowProducts();
    set=products.presentCategory(categoryId,session);
    while(set.next()){
    	out.println(set.getString(1));
    }
   %><center>
   <br><br>
   <table><form method="post" action="Cart">
   <tr><td>Product Name</td><td>Category</td><td>Price</td><td>Quantity Available</td><td></td><td>Enter quantity</td></tr>
   <%
   		set=products.showProducts(categoryId,session);
   while(set.next()){
	   
	   %><tr><td><%=set.getString(2)%></td>&nbsp;&nbsp;<td><%=set.getString(3)%></td>&nbsp;&nbsp;<td><%=set.getString(4)%></td>&nbsp;&nbsp;<td><%=set.getString(5)%></td>&nbsp;&nbsp;<td><input type="radio" name="products" value=<%=set.getLong(1)%>> </td>&nbsp;&nbsp;
	   
<% 	             
   }
  %>
  <tr><td><input type="text" name="quantity" placeholder="Enter Quantity"></td></tr>
  <tr><td><input type="Submit" value="Add to Cart"></td></tr>
 </form>
 </table></center>
 <br><br>
 <form method="post" action="ShowProducts">
Other Categories&nbsp;&nbsp;
<%
	set=products.showOtherCategories(categoryId,session);
	while(set.next()){
%>
	<input type="radio" name="categories" value=<% out.print(set.getString(1)); %>><% out.print(set.getString(2)); %>&nbsp;&nbsp;
<% 
	} 
%>
<input type="Submit" value="Show Products">
</form>
<a href="Home.jsp">Back</a>&nbsp;&nbsp;<a href="ViewCart.jsp">View Cart</a> 
</body>
</html>