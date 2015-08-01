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
	<h2>Employee Details</h2>
	<br/><br/>
	<%		
			JSONObject json = new JSONObject((String)session.getAttribute("records"));
			
	%>
	Employee Code:&nbsp;&nbsp;<%out.println(json.getInt("employeeCode")); %><br/>
	Employee Name:&nbsp;&nbsp;<%out.println(json.getString("name")); %><br/>
	email:&nbsp;&nbsp;<%out.println(json.getString("email")); %><br/>
	Mobile No:&nbsp;&nbsp;<%out.println(json.getLong("mobileNo")); %><br/>
	Salary:&nbsp;&nbsp;<%out.println(json.getLong("salary")); %><br/>
	Address::&nbsp;&nbsp;<%out.println(json.getString("address")); %><br/><br/>
	
	<a href="updateemployee.jsp">Update Employee</a>&nbsp;&nbsp;<a href="index.jsp">Home</a>
	
</body>
</html>