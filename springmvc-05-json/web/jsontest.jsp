<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        // 创建一个JS对象
        var user = {
            name:"Miguel",
            age:3,
            sex:"男"
        };

        // 把JS对象转换为字符串
        var json = JSON.stringify(user);
        console.log(json);

        // 把JSON字符串转换为JS对象
        var obj = JSON.parse(json);
        console.log(obj);
    </script>
</head>
<body>

</body>
</html>
