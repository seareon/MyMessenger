<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>Registration/Sing up Page</title>
		<style type="text/css">
			.error {
				color: #ff0000;
				font-style: italic;
				font-weight: bold;
			}
		</style>
	</head>
	<body>
	<script type="text/javascript">
		var err = '${errors}'; 
		if(err) {
			alert(err);
		}
	</script>
		<form:form action="post" commandName="userDTO">
			<table>
				<tr>
					<td>Login: </td>
					<td><form:input path="login"/></td>
					<td><span class="error"><form:errors path="login"/></span></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><form:password path="password"/></td>
					<td><span class="error"><form:errors path="password"/></span></td>
				</tr>
			</table>
			<form:button formaction="logIn" type="submit">Log in</form:button><br>
			<a href="signUp">Registration</a>
		</form:form>
	</body>
</html>
