<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="com.quizapp.dto.Questions"
    import="com.quizapp.dto.Options"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<form action="validation">
<%
 List<Questions> qList = (List<Questions>)request.getAttribute("questions");
// List<Options> oList = (List<Options>)request.getAttribute("options");
 for(int i=0;i<qList.size();i++){
%> 
<h3><%=i+1+" "+ qList.get(i).getQuestion() %></h3>
<input class="radio" type="radio" name="<%=qList.get(i).getAnswer()%>" value="<%=(qList.get(i).getOptionOne())%>"><%=(qList.get(i).getOptionOne())%>
<input class="radio" type="radio" name="<%=qList.get(i).getAnswer()%>" value="<%=(qList.get(i).getOptionTwo())%>"><%=(qList.get(i).getOptionTwo())%>
<input class="radio" type="radio" name="<%=qList.get(i).getAnswer()%>" value="<%=(qList.get(i).getOptionThree())%>"><%=(qList.get(i).getOptionThree())%>
<input class="radio" type="radio" name="<%=qList.get(i).getAnswer()%>" value="<%=(qList.get(i).getOptionFour())%>"><%=(qList.get(i).getOptionFour())%>

<%
}
 session.setAttribute("questionList", qList);
%>
<br>
<input type="submit">
</form>

</body>
</html>