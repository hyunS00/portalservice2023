<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="kr.ac.jejunu.user.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: hyeonsugim
  Date: 2023/05/12
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejunu.user");
    UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
%>
<html>
<head>
    <title>Hello</title>
</head>
<body>
Hi  <%=userDao.findById(Long.parseLong(request.getParameter("id"))).getName()%>
</body>
</html>
