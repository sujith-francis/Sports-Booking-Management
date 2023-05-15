<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if (session.getAttribute("mail") == null) {//if the page is directly visited the sessionobject won't hold the name the attribute so it will be null
	response.sendRedirect("./loginindex.html");
}
%>
<body leftmargin="35%" bgcolor="lightyellow">
	<form action="./controller/registerfacility">

		<br> <label for="fname">Facility Name: </label> <input
			type="text" id="fname" name="fname"
			placeholder="Enter your Facility Name" required><br> <br>
		<label for="fowner">Facility Owner Name: </label> <input type="text"
			id="fowner" name="fowner" placeholder="Enter your Facility Owner Name"
			required><br>
			<br> <label for="fphone">Facility Phone Number: </label> <input type="text"
			id="fphone" name="fphone" placeholder="Enter your Facility Phone Number" required><br>

<br> <label for="fsport">Facility's Sport: </label> <input type="text"
			id="fsport" name="fsport" placeholder="Enter your Facility's Sport" required><br>
			<br> <label for="floc">Facility's Location: </label> <input type="text"
			id="floc" name="floc" placeholder="Enter your Facility's Location" required><br>
			<br> <label for="fmail">Facility's Contact Mail: </label> <input type="text"
			id="fmail" name="fmail" placeholder="Enter your Facility Mail" required><br>
			<input type="hidden" name="fomail" value="<%=(String)session.getAttribute("mail") %>">
		<Br>	<input type="submit" value="register">

	</form>
</body>
</html>