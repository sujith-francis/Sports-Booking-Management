<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Player</title>
<script type="text/javascript" language="javaScript">
if(top.location != self.location){
	top.location.href = self.location.href;
}
</script>
</head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("mail")==null){//if the page is directly visited the sessionobject won't hold the name the attribute so it will be null
	response.sendRedirect("./index.html");
}

%>


<frameset rows="20%,65%,15%">
    <frame src="./header.html" />
	<frameset cols="20%,80%">
		<frame src="./playermenu.html"/>
		<frame src="./welcome.html" name="body" />
	</frameset>
	<frame src="./footer.html"/>
</frameset>
</html>