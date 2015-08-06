<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Optimus Address Book</title>
</head>
<body>
<center><h1>Optimus Address Book</h1></center>
<center><h2>Get Particular Entry</h2></center>
<br/><br/>
<center>
<form method = "post" action = "getentry">
First Name: <input type = "text" name = "fname" id = "fname" placeholder = "Your First Name">&nbsp;&nbsp;
Last Name:<input type = "text" name = "lname" id = "lname" placeholder = "Your Last Name">&nbsp;&nbsp;
Email:<input type = "email" name = "email" id = "email" placeholder = "Your email">
<center><input type = "submit" value = "Get Entry"></center></td></tr>
</form>

<br/>
<br/></center>
<center><a href = "search.jsp">Search</a>
</center>
</body>
</html>