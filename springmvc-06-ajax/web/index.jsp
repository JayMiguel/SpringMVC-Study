<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>

    <script>
        function a() {
            $.post({
                url: "${pageContext.request.contextPath}/a1",
                data: {"username": $("#username").val()},
                success: function (data, status) {
                    console.log("data: " + data);
                    console.log("status: " + status);
                },
                error: function (data, status) {
                    console.log("status: " + status);
                }
            })
        }
    </script>
</head>
<body>

用户名：<input type="text" id="username" onblur="a()"/>
</body>
</html>
