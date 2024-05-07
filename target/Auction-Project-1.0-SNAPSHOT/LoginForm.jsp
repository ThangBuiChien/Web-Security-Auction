<%-- 
    Document   : LoginForm
    Created on : Dec 3, 2023, 11:11:17 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
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
        <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form>
                  <div class="form-group">
                      <a href="AddProduct.jsp"></a>
                      <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">

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
                         <input type="hidden" name="action" value="createNewAccount">        
                         <button type="submit" class="btn btn-secondary">Register</button>
                    </form>
                </div>
            </div>
         </div>
      </div>
   </form>
 
        
         
</html>
