<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#topMenu {
	height: 30px;
	width: 850px;
}

#topMenu ul li {
	list-style: none;
	color: white;
	background-color: #2d2d2d;
	float: left;
	line-height: 30px;
	vertical-align: middle;
	text-align: center;
}

#topMenu .menuLink {
	text-decoration: none;
	color: white;
	display: block;
	width: 150px;
	font-size: 12px;
	font-weight: bold;
	font-family: "Trebuchet MS";
}

#topMenu .menuLink:hover {
	color: red;
	background-color: #4d4d4d;
}
</style>
</head>
<body>
	<div align="center">
		<nav id="topMenu">
			<ul>
				<li><a class="menuLink" href="main.do">Home</a></li>
				<li>|</li>
				<c:if test="${memberid eq null }">
					<li><a class="menuLink" href="loginForm.do">Login</a></li>
					<li>|</li>
				    <li><a class="menuLink" href="memberJoinForm.do">회원가입</a></li>
				</c:if>
				<c:if test="${membermauth == 'USER' }">
				<li><a class="menuLink" href="bookList.do">도서대여</a></li>
				<li>|</li>
				<li><a class="menuLink" href="#">도서반납</a></li>
				</c:if>
				<c:if test="${membermauth == 'SYS' }">
				<li><a class="menuLink" href="#">도서등록</a></li>
				<li>|</li>
				<li><a class="menuLink" href="#">대여관리</a></li>
				<li>|</li>
				<li><a class="menuLink" href="#">회원관리</a></li>
				</c:if>
				<c:if test="${memberid ne null }" >
				<li>|</li>
				<li><a class="menuLink" href="logout.do">Logout</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
</body>
</html>