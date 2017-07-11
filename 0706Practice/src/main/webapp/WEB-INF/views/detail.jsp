<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기 페이지</title>
</head>
<body>

	<table align="center" border="1">

		<tr>
			<td colspan="2" align="center">
				<h2>상세 보기</h2>
			</td>
		</tr>

		<tr>
			<td>글 번호</td>
			<td>${board.no}</td>
		</tr>

		<tr>
			<td>조회수</td>
			<td>${board.readcount}</td>
		</tr>

		<tr>
			<td>작성일</td>
			<td>${board.regdate}</td>
		</tr>

		<tr>
			<td>작성자</td>
			<td>${board.writer}</td>
		</tr>

		<tr>
			<td>제목</td>
			<td>${board.title}</td>
		</tr>

		<tr>
			<td>내용</td>
			<td><textarea rows="20" cols="30" readonly="readonly">${board.content}</textarea></td>
		</tr>

		<tr>
			<td colspan="2" align="center">
				<input type="button" value="삭제" id="delBt"/>
				<input type="button" value="목록" id="listBt"/>
				<input type="button" value="메인" id="mainBt"/>
			</td>
		</tr>

	</table>
	
	<script>
		// 삭제 버튼 클릭
		document.getElementById("delBt").onclick=function() {
			location.href="./delete?no=" + ${board.no}
		}
		
		// 목록 버튼 클릭
		document.getElementById("listBt").onclick=function() {
			// boardList 요청으로 이동
			location.href="./boardList"
		}
		
		// 메인 버튼 클릭
		document.getElementById("mainBt").onclick=function() {
			// ./ => / 요청으로 이동(즉, home으로 이동)
			location.href="./"
		}
		
	</script>

</body>
</html>