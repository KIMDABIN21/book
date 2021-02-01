<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- Page content -->
<div class="w3-content" style="max-width: 2000px; margin-top: 46px"
	align="center">
	<h1>대여할 수 있는 도서 리스트</h1>
	<div> <!-- 화면에는 보이지 않는 숨겨진 히든 폼 -->
			<form id="frm" name="frm" action="#" method="post">
				<input type="hidden" id=bookcode name="bookcode">
			</form>
		</div>
	<table border="1">
		<tr>
			<th width="100">도서 코드</th>
			<th width="250">도 서 명</th>
			<th width="150">기본 수량</th>
			<th width="150">현재 수량</th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td align="center" colspan="5">대여할 수 있는 목록이 없습니다.</td>
				</tr>
			</c:when>
			<c:when test="${not empty list }">
				<c:forEach var="vo" items="${list }">
					<tr>
						<td align="center">${vo.bookcode }</td>
						<td>&nbsp;${vo.bookname }</td>
						<td align="center">${vo.quantity }</td>
						<td align="center">${vo.bcount }</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
</div>
</head>
</body>
</html>