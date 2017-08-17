<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../resources/assets/css/bootstrap.min.css" rel="stylesheet" />
<script src="../resources/assets/js/bootstrap.min.js" type="text/javascript"></script>

<!-- jquery.js 설정 -->
<script type="text/javascript">
function goPrevious() {
	history.back();
}

//아이디 클릭시 회원강퇴 창으로 이동
function openMemberDelete(id) {
// 	alert(id);
	window.name = "parentForm";
// 	입력한 아이디를 AdminMemberDelete까지 넘겨줌
	window.open("./AdminMemberDeleteForm?id="+id,  "AdminMemberDeleteForm?id="+id,
			"width=500, height=300, resizable = no, scrollbars = no");

	
	
}
</script>
<title>Insert title here</title>
</head>
<body>
<div>
		<table class="table">
			<h2 class="header">검색 결과</h2>
			
			<th>아이디</th>
			<th>이름</th>
			<th>닉네임</th>
			<th>생년월일</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>성별</th>
			<th>보유 포인트</th>
			<c:forEach var="list"  items="${memberList}" >
				<tr>
				
					<td><button onclick="openMemberDelete('${list.id}')" class="btn btn-default"><c:out value="${list.id}" /></button></td>
					<td><c:out value="${list.name}" /></td>
					<td><c:out value="${list.nickName}" /></td>
					<td><c:out value="${list.birth}" /></td>
					<td><c:out value="${list.hp}" /></td>
					<td><c:out value="${list.email}" /></td>
					<td><c:out value="${list.gender}" /></td>
					<td><c:out value="${list.point}" /></td>
				</tr>
			</c:forEach>

		</table>
		<input type="button" value="이전" onclick="goPrevious()" class="btn btn-default">

</body>
</html>