<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<html>
	<head>
	<style type="text/css">
			.error {
				color: #ff0000;
				font-style: italic;
				font-weight: bold;
			}
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>Please fill in the form</h2>
		<form action="reg" method="post">
			<table>
				<tr>
					<td>Login: </td>
					<td>
						<spring:bind path="profileDTO.user.login">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>	
						<span class="error">*    </span>
					</td>
					<td><span class="error"><c:errors path="login"/></span></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td>
						<spring:bind path="profileDTO.user.password">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>	
						<span class="error">*    </span>
					</td>
					<td><span class="error"><c:errors path="password"/></span></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td>
						<spring:bind path="profileDTO.user.email">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>	
						<span class="error">*    </span>
					</td>
					<td><span class="error"><c:errors path="password"/></span></td>
				</tr>
				<tr>
					<td>First name: </td>
					<td>
						<spring:bind path="profileDTO.firstName">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>	
				</tr>
				<tr>
					<td>Last name: </td>
					<td>
						<spring:bind path="profileDTO.lastName">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>
				<tr>
					<td>Age: </td>
					<td>
						<spring:bind path="profileDTO.age">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>
				<tr>
					<td>Gender: </td>
					<td>
						<spring:bind path="profileDTO.gender">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>	
				<tr>
					<td>City: </td>
					<td>
						<spring:bind path="profileDTO.city">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>
				<tr>
					<td>Country: </td>
					<td>
						<spring:bind path="profileDTO.country">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>
			</table>		
			<input type="submit" value="Create"/>
		</form>
	</body>
</html>

