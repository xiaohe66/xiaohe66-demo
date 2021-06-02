<%--
  Created by IntelliJ IDEA.
  User: xh
  Date: 18-1-8 008
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    jsp四大作用域:
        内置对象，可以直接使用
        可以使用setAttribute()方法设置在对应作用域上设置值，
        用getAttribute()方法获取值
    request:
        在一个请求发起到响应结束
    session:
        一个会话
    pageContext:
        一个页面
    application：
        从应用服务器启动到关闭
--%>
<%
    request.setAttribute("request","request的值");
    session.setAttribute("session","session的值");
    pageContext.setAttribute("pageContext","pageContext的值");
    application.setAttribute("application","application的值");
%>
<html>
<head>
    <title>main</title>
</head>
<body>
    <%-- 页面跳转到target.jsp，看值是否能被取到 --%>
    <jsp:forward page="target.jsp"/>
</body>
</html>
