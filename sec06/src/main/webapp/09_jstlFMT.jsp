<%@page import="java.util.Date"%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl fmt</title>
</head>
<body>
<c:set var="now" value="<%= new java.util.Date() %>"></c:set>
\${now} = ${now} <br>
<fmt:formatDate value="${now}" /> <br>
date : <fmt:formatDate value="${now}" type="date" />
<p>time : <fmt:formatDate value="${now}" type="time" /> </p>
<p>both : <fmt:formatDate value="${now}" type="both" /> </p>
<p>default : <fmt:formatDate value="${now}" type="both" dateStyle="default" /> </p>
<p>long : <fmt:formatDate value="${now}" type="both" dateStyle="long" /> </p>
<p>medium : <fmt:formatDate value="${now}" type="both" dateStyle="medium" /> </p>
<p>short : <fmt:formatDate value="${now}" type="both" dateStyle="short" /> </p>
<p>pattern = "yyyy년 MM월 dd일 hh시 mm분 ss초" : 
	<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/>
</p>
</body>
</html>