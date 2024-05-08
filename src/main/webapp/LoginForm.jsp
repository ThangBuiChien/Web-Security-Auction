<%-- 
    Document   : LoginForm
    Created on : Dec 3, 2023, 11:11:17 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVFQWjT+8BvBv5YhYlIjqp7LWfk7z1HroHfrjDxrAhQgONBq3iE" crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

 <link rel="stylesheet" href="./style/logincss.css" />
<!------ Include the above in your HEAD tag ---------->

    <div class="sidenav">
        <div class="login-main-text">
           <h2>Auction'TĐĐ<br> Login Page 2</h2>
           <p>Login from here to access.</p>
            <p><i>${message}</i></p>
        </div>
    </div>
    <form action="userLogin" method="post">
        <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">
        <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form>
                   <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">
                  <div class="form-group">
                      <a href="AddProduct.jsp"></a>


                      <label>User Name</label>
                      <input type="hidden" name="action" value="login">
                     <input type="text" class="form-control" name="email" placeholder="User Name">
                  </div> 
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" name="password" placeholder="Password">
                  </div>
                  <button type="submit" value="Login" class="btn btn-black">Login</button>   
               </form>
                <div class="form-group">
                   <form action="userLogin" method="post">
                       <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">
                         <input type="hidden" name="action" value="createNewAccount">        
                         <button type="submit" class="btn btn-secondary">Register</button>
                    </form>
                </div>
            </div>
         </div>
      </div>
   </form>
 
        
         
</html>
