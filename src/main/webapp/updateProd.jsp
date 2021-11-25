<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/24/2021
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Cap nhat san Pham</h1>
<form action="updateP" method="post">

    <label>id</label>
    <input value="${product.id}" type="text" name="pid">
    <label>name</label>
    <input value="${product.name}" type="text" name="name">
    <label>description</label>
    <input value="${product.description}" type="text" name="description">
    <label>price</label>
    <input value="${product.price}" type="text" name="price">
    <label>image</label>
    <input value="${product.image}" type="text" name="image">
    <label>title</label>
    <input value="${product.title}" type="text" name="title">

    <input type="submit" >
</form>
</body>
</html>
