<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>这是添加文本页面</h1><hr>
	<form action="${pageContext.request.contextPath }/insert" method="post" enctype="application/x-www-form-urlencoded">
		要添加的文本内容：<textarea rows="10" cols="50" name="text" ></textarea>
		<input type="submit"/ >
	</form>
</body>
</html>