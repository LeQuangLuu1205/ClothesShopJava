
<%@page import="java.util.Map"%>
<%@page import="com.luu.model.Product"%>
<%@page import="java.util.TreeMap"%>
<%@page import="com.luu.model.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>E Store - eCommerce HTML Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="eCommerce HTML Template Free Download" name="keywords">
    <meta content="eCommerce HTML Template Free Download" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap"
        rel="stylesheet">

    <!-- CSS Libraries -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="lib/slick/slick.css" rel="stylesheet">
    <link href="lib/slick/slick-theme.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <%
    	Cart cart = (Cart) session.getAttribute("cart");
    	if (cart == null){
    		cart = new Cart();
    		session.setAttribute("cart", cart);
    	}
    	TreeMap<Product,Integer> list = cart.getList();
    	double total = 0;
    %>
    <div class="nav">
        <div class="container-fluid">
            <nav class="navbar navbar-expand-md bg-dark navbar-dark">
                <a href="#" class="navbar-brand">MENU</a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                    <div class="navbar-nav mr-auto">
                        <a href="index.jsp" class="nav-item nav-link">Home</a>
                        <a href="loadproduct" class="nav-item nav-link">Products</a>
                        <a href="product-detail.jsp" class="nav-item nav-link">Product Detail</a>
                        <a href="cart.jsp" class="nav-item nav-link active">Cart</a>
                        <a href="checkout.jsp" class="nav-item nav-link">Checkout</a>
                        <a href="my-account.html" class="nav-item nav-link">My Account</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">More Pages</a>
                            <div class="dropdown-menu">
                                <a href="wishlist.html" class="dropdown-item">Wishlist</a>
                                <a href="login.jsp" class="dropdown-item">Login & Register</a>
                                <a href="contact.html" class="dropdown-item">Contact Us</a>
                            </div>
                        </div>
                    </div>
                    <div class="navbar-nav ml-auto">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"> <span><%=session.getAttribute("acc_username") %></span></a>
                            <div class="dropdown-menu">
                               <a href="loginServlet?command=login" class="dropdown-item">Login</a>
                                <a href="#" class="dropdown-item">Register</a>
                                <a href="loginServlet?command=logout" class="dropdown-item">Logout</a>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    </div>
    <!-- Nav Bar End -->

    <!-- Bottom Bar Start -->
    <div class="bottom-bar">
        <div class="container-fluid">
            <div class="row align-items-center">
                <div class="col-md-3">
                    <div class="logo">
                        <a href="index.html">
                            <img src="img/logo.png" alt="Logo">
                        </a>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="search">
                        <input type="text" placeholder="Search">
                        <button><i class="fa fa-search"></i></button>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="user">
                        <a href="wishlist.html" class="btn wishlist">
                            <i class="fa fa-heart"></i>
                            <span>(0)</span>
                        </a>
                        <a href="cart.jsp" class="btn cart">
                            <i class="fa fa-shopping-cart"></i>
                            <span>(0)</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Bottom Bar End -->

    <!-- Breadcrumb Start -->
    <div class="breadcrumb-wrap">
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Products</a></li>
                <li class="breadcrumb-item active">Cart</li>
            </ul>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Cart Start -->
    <div class="cart-page">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8">
                    <div class="cart-page-inner">
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Product</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Total</th>
                                        <th>Remove</th>
                                    </tr>
                                </thead>
                                <tbody class="align-middle">
                                <%for(Map.Entry<Product, Integer> ds: list.entrySet()){%>
                                
                                	
                                		
                                	
                                    <tr>
                                        <td>
                                            <div class="img">
                                                <a href="#"><img src="img/<%=ds.getKey().getProduct_img() %>" alt="Image"></a>
                                                <p><%=ds.getKey().getProduct_name() %></p>
                                            </div>
                                        </td>
                                        <td>$<%=ds.getKey().getProduct_price() %></td>
                                        <td>
                                            <div class="qty">
                                                <button class="btn-minus"><a  href="cartServlet?command=sub&product_id=<%=ds.getKey().getProduct_id()%>&cart_id=<%=(long) Math.floor(((Math.random() * 899999) + 100000))%>"><i class="fa fa-minus"></i></a></button>
                                                <input type="text" value="<%=ds.getValue()%>">
                                                <button class="btn-plus"><a  href="cartServlet?command=plus&product_id=<%=ds.getKey().getProduct_id()%>&cart_id=<%=(long) Math.floor(((Math.random() * 899999) + 100000))%>"><i class="fa fa-plus"></i></a></button>
                                                
                                                <!--  <i class="fa fa-plus"></i>-->
                                                <!--  <i class="fa fa-minus"></i>-->
                                                <!-- <button class="btn-plus"> -->
                                            </div>
                                        </td>
                                        
                                        <td>$<%=ds.getValue() * ds.getKey().getProduct_price()%></td>
                                        <%total = total+ ds.getValue() * ds.getKey().getProduct_price();%>
                                        <td><button><a button_a href="cartServlet?command=remove&product_id=<%=ds.getKey().getProduct_id()%>&cart_id=<%=(long) Math.floor(((Math.random() * 899999) + 100000))%>"><i class="fa fa-trash"></i></a></button></td>
                                    </tr>
                                    <%} %>
                                    <!--  
                                    <tr>
                                        <td>
                                            <div class="img">
                                                <a href="#"><img src="img/product-2.jpg" alt="Image"></a>
                                                <p>Product Name</p>
                                            </div>
                                        </td>
                                        <td>$99</td>
                                        <td>
                                            <div class="qty">
                                                <button class="btn-minus"><i class="fa fa-minus"></i></button>
                                                <input type="text" value="1">
                                                <button class="btn-plus"><i class="fa fa-plus"></i></button>
                                            </div>
                                        </td>
                                        <td>$99</td>
                                        <td><button><i class="fa fa-trash"></i></button></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="img">
                                                <a href="#"><img src="img/product-3.jpg" alt="Image"></a>
                                                <p>Product Name</p>
                                            </div>
                                        </td>
                                        <td>$99</td>
                                        <td>
                                            <div class="qty">
                                                <button class="btn-minus"><i class="fa fa-minus"></i></button>
                                                <input type="text" value="1">
                                                <button class="btn-plus"><i class="fa fa-plus"></i></button>
                                            </div>
                                        </td>
                                        <td>$99</td>
                                        <td><button><i class="fa fa-trash"></i></button></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="img">
                                                <a href="#"><img src="img/product-4.jpg" alt="Image"></a>
                                                <p>Product Name</p>
                                            </div>
                                        </td>
                                        <td>$99</td>
                                        <td>
                                            <div class="qty">
                                                <button class="btn-minus"><i class="fa fa-minus"></i></button>
                                                <input type="text" value="1">
                                                <button class="btn-plus"><i class="fa fa-plus"></i></button>
                                            </div>
                                        </td>
                                        <td>$99</td>
                                        <td><button><i class="fa fa-trash"></i></button></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="img">
                                                <a href="#"><img src="img/product-5.jpg" alt="Image"></a>
                                                <p>Product Name</p>
                                            </div>
                                        </td>
                                        <td>$99</td>
                                        <td>
                                            <div class="qty">
                                                <button class="btn-minus"><i class="fa fa-minus"></i></button>
                                                <input type="text" value="1">
                                                <button class="btn-plus"><i class="fa fa-plus"></i></button>
                                            </div>
                                        </td>
                                        <td>$99</td>
                                        <td><button><i class="fa fa-trash"></i></button></td>
                                    </tr>
                                </tbody>
                            		-->
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="cart-page-inner">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="coupon">
                                    <input type="text" placeholder="Coupon Code">
                                    <button>Apply Code</button>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="cart-summary">
                                    <div class="cart-content">
                                        <h1>Cart Summary</h1>
                                        <p>Sub Total<span><%= Math.round(total) %></span></p>
                                        <p>Shipping Cost<span><%= Math.round(total *0.01)%></span></p>
                                        <h2>Grand Total<span>$<%= Math.round(total*1.01)%></span></h2>
                                    </div>
                                    <div class="cart-btn">
                                        <button>Update Cart</button>
                                        <button><a href="checkout.jsp">Checkout</a></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Cart End -->

    <!-- Footer Start -->
    <div class="footer">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="footer-widget">
                        <h2>Get in Touch</h2>
                        <div class="contact-info">
                            <p><i class="fa fa-map-marker"></i>48 Cao Thang, Hai Chau, Da Nang</p>
                            <p><i class="fa fa-envelope"></i>estore@gmail.com</p>
                            <p><i class="fa fa-phone"></i>(+84) 797979797</p>
                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6">
                    <div class="footer-widget">
                        <h2>Follow Us</h2>
                        <div class="contact-info">
                            <div class="social">
                                <a href=""><i class="fab fa-twitter"></i></a>
                                <a href=""><i class="fab fa-facebook-f"></i></a>
                                <a href=""><i class="fab fa-linkedin-in"></i></a>
                                <a href=""><i class="fab fa-instagram"></i></a>
                                <a href=""><i class="fab fa-youtube"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6">
                    <div class="footer-widget">
                        <h2>Company Info</h2>
                        <ul>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Terms & Condition</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6">
                    <div class="footer-widget">
                        <h2>Purchase Info</h2>
                        <ul>
                            <li><a href="#">Pyament Policy</a></li>
                            <li><a href="#">Shipping Policy</a></li>
                            <li><a href="#">Return Policy</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="row payment align-items-center">
                <div class="col-md-6">
                    <div class="payment-method">
                        <h2>We Accept:</h2>
                        <img src="img/payment-method.png" alt="Payment Method" />
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="payment-security">
                        <h2>Secured By:</h2>
                        <img src="img/godaddy.svg" alt="Payment Security" />
                        <img src="img/norton.svg" alt="Payment Security" />
                        <img src="img/ssl.svg" alt="Payment Security" />
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer End -->

    <!-- Footer Bottom Start -->
    <div class="footer-bottom">
        <div class="container">
            <div class="row">
                <div class="col-md-6 copyright">
                    <p>Copyright &copy; <a href="#">222JVNC</a>. All Rights Reserved</p>
                </div>

                <div class="col-md-6 template-by">
                    <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                    <p>Designed By <a href="https://htmlcodex.com">222JVNC</a></p>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer Bottom End -->

    <!-- Back to Top -->
    <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/slick/slick.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>