<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/23/2021
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Danh sách</title>
    <style><%@include file="/css/productAdmin.css"%></style>
</head>
<body>
<%--HEADER ADMIN--%>
<c:import url="/header.jsp"/>
<%--/HEADER ADMIN--%>
<div class="div--flex">
    <div class="div-flex__div">
        <h1>Danh sách sản phẩm</h1>
        <div class="div__table--scroll table--pro">
            <table>
                <tr>
                    <%--                    <th>id</th>--%>
                    <th>name</th>
                    <th>price</th>
                    <%--                    <th>image</th>--%>
                    <th>title</th>
                    <th>des</th>
                    <th>category</th>
                </tr>
                <c:forEach items="${products}" var="pro">
                    <form method="post" action="load">
                    <tr>
                            <%--                        <td>${pro.id}</td>--%>
                        <td>${pro.name}</td>
                        <td>${pro.price}</td>
                            <%--            <td>${pro.image}</td>--%>
                        <td>${pro.title}</td>
                        <td>${pro.description}</td>
                        <td>${pro.category.name}</td>
                        <td>
                            <div class="div--link div--btn-delete">
                                <a class="btn btn-link btn-delete" href="updateP?pid=${pro.id}">Update</a>
                                <a href="#" onclick="showMess(${pro.id})" >DELETE</a>
                            </div>
<%--                                <input type="hidden" name="id" value="${pro.id}">--%>
<%--                                <a href="update?pid=${pro.id}">Update</a>--%>
<%--                                <input class="btn" formaction="update" type="submit" value="update">--%>
<%--                                <a href="#" onclick="showMess(${pro.id})" >DELETE</a>--%>
<%--                                <input class="btn" type="submit" formaction="delete" value="delete">--%>
                        </td>
                    </tr>
                    </form>
                </c:forEach>
            </table>
        </div>
        <div class="div--link">
            <a class="btn btn-link" href="insertP.jsp">Create Product</a>
        </div>
        <script>
            function showMess(id){
                var option = confirm('Are you sure to delete');
                if(option === true){
                    window.location.href='ServletDelete?pid='+id;
                }
            }
        </script>
    </div>
    <div class="div-flex__div">
        <h1>Danh sách danh mục</h1>
        <div class="div__table--scroll table--cate">
            <table>
                <tr>
                    <th>Name</th>
                </tr>
                <c:forEach items="${category}" var="cate">
                    <form method="post" action="load">
                    <tr>
                        <td>${cate.name}</td>
                        <td>
                            <div class="div--link div--btn-delete">
                                <a class="btn btn-link btn-delete" href="updateC?cid=${cate.id}">Update</a>
                                <a class="btn btn-link btn-delete" href="#" onclick="showMess(${cate.id})" >DELETE</a>
                            </div>
                        </td>
                    </tr>
                    </form>
                </c:forEach>
            </table>
        </div>
        <div class="div--flex">
            <div class="div--link">
                <a class="btn btn-link" href="insertC.jsp">Create Category</a>
            </div>
        </div>
        <script>
            function showMess(id){
                var option = confirm('Are you sure to delete');
                if(option === true){
                    window.location.href='deleteC?cid='+id;
                }
            }
        </script>
    </div>
</div>
</body>
</html>
