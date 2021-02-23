<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 获得请求的绝对地址
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>Title</title>
<%--    <base href="http://localhost:8080/ch06_path_war_exploded/"/>--%>
    <base href="<%=basePath%>">
</head>
<body>
    <p><a href="test/some.do">发起some.do请求</a></p>
    <p><a href="/ch06_path_war_exploded/test/some.do">发起some.do请求  带有/</a></p>
    <p><a href="${pageContext.request.contextPath}/test/some.do">发起some.do请求</a></p>
</body>
</html>
