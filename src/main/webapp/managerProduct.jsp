<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
<%--        <th>title</th>--%>
        <th>des</th>
        <th>categoryID</th>
    </tr>
    <c:forEach items="${products}" var="pro">
        <form method="post" action="load">
            <tr>
                <td>${pro.id}</td>
                <td>${pro.name}</td>
                <td>${pro.price}</td>
<%--                <td>${pro.title}</td>--%>
                <td>${pro.desciption}</td>
                <td>${pro.category.id}</td>
                <td>
                    <input type="submit" formaction="updateProduct.jsp" name="action" value="update">
<%--                    <input type="submit" formaction="delete?pid=${pro.id}" name="action" value="delete">--%>
                    <a href="#" onclick="showMess(${pro.id})" >DELETE</a>
                </td>
            </tr>
        </form>
    </c:forEach>
</table>
    <a href="insertP.jsp">Create Product</a>
</body>
<script>
    function showMess(id){
        var option = confirm('Are you sure to delete');
        if(option === true){
            window.location.href='delete?pid='+id;
        }
    }
</script>
</html>