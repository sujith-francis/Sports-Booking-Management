<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body leftmargin="35%" bgcolor="lightyellow">

<form action="./register">
<input type="hidden" name="signupType" value="${signupType}">
<br> <label for="name">Manger Name </label> <input type="text"
			id="name" name="name" placeholder="Manger name" value=" ${name}" required><br>

<br> <label for="phonenum">Enter Phone Number: </label> <input type="text"
			id="phonenum" name="phonenum" placeholder="Enter your Phone Number" required><br>
		<br> <label for="mail">Enter your Mail-ID:</label> <input
			type="text" id="mail-id" name="mail"
			placeholder="Enter your  mail-ID" required><br>
		<br> <label for="password">Password:</label> <input
			type="password" id="password" name="password" required><br>
		<br> <label for="password_confirm">Confirm Password:</label> <input
			type="password" id="password_confirm" name="password_confirm"
			required><br><br> 
			<input type="submit" value="register">



</form>


</body>
</html>