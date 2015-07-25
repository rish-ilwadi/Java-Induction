<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Optimus Bank</title>
</head>
<body>
<h1>Optimus Bank</h1>

<h2>Create your account</h2>

<form method="Post" action="AccountTeller">
Account Type &nbsp;&nbsp;<input type="radio" name="typeOfAccount" value="Savings">Savings&nbsp;&nbsp;</input><input type="radio" name="typeOfAccount" value="Current">Current&nbsp;&nbsp;</input><input type="radio" name="typeOfAccount" value="Recurring">Recurring</input>
<input type="Submit" value="Sign Up">
</form>

</body>
</html>