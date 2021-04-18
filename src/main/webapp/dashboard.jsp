<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<form action="java" method="post">
<% if(session.getAttribute("name")==null){
	response.sendRedirect("login.jsp");
}else{
%>
<h1>Welcome <%= session.getAttribute("name") %></h1>
<h3>Choose Your Quiz Language</h3>
<input type="radio" value="java" name="language" >Java
<input type="radio" value="SQL" name="language" >SQL
<input type="radio" value="HTML" name="language" >HTML
<br>
<input type="submit" value="submit">

<%
}
%>
</form>
</body>
</html>