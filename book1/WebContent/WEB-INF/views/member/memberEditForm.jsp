<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../common/menu.jsp" />
<!-- Page content -->
<div class="w3-content" style="max-width: 2000px; margin-top: 46px" align="center">

	<div align="center">
		<div>
			<h1>멤버 수정</h1>
		</div>

		<div>
		<form id="frm" name="frm" action="memberEdit.do" method="post">
			<table border="1">
				<tr>
					<th width="100">아이디</th>
					<td width="100" align="center">${vo.memberid }
					<input type="hidden" id="memberid" name="memberid" value="${vo.memberid }" readonly="readonly"></td> 
					<th width="100">이름</th>
					<td width="140" align="center">${vo.membername } </td>
					<th width="100">비밀번호</th>
					<td width="120" align="center">${vo.memberpassword }</td>
					<th width="100">전화번호</th>
					<td width="200" align="center">${vo.membertel }</td>
					<th width="100">주소</th>
					<td width="100" align="center">${vo.memberaddress }</td>
					<th width="100">권한</th>
					<td width="100" align="center">${vo.membermauth }</td>
				</tr>
			</table>
				<div><br />
					<button type="submit">등록</button>&nbsp;&nbsp;&nbsp;
					<button type="reset">취소</button>&nbsp;&nbsp;&nbsp;
				</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>