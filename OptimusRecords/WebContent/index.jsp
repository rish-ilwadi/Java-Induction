<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Optimus</title>
	</head>
	<body>
		<form action = "optimus/v1/employeerecords/employeedetails/getemployeedetails">
			Employee Name &nbsp;&nbsp;<input type = "text" name = "employeeName" placeholder = "Enter employee name">&nbsp;&nbsp;
			Email&nbsp;&nbsp;<input type = "email" name = "email" placeholder = "Email">&nbsp;&nbsp;
			<input type = "submit" value = "Get Details">
		</form>
		
	</body>
</html>