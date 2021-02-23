<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(function (){
            $("button").click(function () {
                //alert("click button");
                $.ajax({
                    url:"returnVoid_ajax.do",
                    data:{
                        name:"zhangsan",
                        age:28
                    },
                    type:"post",
                    dataType:"json",
                    success:function (resp) {
                        alert(resp);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>处理器方法返回String表示视图名称</p>
    <form action="return_String_view.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>
    <br/>
    <p>处理器方法返回String表示视图完整路径</p>
    <form action="return_String_view2.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>
    <br/>
    <button id="btn">发起ajax请求</button>
</body>
</html>
