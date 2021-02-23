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
    <title>功能入口</title>
    <base href="<%=basePath%>"/>
</head>
<body>
    <div align="center">
        <p>SSM整合开发</p>
        <img src="images/pic1.jpg" width="200" height="200"/>
        <table>
            <tr>
                <td><a href="addStudent.jsp">添加学生</a></td>
            </tr>
            <tr>
                <td><a href="listStudent.jsp">浏览学生</a></td>
            </tr>
        </table>
    </div>

</body>
</html>
