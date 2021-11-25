<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/24/2021
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Cap nhat san Pham</h1>
<form action="updateC" method="post">

    <label>id</label>
    <input value="${category.id}" type="text" name="cid">
    <label>name</label>
    <input value="${category.name}" type="text" name="name">

    <input type="submit" >
</form>
</body>
</html>
