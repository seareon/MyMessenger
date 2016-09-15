<%@page import="com.seareon.dto.ProfileDTO"%>
<%@page import="com.seareon.model.Post"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
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
</head>
<body>
	<c:form action="post" commandName="postDTO">
		<c:textarea rows="5" cols="30" path="message"/><br>
		<c:button formaction="postSave" type="submit">Submit</c:button>
	</c:form>
	<% SimpleDateFormat dateFormat = new SimpleDateFormat();
	   ProfileDTO profile = (ProfileDTO) request.getAttribute("profileDTO");
	   for(Post post : profile.getPosts()) {
		out.println("<h4>" + profile.getFirstName() + " " + profile.getLastName() + "</h4>");
		out.println("<p>" + dateFormat.format(post.getDate()) + "</p>");
		out.println("<div>" + post.getMessage() + "</div>");
	   }
	%>
</body>
</html>