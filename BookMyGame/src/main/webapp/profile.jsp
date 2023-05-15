<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("mail")==null){
	response.sendRedirect("./index.html");
}

%>
<body bgcolor="lightyellow">
<c:set var="t" value='<%=pageContext.getAttribute("type",2) %>'/>
<c:if test="${t eq 'admin'}">

Name: ${admin.name}<br>
Phone:${admin.pNumber}

</c:if>
<c:if test="${t eq 'user'}">

Name: ${user.name}<br>
Phone:${user.pNumber}

</c:if>
</body>
</html>