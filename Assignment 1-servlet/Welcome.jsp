<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In Counter</title>
</head>
<body>
<br><br><br>
<%
HttpSession logSession=request.getSession();
out.println(logSession.getAttribute("email"));
%>
<br><br>
<center><p>Log In Counter=<%
	String counter;
    counter=request.getParameter("counter");
	out.println(counter);
	if(logSession.getAttribute("email").equals(null)){
	      response.sendRedirect("Index.jsp");
	}%>
</p></center>
</body>
</html>