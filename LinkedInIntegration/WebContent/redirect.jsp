<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "linkedinntegration.AccessToken" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LinkedIn Integration</title>
</head>
<body>
<%
	String code = request.getParameter("code");
	
	out.println(code);
	AccessToken newToken = new AccessToken();
	String token=newToken.getAccessToken(code);
	session.setAttribute("token",token);
	
%>


</body>
</html>