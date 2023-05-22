<%--
  Created by IntelliJ IDEA.
  User: hyeonsugim
  Date: 2023/05/19
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<h1>Upload!!</h1>
<form action="/upload" method="post" enctype="multipart/form-data">
  <input type="file"/>
  <input type="submit"/>
</form>
<img src="${url}">
</body>
</html>
