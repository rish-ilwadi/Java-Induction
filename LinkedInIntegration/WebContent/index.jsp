<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LinkedIn Integration</title>
<script>
function accessRequest(){
	
	var client_id="75bm3awta2vx9r";
	var state=Math.floor((Math.random() * 100000) + 1);
	var url = "https://www.linkedin.com/uas/oauth2/authorization?response_type=code&client_id="+client_id+
			"&redirect_uri=https://localhost:8443/LinkedIn_Integration/redirect.jsp&state="+state+"scope=r_basicprofile";
	window.location.href = url;
}


</script>
</head>
<body>
<h1>LinkedIn Integration</h1>

<button onclick="accessRequest()">Get Access Token</button><br/><br/>
<form action="viewprofile">
<input type="submit" value ="View Profile">
</form>
<br/><br/>
<form action="sharepost" method="post">
<input type = "submit" value = "Share Post">
</form>
</body>
</html>