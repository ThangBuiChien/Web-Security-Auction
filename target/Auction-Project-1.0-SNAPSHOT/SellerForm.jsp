<%-- 
    Document   : SellerForm
    Created on : Dec 4, 2023, 10:30:02 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>TDD'Auction Page</title>
    <!-- CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
   <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/a110f8f65c.js" crossorigin="anonymous"></script>
    <link href="./style/main.css" rel="stylesheet" type="text/css">
    <link href="./style/SellerCss.css" rel="stylesheet" type="text/css">
     <link rel="stylesheet" href="./style/Noti.css">
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
        <h1 class="jumbotron-heading">YOUR INFOMATION</h1>
    </div>
</section>
 <section>
    
<p>Here is the information that you entered:</p>
    <label  class="right">Email: </label>
    <span>${seller.email}</span><br>
    <label class="right">First Name: </label>
    <span>${seller.firstName}</span><br>
    <label class="right">Last Name: </label>
    <span>${seller.lastName}</span><br>
    <label class="right" >Company Name: </label>
    <span>${seller.companyName}</span><br>
    <label class="right" >Phone: </label>
    <span>${seller.phoneNumber}</span><br>
    

    <form action="userLogin" method="post">
        <input type="hidden" name="action" value="Change">        
        
        <input type="submit" value="Change Info" class="margin_left">
    </form>
    
    <form action="productServlet" method="post">
        <input type="hidden" name="action" value="Addproduct">        
        
        <input type="submit" value="Add product" class="margin_left">
    </form>
    <form action="productServlet" method="post">
        <input type="hidden" name="action" value="loadProductByUser">        
        
        <input type="submit" value="Winning Product" class="margin_left">
    </form>
</section>
    
    <script src="js/script.js"></script>

</body>
</html>
