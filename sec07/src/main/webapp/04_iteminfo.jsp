<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
<h2>정보 입력 폼</h2>
<form name="itemform" id="reg_frm" 
		method="post" action="05_item.jsp">
	<label for="itemname">상품명</label>
	<input type="text" id="itemname" name="itemname" required="required"><br>
	
	<label for="price">가격</label>
	<input type="number" id="price" name="price"><br>
	
	<label for="itemdescription">설명</label>
	<input type="text" id="itemdescription" name="itemdescription"><br>
	
	<input type="submit" value="전송">
	<input type="reset" value="취소">
</form>
</body>
</html>