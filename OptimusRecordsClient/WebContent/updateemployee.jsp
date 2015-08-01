<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="org.json.JSONObject"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Optimus Records Client</title>
</head>
<body>
		<h1>Optimus Records</h1>
		<% 
			JSONObject json = new JSONObject((String)session.getAttribute("records"));
		%>
		<form action = "optimus/client/v1/updateemployee" method="post">
			Admin User Name&nbsp;&nbsp;<input type = "text" name = "userName" placeholder = "Admin User Name" ><br/>
			Admin Password&nbsp;&nbsp;<input type = "password" name = "password" placeholder = "Password"><br/>
			Employee Name &nbsp;&nbsp;<input type = "text" name = "employeeName" placeholder = "Enter employee name" value = <%=json.getString("name")%>><br/>
			Email&nbsp;&nbsp;<input type = "email" name = "email" placeholder = "Email" value = <%=json.getString("email") %>>&nbsp;&nbsp;<br/>
			Mobile No&nbsp;&nbsp;<input type = "text" name = "mobileNo" placeholder = "Enter Mobile No." value = <%=json.getLong("mobileNo") %>><br/>
			Salary&nbsp;&nbsp;<input type = "text" name = "salary" placeholder = "Enter salary" value = <%=json.getLong("salary") %>><br/>
			Address&nbsp;&nbsp;<input type = "text" name = "address" placeholder = "Enter address" value = <%=json.getString("address") %>><br/><br/>
			<input type = "submit" value = "Update Employee">
		</form>
</body>
</html>