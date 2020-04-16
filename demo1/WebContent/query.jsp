<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/insert">添加文本</a><br/><hr>
	<textarea rows="10" cols="100" disabled="disabled">${text }</textarea>
</body>
</html>