<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>User Input From</h2>
	<hr />
	<form:form action="welcome" method="post" modelAttribute="user">
		<table>
			<tr>
				<th>Name</th>
				<td><form:input path="name" /> <form:errors path="name" /></td>
			</tr>
			
			<tr>
				<th>Password</th>
				<td><form:input path="password" /> <form:errors path="password" /></td>
			</tr>
			</table>
			</form:form>

</body>
</html>