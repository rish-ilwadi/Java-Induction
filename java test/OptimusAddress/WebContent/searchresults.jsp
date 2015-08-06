<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="optimus.addressbook.Address" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Optimus Address Book</title>
</head>
<body>
<center><h1>Optimus Address Book</h1></center>
<center><h2>Search Results</h2></center>
<br/><br/>
<% 

List <Address> list;
list = (List)session.getAttribute("AddressList");
Iterator iterator = list.iterator();
if(list.isEmpty()){
	out.println("No records found");
}
else{
	while( iterator.hasNext()){
		Address address = (Address)iterator.next();
		out.println("<br/>First Name:&nbsp;"+address.getFname()+"<br/>Last Name:&nbsp;"+address.getLname()+"<br/>PhoneNo:&nbsp;"
			+address.getPhoneNo()+"<br/>address:&nbsp;"+address.getAddress()+"<br/>Email:&nbsp;"+address.getEmail());
	}
}


%>


</body>
</html>