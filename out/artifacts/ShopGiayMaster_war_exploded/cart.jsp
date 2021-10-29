<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/19/2021
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart Shop</title>

    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />

    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <!-- custom css file link  -->
    <link rel="stylesheet" href="css/stylehome.css">
    <link rel="stylesheet" href="css/stylecart.css">
</head>
<body>
<header>

    <a href="<c:url value = "/index.jsp"/>" class="logo"><i class="fas fa-utensils"></i>resto.</a>

    <nav class="navbar">
        <a href="<c:url value = "/index.jsp"/>">home</a>
        <a href="<c:url value = "/index.jsp#dishes"/>">best</a>
        <a href="<c:url value = "/about.jsp"/>">about</a>
        <a href="<c:url value = "/product.jsp"/>">product</a>
        <a href="#review">review</a>
    </nav>

    <div class="icons">
        <i class="fas fa-bars" id="menu-bars"></i>
        <i class="fas fa-search" id="search-icon"></i>
        <a href="" class="fas fa-heart"></a>
        <a href="<c:url value = "/cart.jsp"/>" class="fas fa-shopping-cart" style="background: limegreen"></a>
        <a href="<c:url value = "/register.jsp"/>" class="fas fa-user-plus"></a>
        <a href="<c:url value = "/login.jsp"/>" class="fas fa-sign-in-alt"></a>

    </div>

</header>

<!-- header section ends-->

<!-- search form  -->

<form action="" id="search-form">
    <input type="search" placeholder="Search here..." name="" id="search-box">
    <label for="search-box" class="fas fa-search"></label>
    <i class="fas fa-times" id="close"></i>
</form>
<!-- Cart Items -->
<div class="container-md cart">
    <table>
        <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Subtotal</th>
        </tr>
        <tr>
            <td>
                <div class="cart-info">
                    <img src="./images/product-1.jpg" alt="">
                    <div>
                        <p>Nike Ari Force 1</p>
                        <span>Price: $50.00</span>
                        <br />
                        <a href="#">remove</a>
                    </div>
                </div>
            </td>
            <td><input type="number" value="1" min="1"></td>
            <td>$50.00</td>
        </tr>
        <tr>
            <td>
                <div class="cart-info">
                    <img src="./images/product-2.jpg" alt="">
                    <div>
                        <p>Nike Low Jordan</p>
                        <span>Price: $90.00</span>
                        <br />
                        <a href="#">remove</a>
                    </div>
                </div>
            </td>
            <td><input type="number" value="1" min="1"></td>
            <td>$90.00</td>
        </tr>
        <tr>
            <td>
                <div class="cart-info">
                    <img src="./images/product-12.jpg" alt="">
                    <div>
                        <p>Adidas</p>
                        <span>Price: $60.00</span>
                        <br />
                        <a href="#">remove</a>
                    </div>
                </div>
            </td>
            <td><input type="number" value="1" min="1"></td>
            <td>$60.00</td>
        </tr>
        <tr>
            <td>
                <div class="cart-info">
                    <img src="./images/product-4.jpg" alt="">
                    <div>
                        <p>Jordan 4</p>
                        <span>Price: $60.00</span>
                        <br />
                        <a href="#">remove</a>
                    </div>
                </div>
            </td>
            <td><input type="number" value="1" min="1"></td>
            <td>$60.00</td>
        </tr>
        <tr>
            <td>
                <div class="cart-info">
                    <img src="./images/product-1.jpg" alt="">
                    <div>
                        <p>Gucci</p>
                        <span>Price: $60.00</span>
                        <br />
                        <a href="#">remove</a>
                    </div>
                </div>
            </td>
            <td><input type="number" value="1" min="1"></td>
            <td>$60.00</td>
        </tr>
    </table>

    <div class="total-price">
        <table>
            <tr>
                <td>Subtotal</td>
                <td>$200</td>
            </tr>
            <tr>
                <td>Tax</td>
                <td>$50</td>
            </tr>
            <tr>
                <td>Total</td>
                <td>$250</td>
            </tr>
        </table>
        <a href="#" class="checkout btn">Proceed To Checkout</a>

    </div>
</div>
<!-- footer section starts  -->

<section class="footer">

    <div class="box-container">

        <div class="box">
            <h3>locations</h3>
            <a href="#">india</a>
            <a href="#">japan</a>
            <a href="#">russia</a>
            <a href="#">USA</a>
            <a href="#">france</a>
        </div>

        <div class="box">
            <h3>quick links</h3>
            <a href="#">home</a>
            <a href="#">best</a>
            <a href="#">about</a>
            <a href="#">product</a>
            <a href="#">reivew</a>
        </div>

        <div class="box">
            <h3>contact info</h3>
            <a href="#">+097-940-9568</a>
            <a href="#">+111-222-3333</a>
            <a href="#">a3hteam@gmail.com</a>
            <a href="#">shopgiaya3h@gmail.com</a>
            <a href="#">HoChiMinh, VietNam - 84</a>
        </div>

        <div class="box">
            <h3>follow us</h3>
            <a href="#">facebook</a>
            <a href="#">twitter</a>
            <a href="#">instagram</a>
            <a href="#">linkedin</a>
        </div>
        <!--Start of Tawk.to Script-->
        <script type="text/javascript">
            var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
            (function(){
                var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
                s1.async=true;
                s1.src='https://embed.tawk.to/61702f4c86aee40a5737897a/1fif3hgvu';
                s1.charset='UTF-8';
                s1.setAttribute('crossorigin','*');
                s0.parentNode.insertBefore(s1,s0);
            })();
        </script>
        <!--End of Tawk.to Script-->
    </div>

    <div class="credit"> copyright @ 2021 by <span>Shop A3hTeam</span> </div>

</section>
</body>
</html>
