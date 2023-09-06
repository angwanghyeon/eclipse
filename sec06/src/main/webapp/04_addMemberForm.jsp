<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>회원 정보 입력</h3>
	<form name="joinfrm" id="reg_frm" method="post"
		action="memberservlet">
		
		<label for="name">이름</label><span> * </span> 
		<input type="text"
			name="name" id="name" value="민수킴"><br> 
			
		<label for="userid">아이디</label><span>*</span> 
		<input type="text" id="userid" name="userid" value="msKim"><br>

		<label for="nickname">닉네임</label><span> * </span> 
		<input type="text"
			id="nickname" name="nickname" value="msKim"><br>
			
		<label for="pwd">비밀번호</label><span> * </span> 
		<input type="password" id="pwd" name="pwd" value="1234"><br>

		<input type="submit" value="회원가입">
		<input type="reset" value="취소">
	</form>
</body>
</html>