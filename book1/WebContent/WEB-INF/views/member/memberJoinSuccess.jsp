<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../common/menu.jsp"></jsp:include>
<body>
	<div align="center">
		<h1>${vo.membername } 님 ${vo.memberid }로 회원가입이 성공했습니다.</h1>
	</div>
</body>
</html>