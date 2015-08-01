<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Optimus Records Client</title>
</head>
<body>
	
		<h1>Optimus Records</h1>
		<form action = "optimus/client/v1/addemployee" method="post">
			Admin User Name&nbsp;&nbsp;<input type = "text" name = "userName" placeholder = "Admin User Name"><br/>
			Admin Password&nbsp;&nbsp;<input type = "password" name = "password" placeholder = "Password"><br/>
			Employee Name &nbsp;&nbsp;<input type = "text" name = "employeeName" placeholder = "Enter employee name"><br/>
			Email&nbsp;&nbsp;<input type = "email" name = "email" placeholder = "Email">&nbsp;&nbsp;<br/>
			Mobile No&nbsp;&nbsp;<input type = "text" name = "mobileNo" placeholder = "Enter Mobile No."><br/>
			Salary&nbsp;&nbsp;<input type = "text" name = "salary" placeholder = "Enter salary"><br/>
			Address&nbsp;&nbsp;<input type = "text" name = "address" placeholder = "Enter address"><br/><br/>
			<input type = "submit" value = "Add Employee">
		</form>
</body>
</html>