<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CANCEL</title>
</head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if (session.getAttribute("mail") == null) {
	response.sendRedirect("./index.html");
}
%>
<body>
	<c:out value="Facility   :: ${fname}" /><br>
	<c:out value="Booked Date:: ${bookdate}" /><br>
	<c:out value="Booked BY  :: ${usermail}" /><br>



	<form action="./admincancelbookings">
	<input type="hidden" name="fname" value="${fname}">
	<input type="hidden" name="bdate" value="${bookdate}">
	<input type="hidden" name="userMail" value="${usermail}">
<input type="text" name= "reason" >
<input type="submit" value="cancel">	
	</form>
</body>
</html>