<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
	<div><h1>로 그 인</h1></div>
		<div>
			<form id="frm" name="frm" action="login.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100">아 이 디</th>
							<td width="150"><input type="text" id="memberid" name="memberid" size="30"></td>
						</tr>
						<tr>
							<th width="100">패스워드</th>
							<td width="150"><input type="password" id="memberpassword" name="memberpassword" size="30"></td>
						</tr>
					</table>
				</div><br /> 
				<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">
			</form>
		</div>
	</div>
</body>
</html>