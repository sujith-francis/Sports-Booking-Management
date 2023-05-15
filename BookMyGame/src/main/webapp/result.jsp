<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body leftmargin="35% " bgcolor="lightgreen">
<c:set var="result" value='<%=pageContext.getAttribute("result",4)%>'/>
<c:choose>
<c:when test="${result eq 'success' }">
<h1 style="color: black">Registered......</h1>
<a href="../login.html" target="body">GETLOGINPAGE</a><br/>	<br>
</c:when>
<c:when test="${result eq 'error' }">
<h1 style="color: black">ERROR Try Again......</h1>
<a href="../register.html" target="body">GETREGISTERPAGE</a><br/>	<br>
</c:when>
<c:when test="${result eq 'derror' }">
<h1 style="color: black">ERROR Try Again......</h1>
</c:when>
<c:when test="${result eq 'dsuccess' }">
<h1 style="color: black">SuccessFully DELETED......</h1>
</c:when>
<c:when test="${result eq 'dfailed' }">
<h1 style="color: black">FAILED......</h1>
</c:when>
<c:when test="${result eq 'rerror' }">
<h1 style="color: black">ERROR While Register TRY AGAIN......</h1>
</c:when>
<c:when test="${result eq 'rsuccess' }">
<h1 style="color: black">SuccessFully REGISTERED......</h1>
</c:when>
<c:when test="${result eq 'rfailed' }">
<h1 style="color: black">FAILED TO REGISTER TRY AGAIN......</h1>
</c:when>
<c:when test="${result eq 'uerror' }">
<h1 style="color: black">ERROR While UPDATING TRY AGAIN......</h1>
</c:when>
<c:when test="${result eq 'usuccess' }">
<h1 style="color: black">SuccessFully UPDATED......</h1>
</c:when>
<c:when test="${result  eq 'ufailed' }">
<h1 style="color: black">FAILED TO UPDATE TRY AGAIN......</h1>
</c:when>
<c:when test="${result eq 'berror' }">
<h1 style="color: black">ERROR While BOOKING TRY AGAIN......</h1>
</c:when>
<c:when test="${result eq 'bierror' }">
<h1 style="color: black">ALREADY BOOKED BY SOMEONE......</h1>
</c:when>
<c:when test="${result eq 'bsuccess' }">
<h1 style="color: black">SuccessFully BOOKED......</h1>
</c:when>
<c:when test="${result  eq 'bfailed' }">
<h1 style="color: black">FAILED TO BOOK TRY AGAIN......</h1>
</c:when>
<c:when test="${result eq 'cerror' }">
<h1 style="color: black">ERROR While CANCELLING TRY AGAIN......</h1>
</c:when>
<c:when test="${result eq 'csuccess' }">
<h1 style="color: black">SuccessFully CANCELLED......</h1>
</c:when>
<c:when test="${result  eq 'cfailed' }">
<h1 style="color: black">FAILED TO CANCEL TRY AGAIN......</h1>
</c:when>
<c:when test="${result  eq 'isuccess' }">
<h1 style="color: black">CANCELLED AND MAIL SENT......</h1>
</c:when>
<c:when test="${result eq 'reqerror' }">
<h1 style="color: black">ERROR While REQUESTING TRY AGAIN......</h1>
</c:when>
<c:when test="${result eq 'reqsuccess' }">
<h1 style="color: black">SuccessFully REQUESTED......</h1>
</c:when>
<c:when test="${result  eq 'reqfailed' }">
<h1 style="color: black">FAILED TO REQUEST TRY AGAIN......</h1>
</c:when>
<c:when test="${result  eq 'reqalready' }">
<h1 style="color: black">ALREADY REQUESTED......</h1>
</c:when>
<c:when test="${result eq 'raerror' }">
<h1 style="color: black">ERROR......</h1>
</c:when>
<c:when test="${result eq 'rasuccess' }">
<h1 style="color: black">ACCEPTED AND MAIL SENT......</h1>
</c:when>
<c:when test="${result eq 'radsuccess' }">
<h1 style="color: black">DECLINED AND MAIL SENT......</h1>
</c:when>
<c:when test="${result  eq 'rafailed' }">
<h1 style="color: black">FAILED  TRY AGAIN......</h1>
</c:when>

</c:choose>
</body>
</html>