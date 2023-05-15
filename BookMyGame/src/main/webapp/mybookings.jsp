<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bookings</title>
</head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("mail")==null){
	response.sendRedirect("./index.html");
}

%>
<body bgcolor="#E83A59">
<c:forEach items="${bookings}" var="bookings">
<form action="./cancelbooking">
<table>
				<tr>
					<th><c:out
							value="FACILITY:${bookings.fname} :: DATE:${bookings.bookDate} ::TYPE:${bookings.bookType} " /></th>
					<td><input type="hidden" name="fname" value="${bookings.fname}" /></td>
					<td><input type="hidden" name="bdate" value="${bookings.bookDate}" /></td>
					<td><input type="submit" value="cancel" /></td>
				</tr>
			</table>

</form>

</c:forEach>
</body>
</html>