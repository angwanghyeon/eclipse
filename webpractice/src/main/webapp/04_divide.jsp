<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	0으로 나누는 것은 불능입니
	<%-- 강제 예외 발생 --%>
	<%= 2/0 %>
</body>
</html>