<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty sessionScope.profileId}">
		<%response.sendRedirect(request.getContextPath()+"/");%>
	</c:if>
	<span style="float: right">
    	<a href="profileInfo?lang=en">en</a> 
    	| 
    	<a href="profileInfo?lang=ru">ru</a>
	</span><br>
	<h1>
		<spring:message code="label.Profile"/> 
		${profileDTO.getUser().getLogin()}
	</h1>
	<table> 
		<tr>
			<td><spring:message code="label.Email"/>: </td>
			<td>
				${profileDTO.getUser().getEmail()}
			</td>
		</tr>
		<tr>
			<td><spring:message code="label.FirstName"/>: </td>
			<td>
				${profileDTO.getFirstName()}
			</td>	
		</tr>
		<tr>
			<td><spring:message code="label.LastName"/>: </td>
			<td>
				${profileDTO.getLastName()}
			</td>
		</tr>
		<tr>
			<td><spring:message code="label.Age"/>: </td>
			<td>
				${profileDTO.getAge()}
			</td>
		</tr>
		<tr>
			<td><spring:message code="label.Gender"/>: </td>
			<td>
				${profileDTO.getGender()}
			</td>
		</tr>	
		<tr>
			<td><spring:message code="label.City"/>: </td>
			<td>
				${profileDTO.getCity()}
			</td>
		</tr>
		<tr>
			<td><spring:message code="label.Country"/>: </td>
			<td>
				${profileDTO.getCountry()}
			</td>
		</tr>
	</table>
	<a href="edit">
		<spring:message code="label.EditProfile"/>
	</a><br>
	<a href="postPage">
		<spring:message code="label.PostPage"/>
	</a>
</body>
</html>