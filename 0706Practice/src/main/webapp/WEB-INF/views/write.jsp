<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 작성</title>
</head>
<body>

	<!-- 사용자로 부터 입력 받을 때는 form 사용-->
	<!-- form안에 password, textarea, file이 있을 때는 method는 반드시 post로 전송해야 함! -->
	<!-- WHY? get 방식은 주소에 파라미터가 표시되기 때문에 보안성이 없고 글자수 제한이 있음 -->
	<form action="saveboard" method="post">
		<table align="center" border="1">
			<tr>
				<td colspan="2">
					<h2>게시글 작성</h2>
				</td>
			</tr>

			<tr>
				<td>작성자</td>
				<td><input type="text" size="20" name="writer"
					required="required" /></td>
			</tr>


			<tr>
				<td>제목</td>
				<td><input type="text" size="20" name="title"
					required="required" /></td>
			</tr>

			<tr>
				<td>내용</td>
				<td><textarea rows="20" cols="30" name="content"></textarea></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="button"
					value="목록으로" id="listBt" /> <input type="reset" value="작성취소" /> <input
					type="submit" value="등록하기" /></td>
			</tr>
		</table>
	</form>

	<script>
		// 메인으로 버튼 처리 함수 구현
		document.getElementById("listBt").onclick = function() {
			location.href = "./boardList";
			// "이동하고 싶은 요청 코드"
			// ./ => home으로 이동
		}
	</script>



</body>
</html>