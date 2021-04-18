<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 int score=(int)session.getAttribute("score");
%>
<h3>You scored <%=score/.04%> %</h3>
<a href="dashboard.jsp">Retake</a><a href="logout">Logout</a>
<%
 RequestDispatcher dispatcher = request.getRequestDispatcher("result");
 dispatcher.include(request, response);
%>
</body>
</html>