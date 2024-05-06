<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Free Bootstrap 4 Ecommerce Template</title>
    <!-- CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/a110f8f65c.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./style/SellerCss.css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

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

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <form class="form-inline my-2 my-lg-0">
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
        <h1 class="jumbotron-heading">TDD Auction Winning List</h1>
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
                            <th class="right">starting Bid Price</th>
                            <th class="right">Your winning Bid Price</th>
                            <th>&nbsp;</th>
                            <th> </th>
                        </tr>
                    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



                    <c:forEach var="item" items="${requestScope.products}">
                <tr>
                            <td><c:out value='${item.ID}'/></td>
                            <td><c:out value='${item.productName}'/></td>
                            <td><c:out value='${item.tag}'/></td>
                            <td><c:out value='${item.description}'/></td>
                            <td><c:out value='${item.startingBidPrice}'/></td>
                            <td><c:out value='${item.currentPrice}'/></td>



                            <td>
                                <form action="productServlet" method="post">
                                <input type="hidden" name="action" value="printInvoice">   
                                <input type="hidden" name="productID" 
                                       value="<c:out value='${item.ID}'/>">                                        
                                <input type="submit" value="Print Invoice">
                                </form>
                            </td>

                            

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        
            
        </div>
    </div>
</div>



<!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>
