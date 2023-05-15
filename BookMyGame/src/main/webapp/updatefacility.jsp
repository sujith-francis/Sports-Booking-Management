<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if (session.getAttribute("mail") == null) {
	response.sendRedirect("./loginindex.html");
}
%>
<body>
	<form action="./updatefacility">
		<input type="hidden" value="${facilityname}" name="facilityname"> <br> <label
			for="fowner">Facility Name: </label> <input type="text" id="fname"
			name="fname" value="${facility.fname}"
			placeholder="Enter your Facility Name" required><br> <br>
		<label for="fowner">Facility Owner Name: </label> <input type="text"
			id="fowner" name="fowner" value="${facility.fowner}"
			placeholder="Enter your Facility Owner Name" required><br>
		<br> <label for="fphone">Facility Phone Number: </label> <input
			type="text" id="fphone" name="fphone" value="${facility.fphone}"
			placeholder="Enter your Facility Phone Number" required><br>

		<br> <label for="fsport">Facility's Sport: </label> <input
			type="text" id="fsport" name="fsport" value="${facility.fsport}"
			placeholder="Enter your Facility's Sport" required><br>
		<br> <label for="floc">Facility's Location: </label> <input
			type="text" id="floc" name="floc" value="${facility.floc}"
			placeholder="Enter your Facility's Location" required><br>
		<br> <label for="fmail">Facility's Contact Mail: </label> <input
			type="text" id="fmail" name="fmail" value="${facility.fmail}"
			placeholder="Enter your Facility Mail" required><br> <input
			type="submit" value="update">

	</form>
</body>
</html>