<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복 체크</title>
<script type="text/javascript">
	function formClose() {
		if(${check }) {
			window.opener.document.getElementById("memberpassword").focus();
		}else {
			window.opener.document.getElementById("memberid").value="";
			window.opener.document.getElementById("memberid").focus();
		}
		window.close();
	}
	
</script>
</head>
<body>
	<div align="center">
		<h1>${msg }</h1>
		<button type="button" onclick="formClose()">확인</button>
	</div>
</body>
</html>