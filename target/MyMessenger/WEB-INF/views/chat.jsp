<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Chat</title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
		<script type="text/javascript">
		
			$(document).ready(function () {
				setInterval("prepare()", 2000);
			});
			
			function prepare() {
				var data;
				$("table").each(function (index, domElem) {
					switch(index) {
						case 0: data += "name=";
								data += $(domElem).text();
						case 1: data += "&date=";
								data += $(domElem).text();
						case 2: data += "&post="
								data += $(domElem).text();
					}
					query(data);
				});
			}
			
			function query(data) {			
				$.ajax({
					type: 'POST',
					url: 'bla/bla',
					data: data,
					success: function(data){
						$.each(data.post, function(index, val) {
							var $Table=$('<table align="center"></table>');
							var $AttrTr=$('<tr><td>' + val.name + '</td><td>' + val.date  + '</td></tr>' +
									'<tr>' + val.message +'</tr>');
							$Table.append($AttrTr);
							$('div').prepend($Table);
						});
					}
				});
			}
		</script>
	</head>
	<body>

	</body>
</html>