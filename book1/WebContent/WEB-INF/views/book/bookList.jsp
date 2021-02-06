 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
tr.row:hover {
	background-color: lightyellow
}
</style>

<jsp:include page="../common/menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width: 2000px; margin-top: 46px"
	align="center">
	<h1>대여할 수 있는 도서 리스트</h1>
	<table border="1">
		<tr>
			<th width="100">도서 코드</th>
			<th width="250">도 서 명</th>
			<th width="150">기본 수량</th>
			<th width="150">현재 수량</th>
			<th width="25">대여</th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
				  <td align="center" colspan="5">대여할 수 있는 목록이 없습니다.</td>
				</tr>
			</c:when>
			<c:when test="${not empty list}">
				<c:forEach var="vo" items="${list }">
					<tr class="row">
						<td align="center">${vo.bookcode }</td>
						<td>&nbsp;${vo.bookname }</td>
						<td align="center">${vo.quantity }</td>
						<td align="center">${vo.bcount }</td>
						<c:if test="${vo.bcount > 0}">
						<td><button type="button" onclick="location.href='borrowBook.do?bookcode='+${vo.bookcode }">대여</button></td>
						</c:if>
					</tr>
				</c:forEach>
				</c:when>
		</c:choose>
	</table>
</div>
</body>
</html>