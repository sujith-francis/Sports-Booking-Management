<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOSTINGS</title>
</head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("mail")==null){
	response.sendRedirect("./index.html");
}

%>
<body bgcolor="#E83A59">
	<h1 align="center">Your Hostings</h1>
	<c:if test="${youhostings eq 'no' }">
	<h4 align="center">NO HOST TYPE BOOKINGS YOU BOOKED</h4>
	</c:if>
	<c:forEach items="${yourhostings}" var="host">

		<h4 align="center">
			<c:out
				value="FACILITY::${host.fname} AND BOOKED DATE::${host.bookDate}" />
		</h4>
		<br>
	</c:forEach>

	<h1 align="center">************************************</h1>
	<h1 align="center">Hostings</h1>
		<c:if test="${hosting eq 'no' }">
	<c:out value="NO HOST TOURNAMENTS"></c:out>
	</c:if>
	<c:forEach items="${hostings}" var="host">
		<form action="./joinhost" style="margin-left: 25%">
				FACILITY::${host.fname} AND TOURNAMENT DATE::${host.bookDate} HOSTED BY::${host.userMail} <br>
					
			<input type="hidden" name="fname" value="${host.fname}">
			<input type="hidden" name="bdate" value="${host.bookDate}">
			<input type="hidden" name="hostmail" value="${host.userMail}">
			
			<input type="submit" value="JOIN" > 
		</form>
	</c:forEach>

	<h1 align="center">************************************</h1>
	<h1 align="center">JOIN REQUESTS</h1>
	
		<c:if test="${hostingreq eq 'no' }">
		<h4 align="center">NO REQUESTS YET!!</h4>
	</c:if>
	<c:forEach items="${hostingrequests}" var="req">
	<form action="./requestaccept" style="margin-left: 25%">
				USER::${req.userMail} REQUESTED TO JOIN THE TOURNAMENT AT FACILITY::${req.fname} ON::${req.bdate}<br>
					
			<input type="hidden" name="fname" value="${req.fname}">
			<input type="hidden" name="bdate" value="${req.bdate}">
			<input type="hidden" name="usermail" value="${req.userMail}">
			
			<input type="submit" name="joinrequest" value="ACCEPT" > 
			<input type="submit" name="joinrequest" value="DECLINE" > 
		</form>
	</c:forEach>
	<h1 align="center">************************************</h1>
</body>
</html>








