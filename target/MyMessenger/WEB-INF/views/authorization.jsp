<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %> 
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
		<c:if test="${not empty sessionScope.profileId}">
			<%response.sendRedirect(request.getContextPath()+"/postPage");%>
		</c:if>
		<span style="float: right">
    		<a href="?lang=en">en</a> 
    		| 
    		<a href="?lang=ru">ru</a>
		</span>
		<script type="text/javascript">
			var err = '${errors}'; 
			if(err) {
				alert(err);
			}
		</script>
		<form:form action="post" commandName="userDTO">
			<table>
				<tr>
					<td>
						<spring:message code="label.Login"/>: 
					</td>
					<td><form:input path="login"/></td>
					<td><span class="error"><form:errors path="login"/></span></td>
				</tr>
				<tr>
					<td>
						<spring:message code="label.Password"/>: 
					</td>
					<td><form:password path="password"/></td>
					<td><span class="error"><form:errors path="password"/></span></td>
				</tr>
			</table>
			<form:button formaction="logIn" type="submit">
				<spring:message code="label.logIn"/>
			</form:button><br>
			<a href="signUp">
				<spring:message code="label.registration"/>
			</a>
		</form:form>
	</body>
</html>
