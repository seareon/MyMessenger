<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<c:if test="${empty sessionScope.profileId}">
			<%response.sendRedirect(request.getContextPath()+"/WEB-INF/views/authorization.jsp");%>
		</c:if>
		<c:set var="valButtonSave">
			<spring:message code="label.Save"/>
		</c:set>
		<span style="float: right">
    		<a href="edit?lang=en">en</a> 
    		| 
    		<a href="edit?lang=ru">ru</a>
		</span><br>
		<h2><spring:message code="label.PleaseFillInTheForm"/></h2>
		<form action="updateProfile" method="post">
			<form:hidden path="profile.user.login"/>
			<form:hidden path="profile.user.password"/>
			<form:hidden path="profile.user.id"/>
			<form:hidden path="profile.id"/>
			<table>
				<tr>
					<td><spring:message code="label.FirstName"/>: </td>
					<td>
						<spring:bind path="profile.firstName">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>	
				</tr>
				<tr>
					<td><spring:message code="label.LastName"/>: </td>
					<td>
						<spring:bind path="profile.lastName">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>
				<tr>
					<td><spring:message code="label.Email"/>: </td>
					<td>
						<spring:bind path="profile.user.email">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>
				<tr>
					<td><spring:message code="label.Age"/>: </td>
					<td>
						<spring:bind path="profile.age">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>
				<tr>
					<td><spring:message code="label.Gender"/>: </td>
					<td>
						<spring:bind path="profile.gender">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>	
				<tr>
					<td><spring:message code="label.City"/>: </td>
					<td>
						<spring:bind path="profile.city">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>
				<tr>
					<td><spring:message code="label.Country"/>: </td>
					<td>
						<spring:bind path="profile.country">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>
			</table>		
			<input type="submit" value="${valButtonSave}"/>
		</form>
		<a href="profileInfo">
			<spring:message code="label.ProfilePage"/>
		</a>
	</body>
</html>