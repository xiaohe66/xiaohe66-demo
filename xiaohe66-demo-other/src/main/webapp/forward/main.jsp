<%--
  Created by IntelliJ IDEA.
  User: xh
  Date: 18-1-6 006
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
    main页面
    <jsp:forward page="target.jsp">
        <jsp:param name="arg1" value="参数1"/>
        <jsp:param name="arg2" value="参数2"/>
    </jsp:forward>
</body>
</html>
