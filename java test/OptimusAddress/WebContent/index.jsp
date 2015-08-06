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
	
	<center><h2>Log In</h3>
	
<center><h3>Guest Login</h3>
	<table>
	<form method = "Post" action = "guestlogin">
	<tr><td><input type = "email" name = "email" placeholder = "Enter your email"></td></tr>
	<tr><td><input type = "password" name = "password" placeholder = "Password"></td></tr>
	<tr><td><center><input type = "submit" value = "Log In"></center></td></tr>
	</form>
	</table>
	</center>
<br/><br/>	
<center><h3>Admin Login</h3>
	<table>
	<form method = "Post" action = "adminlogin">
	<tr><td><input type = "email" name = "email" placeholder = "Admin's email"></td></tr>
	<tr><td><input type = "password" name = "password" placeholder = "Admin's Password"></td></tr>
	<tr><td><center><input type = "submit" value = "Log In"></center></td></tr>
	</form>
	</table>
	</center>
	
</body>
</html>