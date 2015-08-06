<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Optimus Address Book </title>
</head>
<body>
<center><h1>Optimus Address Book</h1></center>
<center><h2>Search</h2></center>
<form method = "post" action = "search">
Search:<input type = "text" name = "search">&nbsp;&nbsp;
Sort by:&nbsp;&nbsp;
First Name<input type = "radio" name = "sort by" value ="fname">&nbsp;&nbsp;Last Name<input type = "radio" name = "sort by" value ="lname">
<input type = "submit" value = "Search">
</form>
<br/><br/>
<center><a href = "getentry.jsp">Get Particular Entry</a>
</body>
</html>