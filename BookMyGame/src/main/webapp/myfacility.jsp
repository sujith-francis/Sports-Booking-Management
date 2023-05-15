<%@page import="com.bmg.beans.Facility"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("mail")==null){//if the page is directly visited the sessionobject won't hold the name the attribute so it will be null
	response.sendRedirect("./loginindex.html");
}
%>
 <body bgcolor="lightyellow">

<c:forEach items='<%=session.getAttribute("facilities")%>' var="object">
<form action="./controller/modifyFacility" method="post">
<table>
<tr>
<th><c:out value="FACILITY:${object.fname} SPORT:${object.fsport} LOCATION:${object.floc} MAIL:${object.fmail}"/></th>
						<td><input type="hidden" name="fname"
							value="${object.fname}" /></td>
</tr>
<tr>
<td><input type="submit" name="operation" value="Delete"><input type="submit" name="operation" value="Update"></td>
</tr>
</table>

</form> 
</c:forEach>
<form action="./facilityregister.jsp">
<input type="submit" value="addFacility">

</form>

</body>
</html>