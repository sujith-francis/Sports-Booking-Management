<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookedFacilities</title>

</head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("mail")==null){
	response.sendRedirect("./index.html");
}

%>
<body bgcolor="#CAD5E2.">
<h1 align="center">BOOKINGS </h1>
	<c:forEach items="${booked}" var="booked">
		<form action="./getcancelpage">
			<table>
				<tr>
					<th><c:out
							value="FACILITY:${booked.fname} :: DATE:${booked.bookDate} ::TYPE:${booked.bookType} ::BOOKED BY:${booked.userMail}" /></th>
					<td><input type="hidden" name="fname" value="${booked.fname}" /></td>
					<td><input type="hidden" name="bdate"
						value="${booked.bookDate}" /></td>
					<td><input type="hidden" name="userMail"
						value="${booked.userMail}" /></td>
						
					<td><input type="submit" value="getcancelpage"></td>
				</tr>
			</table>

		</form>

	</c:forEach>

</body>
</html>