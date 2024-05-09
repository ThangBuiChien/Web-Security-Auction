<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Base64" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.security.NoSuchAlgorithmException" %>

<%
    // Generate nonce
    byte[] nonceBytes = new byte[16];
    try {
        SecureRandom.getInstanceStrong().nextBytes(nonceBytes);
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
    String nonce = Base64.getEncoder().encodeToString(nonceBytes);

    // Define CSP with nonce and allowlist for CDNs
    String cspString = "default-src 'self'; " +
            "script-src 'self' 'nonce-" + nonce + "' https://code.jquery.com https://cdn.jsdelivr.net https://kit.fontawesome.com; " +
            "style-src 'self' 'nonce-" + nonce + "' https://cdn.jsdelivr.net https://fonts.googleapis.com https://cdnjs.cloudflare.com; " +
            "img-src 'self'; " +
            "frame-ancestors 'self'; " +
            "form-action 'self';";
    response.setHeader("Content-Security-Policy", cspString);
    response.setHeader("X-Frame-Options", "SAMEORIGIN");
%>

<style nonce="<%= nonce %>">
</style>

<script nonce="<%= nonce %>">
</script>
<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>TDD'Auction Page</title>
    <!-- CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" nonce="<%= nonce %>">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet" integrity="sha512-Qrn3Yr9Llumin/avw6tPFMVWzpcMHGZQXHX1cVUSKj8bpp/AwdruCs+/WmDNyHxqNQrHDsZjrdochXH/ONaKJ +++" crossorigin="anonymous" nonce="<%= nonce %>">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css" nonce="<%= nonce %>">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet" integrity="sha512-Qrn3Yr9Llumin/avw6tPFMVWzpcMHGZQXHX1cVUSKj8bpp/AwdruCs+/WmDNyHxqNQrHDsZjrdochXH/ONaKJ +++" crossorigin="anonymous" nonce="<%= nonce %>">

    <script src="https://kit.fontawesome.com/a110f8f65c.js" crossorigin="anonymous" nonce="<%= nonce %>"></script>
   <link rel="stylesheet" href="./style/SellerCss.css" nonce="<%= nonce %>">
    <link href="./style/main.css" rel="stylesheet" type="text/css" nonce="<%= nonce %>">
     <link rel="stylesheet" href="./style/Noti.css" nonce="<%= nonce %>">
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
                    <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">
                    <a class="nav-link" href="./cart?action=loadCart">Cart</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.jsp">Contact</a>
                </li>
            </ul>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1 class="jumbotron-heading">Contact us <br>
         <p><i>${message}</i></p> </h1>
        
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Contact</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col">
            <div class="card">
                <div class="card-header bg-primary text-white"><i class="fa fa-envelope"></i> Contact us.
                </div>
                <div class="card-body">
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email address</label>
                            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email" required>
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label for="message">Message</label>
                            <textarea class="form-control" id="message" rows="6" required></textarea>
                        </div>             
                        <div class="mx-auto">
                        <form action="userLogin" method="GET">
                            <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">
                            <input type="hidden" name="action" value="contact"> 
                            <button type="submit" class="btn btn-primary text-right">Send</button>
                        </form>
                            
                        </div>
                </div>
            </div>
        </div>
        <div class="col-12 col-sm-4">
            <div class="card bg-light mb-3">
                <div class="card-header bg-success text-white text-uppercase"><i class="fa fa-home"></i> TDD Company</div>
                <div class="card-body">
                    <p>Ho Chi Minh City University of Technology and Education</p>
                    <p>1, Vo Van Ngan stress</p>
                    <p>Thu Duc District</p>
                    <p>Email : tdd_company@gmail.com</p>
                    <p>Tel. +84 999999999999</p>
                </div>
            </div>
        </div>
    </div>
</div>
    <script src="js/script.js"></script>
</body>
</html>
