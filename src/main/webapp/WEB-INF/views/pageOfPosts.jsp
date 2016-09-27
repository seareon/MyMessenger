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
	$(document).ready(function timer () {
		setInterval("prepare()", 2000);
	});
	
	function editPost(id, valButton) {
		
		var newElem = $('<form action="postUpdate/' + id + '" method="post"/>').append('<textarea rows="5" cols="30"' +
			' name="message">' + $('#div' + id).text() + '</textarea>').append('<br>').append('<input type="submit" value="' 
					+ valButton + '"></form>');
		$('#div' + id).replaceWith(newElem);
		$('#button' + id).remove();
	}
	
	function prepare() {
	/*	var data = '{"id": [';
		$("table").each(function (index, domElem) {
			if($(domElem).tagName == 'div')
				data += $(domElem).getAttribute('id') + ', ';
		});
		data += ']}'; */
		query(/*data*/);
	}
	
	function query(/*data*/) {			
		$.ajax({
			type: 'POST',
			url: 'getPosts',
//			data: data,
			contentType: 'application/json',
			dataType: 'json',
			mimeType: 'application/json',
			success: function(data){
				$.each(data.posts, function(index, val) {
					alert("Data: " + data);
					var $Table=$('<table align="center"></table>');
					var $AttrTr=$('<tr><td>' + val.name + '</td><td>' + val.date  + '</td></tr>' +
							'<tr>' + val.message +'</tr>');
					$Table.append($AttrTr);
					if(sessvars.profileId == post.profileOwner.id) {
						$AttrTr=$('<input type="button" id="${posts[index].id}" value=' +
								'"${valButtonEdit}" onClick="editPost(\'${post[index].id}\', \'${valButtonSave}\')">' +
								'<form action="deletePost/${post[index].id}" method="post">' +
									'<input type="submit" value="${valButtonDelete}">' +
								'</form>');
					}
					$('div').prepend($Table);
				});
			},
			error: function(data) {
				alert("Data: " + data);
			}
		});
	}
</script>
</head>
<body>
	<c:if test="${empty sessionScope.profileId}">
		<%response.sendRedirect(request.getContextPath()+"/WEB-INF/views/authorization.jsp");%>
	</c:if>
	<c:set var="valButtonDelete">
		<spring:message code="label.Delete"/>
	</c:set>
	<c:set var="valButtonExit">
		<spring:message code="label.Exit"/>
	</c:set>
	<c:set var="valButtonEdit">
		<spring:message code="label.Edit"/>
	</c:set>
	<c:set var="valButtonSave">
		<spring:message code="label.Save"/>
	</c:set>
	<h:head href="postPage" name="${sessionScope.userName}" buttonName="${valButtonExit}"/>
	<span style="float: right">
		<a href="profileInfo"><spring:message code="label.ProfilePage"/></a>
	</span>
	<form:form action="post" commandName="userDTO">
		<form:input path="login"/>
		<form:button formaction="searchUser" type="submit"> 
			<spring:message code="label.Submit"/>
		</form:button>
	</form:form>
	<form:form action="post" commandName="postDTO">
		<form:textarea rows="5" cols="30" path="message"/><br>
		<form:button formaction="postSave" type="submit">
			<spring:message code="label.Subscribe"/>
		</form:button>
	</form:form>
	<script type="text/javascript">
		function timer () {
			setInterval("prepare()", 2000);
		};
	</script>
	<c:forEach var="post" items="${posts}">
		<p><c:out value="${post.profile.firstName} ${post.profile.lastName}"/></p>
		<fmt:formatDate value="${post.date}" pattern="dd-MM-yyyy hh:mm" />
		<div id="div${post.id}">${post.message}</div>
		<c:if test="${sessionScope.profileId == post.profile.id}">
			<input type="button" id="button${post.id}" value=
								"${valButtonEdit}" onClick="editPost('${post.id}', '${valButtonSave}')">
			<form action="deletePost/${post.id}" method="post">
				<input type="submit" value="${valButtonDelete}">
			</form>
		</c:if>
	</c:forEach>
</body>
</html>