<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Cart</title>
    <!-- CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet" integrity="sha512-Qrn3Yr9Llumin/avw6tPFMVWzpcMHGZQXHX1cVUSKj8bpp/AwdruCs+/WmDNyHxqNQrHDsZjrdochXH/ONaKJ +++" crossorigin="anonymous">

    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/a110f8f65c.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./style/SellerCss.css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
     <link rel="stylesheet" href="./style/Noti.css">
</head>
<body>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">TDD'Auction</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./productServlet?action=loadProduct" >Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./cart?action=loadCart">Cart</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.jsp">Contact</a>
                </li>
            </ul>

<form class="form-inline my-2 my-lg-0">
    <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">
                <div class="input-group input-group-sm">
                    <input type="text" class="form-control" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="button" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                 <a class="btn btn-success btn-sm ml-3"  href="SellerForm.jsp">
                <i class="fa-solid fa-user">${seller.firstName}</i>
                
              </a>
              <a class="btn btn-success btn-sm ml-3"  href="./userLogin?action=logOut" >
                <i class="fa-solid fa-arrow-right-from-bracket"></i>
             
              </a>
              </form>

                <form action="userLogin" method="loadNofi">
                    <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">
                   <input type="hidden" name="action" value="loadNofi"> 
                   <div class="btn btn-success btn-sm ml-3" onclick="toggleNotifi()">
                            <i class="fa-solid fa-bell"></i>
                   </div>
                   </form>
               
                <div class="notifi-box" id="box">
                 <c:forEach var="item" items="${requestScope.nofi}">
                    <h2>Notifications <span></span>${item.size()}</h2>
                    <div class="notifi-item">
                        <div class="text">
                           <p>${item.message}</p>
                        </div> 
                    </div>

                 </c:forEach>
                </div>
        </div>
    </div>

</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">TDD Auction Cart</h1>
     </div>
</section>

<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>product ID </th>
                            <th>product Name </th>
                            <th>tag</th>
                            <th>description</th>
                            <th>product Status </th>
                            <th class="right">starting Bid Price</th>
                            <th class="right">current Price</th>
                            <th class="right">buy Now Price</th>
                            <th>&nbsp;</th>
                            <th> </th>
                        </tr>
                    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



                    <c:forEach var="item" items="${cart.listcart}">
                        <tr>
                            <td>
                                <c:out value='${item.ID}' />
                            </td>
                            <td>
                                <c:out value='${item.productName}' />
                            </td>
                            <td>
                                <c:out value='${item.tag}' />
                            </td>
                            <td>
                                <c:out value='${item.description}' />
                            </td>
                            <td>
                                <c:out value='${item.productStatus}' />
                            </td>

                            <td class="right">
                                <c:out value='${item.startingBidPrice}' />
                            </td>
                            <td class="right">
                                <c:out value='${item.currentPrice}' />
                            </td>
                            <td class="right">
                                <c:out value='${item.buyNowPrice}' />
                            </td>



                            <td>
                                <form action="productServlet" method="post">
                                    <input type="hidden" name="action" value="setBidPrice">

                                    <input type="hidden" name="productID" value="<c:out value='${item.ID}'/>">
                                    <input type=text name="newBidPrice" placeholder="Enter your bid here"
                                        value="<c:out value='${item.currentPrice}'/>" id="newBidPrice">
                                    <input type="submit" value="Enter new bid Price">
                                </form>
                            </td>

                            <td>
                                <form action="cart" method="post">
                                    <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">
                                    <input type="hidden" name="action" value="deletecart">
                                    <input type="hidden" name="productCode" value="<c:out value='${item.ID}'/>">
                                     <button type="submit" name="action" style="background: none; border: none; padding: 0; cursor: pointer;">
                                        <img src="image/trash.jpg" alt="Trash Can Icon" width="20" height="20">
                                    </button>
                                    
                                </form>
                            </td>

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
<%--        <div class="col mb-2">--%>
<%--            <div class="row">--%>
<%--                --%>
<%--                <div class="col-sm-12 col-md-6 text-right">--%>
<%--                    <form action="cart" method="post">--%>
<%--                        <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">--%>
<%--                    <input type="hidden" name="action" value="shop">--%>
<%--                    <button class="btn btn-lg btn-block btn-success text-uppercase">Continue Shopping</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>
</div>



<!-- JS -->
<script src="//code.jquery.com/jquery-3.6.4.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/script.js"></script>
</body>
</html>
