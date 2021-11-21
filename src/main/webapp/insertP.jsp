<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/8/2021
  Time: 1:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP PAGE</title>
</head>
<body>
    <h1>Them San Pham</h1>
    <form action="insert" method="post">


        <label>name</label>
        <input type="text" name="name">
        <label>des</label>
        <input type="text" name="description">
        <label>price</label>
        <input type="text" name="price">
        <label>image</label>
        <input type="text" name="image">
        <label>id category</label>
        <input type="text" name="cid">

        <input type="submit" >
    </form>

</body>
</html>
