<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Profile ${profileDTO.getUser().getLogin()}</h1>
	<table> 
		<tr>
			<td>Email: </td>
			<td>
				${profileDTO.getUser().getEmail()}
			</td>
		</tr>
		<tr>
			<td>First name: </td>
			<td>
				${profileDTO.getFirstName()}
			</td>	
		</tr>
		<tr>
			<td>Last name: </td>
			<td>
				${profileDTO.getLastName()}
			</td>
		</tr>
		<tr>
			<td>Age: </td>
			<td>
				${profileDTO.getAge()}
			</td>
		</tr>
		<tr>
			<td>Gender: </td>
			<td>
				${profileDTO.getGender()}
			</td>
		</tr>	
		<tr>
			<td>City: </td>
			<td>
				${profileDTO.getCity()}
			</td>
		</tr>
		<tr>
			<td>Country: </td>
			<td>
				${profileDTO.getCountry()}
			</td>
		</tr>
	</table>
	<a href="edit">Edit profile</a><br>
	<a href="postPage">Post page</a>
</body>
</html>