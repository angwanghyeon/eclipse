<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="member" class="com.keduit.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name="member"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member test</title>
</head>
<body>
	<h2>회원 정보</h2>
	<p>이름 : <jsp:getProperty property="name" name="member"/> </p>
	<p>아이디 : <jsp:getProperty property="userid" name="member"/> </p>
	<p>닉네임 : <jsp:getProperty property="nickname" name="member"/> </p>
	<p>비밀번호 : <jsp:getProperty property="pwd" name="member"/> </p>
</body>
</html>