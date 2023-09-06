<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
	<h3>회원 정보 입력</h3>
	<form name="joinfrm" id="reg_frm" method="post"
		action="join.do">
		
		<label for="name">이름</label><span style="color:red;" > * </span> 
		<input type="text"
			name="name" id="name"  required="required"><br> 
			
		<label for="userid">아이디</label><span style="color:red;" >*</span> 
		<input type="text" id="userid" name="userid" required="required" size="20" >
		<input type="hidden" name="reid" id="reid" size="20">
		<input type="button" value="아이디 중복 확인" onclick="idCheck()"><br>
			
		<label for="pwd">비밀번호</label><span style="color:red;" > * </span> 
		<input type="password" id="pwd" name="pwd" required="required" ><br>
		
		<label for="pwd_check">비밀번호 확인</label><span style="color:red;" > * </span> 
		<input type="password" id="pwd_check" name="pwd_check" required="required" ><br>
		
		<label for="email">이메일</label><span style="color:red;" > * </span> 
		<input type="email"
			id="email" name="email" required="required" ><br>
			
		<label for="phone">전화번호</label><span style="color:red;" > * </span> 
		<input type="tel"
			id="phone" name="phone" required="required" ><br>
			
		<label for="admin">등급</label><span style="color:red;" > * </span> 
		<input type="radio"
			name="admin"  value="0">일반회원
		<input type="radio"
			name="admin"  value="1">관리자<br>

		<input type="submit" value="회원가입" onclick="return joinCheck()">
		<input type="reset" value="취소" onclick="location.href='login.do'">
	</form>
	<hr>
	<p>${message}</p>
</body>
</html>