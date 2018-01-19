<%--
  Created by IntelliJ IDEA.
  User: xh
  Date: 18-1-8 008
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String requestVal = (String) request.getAttribute("request");
    String sessionVal = (String) session.getAttribute("session");
    String pageContextVal = (String) pageContext.getAttribute("pageContext");
    String applicationVal = (String) application.getAttribute("application");
%>
<html>
<head>
    <title>target</title>
</head>
<body>
    <P><%=requestVal%></P>
    <P><%=sessionVal%></P>
    <P><%=pageContextVal%></P>
    <P><%=applicationVal%></P>
</body>
</html>
