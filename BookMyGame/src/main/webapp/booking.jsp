<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book</title>
</head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("mail")==null){
	response.sendRedirect("./index.html");
}

%>
<%
LocalDate date = LocalDate.now().plusDays(1);
pageContext.setAttribute("date", date.toString());
%>

<body background="#8D3DAF">
	<h1>Facility:${fname}</h1>
	<form action="./bookfacility">
	<input type="hidden" name="fname" value="${fname}">
		Select your Booking Date: <input type="date" id="bdate" name="bdate"
			value="<%=pageContext.getAttribute("date", 1)%>"
			min="<%=pageContext.getAttribute("date", 1)%>"> <br><label>
			Booking Type: <input type="radio" name="btype" value="host" required="required">
			Host
		</label> <label> <input type="radio" name="btype" value="play" required="required">
			Play
		</label><br>
		<input type="submit" value="book">
	</form>

</body>
</html>
