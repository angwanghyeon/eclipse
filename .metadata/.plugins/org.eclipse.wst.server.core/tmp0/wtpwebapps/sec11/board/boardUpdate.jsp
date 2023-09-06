<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정하기</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<div id="wrap" align="center">
	<h1>게시물 수정하기</h1>
	<form action="BoardServlet" name="frm" method="post">
	<%-- action에 전부다 박을 필요 없이 input에 name이랑 value를 줘서 붙여서 보낸다. --%>
		<input type="hidden" name="command" value="board_update">
		<input type="hidden" name="num" value="${board.num}">
		<input type="hidden" name="readcount" value="${board.readcount}">
		<input type="hidden" name="writedate" value="${board.writedate}">
		 <table>
			 <tr>
				<th>작성자</th>
				<td><input type="text" name="name" value="${board.name}"></td>
			 </tr>
			 <tr>
				<th>비밀번호</th>
				<td><input type="password" name="pass"
				autocomplete="current-password" value="${board.pass}"></td>
			 </tr>
			 <tr>
				<th>이메일</th>
				<td><input type="email" name="email" value="${board.email}"></td>
			 </tr>
			 <tr>
				<th>제목</th>
				<td><input type="text" name="title" size="70" value="${board.title}"></td>
			 </tr>
			 <tr>
				<th>내용</th>
				<td><textarea name="content" rows="15" cols="70">${board.content}</textarea></td>
			 </tr>
		 </table>
		 <br><br>
		 <input type="submit" value="수정" onclick="return boardCheck()">
		 <input type="reset" value="다시 작성">
		 <input type="button" value="목록"
		 onclick="location.href='BoardServlet?command=board_list'">
	</form>
</div>
</body>
</html>