<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<jsp:include page="../common/menu.jsp" /><br/>
<body>
	<div align="center">
	  <div>  	
		<table border="1">
			<tr>
				<th>책번호</th>
				<th>회원번호</th>
				<th>대여일자</th>
				<th>반납일자</th>
				<th>반납</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<c:if test="${vo.memberid eq memberid}">
					<tr>
						<td >
							<input type="text" id="bookcode" name="bookcode" value="${vo.bookcode }" readonly="readonly" size="5">
						</td>
						<td>${vo.memberid }</td>
						<td>${vo.rentaldate }</td>
						<td>${vo.returndate }</td>
						<td>
							<button type="button" onclick="location.href='bookReturn.do?bookcode='+${vo.bookcode }">반납</button>
						</td>
					</tr>
				</c:if>
			</c:forEach>		
		</table>
	  </div>
	</div>
</body>
</html>