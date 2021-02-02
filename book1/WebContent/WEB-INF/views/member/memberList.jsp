<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
tr.row:hover {
	background-color: lightyellow
}
</style>

<script type="text/javascript">
	function deleteAlert() {
		var yn = confirm("정말 삭제할까요?");
		if (yn) {
			frm.action = "memberDelete.do"
			frm.submit();
		}
	}
	function editAlert() {
		frm.action = "memberEditForm.do"
		frm.submit();
	}
</script>

<jsp:include page="../common/menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width: 2000px; margin-top: 46px"
	align="center">
	<h1>회원들 목록</h1>
	<form id="frm" name="frm" method="post">
		<table border="1">
			<tr>
				<th width="100">아이디</th>
				<th width="100">이름</th>
				<th width="150">패스워드</th>
				<th width="150">전화번호</th>
				<th width="100">주소</th>
				<th width="100">권한</th>
				<th width="25">수정</th>
				<th width="25">삭제</th>
			</tr>
			<c:choose>
				<c:when test="${empty list}">
					<tr>
						<td align="center" colspan="5">회원이 없습니다.</td>
					</tr>
				</c:when>
				<c:when test="${not empty list}">
					<c:forEach var="vo" items="${list }">
						<tr>
							<td align="center">${vo.memberid }
							<input type="hidden" id="memberid" name="memberid" value="${vo.memberid}">
							</td>
							<td>&nbsp;${vo.membername }</td>
							<td align="center">${vo.memberpassword }</td>
							<td align="center">${vo.membertel }</td>
							<td align="center">${vo.memberaddress }</td>
							<td align="center">${vo.membermauth }</td>
							<td><button type="button" onclick="editAlert()">수정</button></td>
							<td><button type="button" onclick="deleteAlert()">삭제</button></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table> <br />
		<div align="center">
			<button type="button" onclick="location.href='#'">회원등록</button>
		</div>
		</form>
	</div>
</body>
</html>