<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jquery.js 설정 -->
<!-- <script type="text/javascript" -->
<!-- 	src="../resources/js/jquery-1.12.4.min.js"></script> -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
			$("#searchMember").click(function() {
			var allData=$("#form").serialize();
			//alert("회원 검색 처리");
			$.ajax({
				url : "AdminSearchMemberView",
				type : "post",
				data:allData,
				success : function(result) {
					$("#hiscontainer").html(result);
				}
			})
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
<form name="form" id="form">
<br><br><br><br><br>
	<fieldset><label>검색조건</label>
	<table class="table">
		<tr>
			<td>아이디 <input type="text" name="id" id="id">&nbsp;이메일 <input
				type="text" name="email" id="email">&nbsp;전화번호 <input type="text"
				name="hp" id="hp"></td>
			<td rowspan="2"><button class="btn btn-default" type="button"
					id="searchMember">검색</button></td>

		</tr>
		<tr>
			<td>이름&nbsp; <input type="text" name="name" id="name"> &nbsp;
			
<!-- 			<label -->
<!-- 				for="nation">국가:</label> <select name="nationSelect"> -->
<!-- 					<option value="미국">미국</option> -->
<!-- 					<option value="호주">호주</option> -->
<!-- 					<option value="영국">영국</option> -->
<!-- 					<option value="필리핀">필리핀</option> -->
<!-- 					<option value="중국">중국</option> -->
<!-- 					<option value="일본">일본</option> -->
<!-- 					<option value="한국">한국</option> -->
<!-- 					<option value="기타">기타</option> -->
<!-- 			</select> -->
			</td>
		</tr>

	</table>
	</fieldset>
	</form>
	<div id="hiscontainer"></div>
</body>
</html>