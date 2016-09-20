<%@page import="com.seareon.dto.ProfileDTO"%>
<%@page import="com.seareon.model.Post"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tagLib/head.tld" prefix="h"%>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
		border: 1px solid grey;
		width: 200px;
	}
	h4 {		
	}
</style>
<script type="text/javascript">
	function editPost(id, valButton) {
		var newElem = $('<form action="postUpdate/' + id + '" method="post"/>').append('<textarea rows="5" cols="30"' +
			' name="message">' + $('#div' + id).text() + '</textarea>').append('<br>').append('<input type="submit" value="' + 
					valButton + '"></form>');
		$('#div' + id).replaceWith(newElem);
		$('#button' + id).remove();
	}
</script>
</head>
<body>
	<c:set var="userName">
		<spring:message code="${sessionScope.userName}"/>
	</c:set>
	<c:set var="valButtonEdit">
		<spring:message code="label.Edit"/>
	</c:set>
	<c:set var="valButtonSave">
		<spring:message code="label.Save"/>
	</c:set>
	<h:head href="postPage" name="<%session.getAttribute("userName");%>"/>
	<span style="float: right">
		<a href="profileInfo"><spring:message code="label.ProfilePage"/></a>
	</span>
	<form:form action="post" commandName="postDTO">
		<form:textarea rows="5" cols="30" path="message"/><br>
		<form:button formaction="postSave" type="submit">
			<spring:message code="label.Submit"/>
		</form:button>
	</form:form>
	<c:forEach var="post" items="${profileDTO.posts}">
		<p><c:out value="${profileDTO.firstName} ${profileDTO.lastName}"/></p>
		<fmt:formatDate value="${post.date}" pattern="dd-MM-yyyy hh:mm" />
		<div id="div${post.id}">${post.message}</div>
		<input type="button" id="button${post.id}" value=
								"${valButtonEdit}" onClick="editPost('${post.id}', '${valButtonSave}')">
	</c:forEach>
</body>
</html>