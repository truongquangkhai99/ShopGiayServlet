<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shopping Cart</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>
<center>
    <h2>Shopping Cart</h2>
    <a href="${pageContext.request.contextPath }/ModelList.jsp" >Model List</a>
    <table width="75%" border="1">
        <tr bgcolor="#CCCCCC">
            <td>Description</td>
            <td>Quantity</td>
            <td>Unit Price </td>
            <td>Total</td>
        </tr>
        <jsp:useBean id="cart" scope="session" class="com.controller.CartBean" />

        <c:if test="${cart.lineItemCount == 0}">
            <tr> <td colspan="4">- Cart is currently empty -</td></tr>
        </c:if>

        <c:forEach var="cartItem" items="${cart.list}" varStatus="counter">
            <form name="item" method="POST" action="CartController">
                <tr>
                    <td><c:out value="${cartItem.description}"/></td>
                    <td>
                        <input type='hidden' name='stt' value='<c:out value="${counter.count}"/>'>
                        <input type='number' name="quantity" value='<c:out value="${cartItem.quantity}"/>'>
                        <input type="submit" name="action" value="Update">
                        <input type="submit" name="action" value="Delete">
                    </td>
                    <td>$<c:out value="${cartItem.price}"/></td>
                    <td>$<c:out value="${cartItem.totalCost}"/></td>
                </tr>
            </form>
        </c:forEach>
        <!--Total-->
        <tr>
            <td colspan="3"> </td>
            <td>Subtotal: $<c:out value="${cart.total}"/></td>
        </tr>
    </table>
</center>
</body>
</html>