<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p><a href="test/some.do">发起some.do请求</a></p>
    <p><a href="/ch06_path_war_exploded/test/some.do">发起some.do请求  带有/</a></p>
    <p><a href="${pageContext.request.contextPath}/test/some.do">发起some.do请求</a></p>
</body>
</html>
