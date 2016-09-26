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
		<c:if test="${not empty sessionScope.profileId}">
			<%response.sendRedirect(request.getContextPath()+"/postPage");%>
		</c:if>
		<c:set var="valButtonCreate">
			<spring:message code="label.Create"/>
		</c:set>
		<span style="float: right">
    		<a href="signUp?lang=en">en</a> 
    		| 
    		<a href="signUp?lang=ru">ru</a>
		</span><br>
		<h2><spring:message code="label.PleaseFillInTheForm"/></h2>
		<form action="reg" method="post">
			<table>
				<tr>
					<td><spring:message code="label.Login"/>: </td>
					<td>
						<spring:bind path="profileDTO.user.login">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>	
						<span class="error">*    </span>
					</td>
					<td><span class="error"><form:errors path="login"/></span></td>
				</tr>
				<tr>
					<td><spring:message code="label.Password"/>: </td>
					<td>
						<spring:bind path="profileDTO.user.password">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>	
						<span class="error">*    </span>
					</td>
					<td><span class="error"><form:errors path="password"/></span></td>
				</tr>
				<tr>
					<td><spring:message code="label.Email"/>: </td>
					<td>
						<spring:bind path="profileDTO.user.email">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>	
						<span class="error">*    </span>
					</td>
					<td><span class="error"><form:errors path="password"/></span></td>
				</tr>
				<tr>
					<td><spring:message code="label.FirstName"/>: </td>
					<td>
						<spring:bind path="profileDTO.firstName">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>	
				</tr>
				<tr>
					<td><spring:message code="label.LastName"/>: </td>
					<td>
						<spring:bind path="profileDTO.lastName">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>
				<tr>
					<td><spring:message code="label.Age"/>: </td>
					<td>
						<spring:bind path="profileDTO.age">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>
				<tr>
					<td><spring:message code="label.Gender"/>: </td>
					<td>
						<spring:bind path="profileDTO.gender">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>	
				<tr>
					<td><spring:message code="label.City"/>: </td>
					<td>
						<spring:bind path="profileDTO.city">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>
				<tr>
					<td><spring:message code="label.Country"/>: </td>
					<td>
						<spring:bind path="profileDTO.country">
							<input type="text" name="${status.expression}" value="${status.value}">
						</spring:bind>
					</td>
				</tr>
			</table>		
			<input type="submit" value="${valButtonCreate}"/>
		</form>
	</body>
</html>

