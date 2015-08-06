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
<center><h2>Add New Entry</h2></center>
<br/><br/>
<center>
<table>
<form method = "post" action = "addentry">
<tr><td>First Name:<input type = "text" name = "fname" id = "fname" placeholder = "Your First Name"></td></tr>
<tr><td>Last Name:<input type = "text" name = "lname" id = "lname" placeholder = "Your Last Name"></td></tr>
<tr><td>Phone No:<input type = "mobile" name = "phoneNo" id = "phoneNo" placeholder = "Your Phone No."></td></tr>
<tr><td>Address:<input type = "text" name = "address" id = "address" placeholder = "Your Address"></td></tr>
<tr><td>Email:<input type = "email" name = "email" id = "email" placeholder = "Your email"></td></tr>
<tr><td><center><input type = "submit" value = "Add Entry"></center></td></tr>
</form>
</table>
<br/>
<br/></center>
<center><a href = "adminhome.jsp">Home</a>
</center>
</body>
</html>