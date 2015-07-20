<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="EShopping.LogIn"%>
    <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E Shopping</title>
</head>
<body>
<h1>E Shopping</h1>
<br><br>
<p>Welcome&nbsp;<%
	LogIn newLogIn;
	newLogIn=(LogIn)session.getAttribute("LogIn");
	out.println(newLogIn.getEmail());
%><p>
<form method="post" action="ShowProducts">
Categories&nbsp;&nbsp;
<%
	ResultSet set;
	newLogIn=(LogIn)session.getAttribute("LogIn");
	set=newLogIn.catalogue();
	while(set.next()){
%>
	<input type="radio" name="categories" value=<% out.print(set.getString(1)); %>><% out.print(set.getString(2)); %>&nbsp;&nbsp;
<% 
	} 
%>
<input type="Submit" value="Show Products">
</form>
</body>
</html>