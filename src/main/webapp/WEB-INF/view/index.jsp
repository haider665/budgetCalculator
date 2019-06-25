<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Hello dear ;)</h1>
	
	<form action="asd">
		<input type="text" name ="a"/>
		<input type="submit"/>
	</form> <br>
	
	<h1>Log In</h1>
	<form:form action="logIn" modelAttribute="haider" >
		<form:input placeholder="enter email" path="email"/> <br><br>
		<form:password placeholder="enter password" path="password"/><br><br>
		<input type="submit" />
	</form:form>
	
	<br> <br> <br>
	<h1>Sign Up</h1>
	<form:form action="signIn" modelAttribute="haider" target="_blank">
		<form:input placeholder="enter password" path="email"/> <br><br>
		<form:password placeholder="enter password" path="password"/><br><br>
		<input type="submit" />
	</form:form>
	
</body>
</html>