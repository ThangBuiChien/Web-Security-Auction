<%-- 
    Document   : RegisteringForm
    Created on : Dec 3, 2023, 11:34:58 PM
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
           <h2>Auction'TĐĐ<br> Register Page</h2>
           <p>Register from here to access.</p>
            <p><i>${message}</i></p>
        </div>
    </div>
    <form action="userLogin" method="post">
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form>
                  <div class="form-group">
                     <label>User Name</label>
                     <input type="hidden" name="action" value="register">  
                     <input type="text" class="form-control" name="email" value=${user.email} >
                  </div> 
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" name="password" value=${user.Password} >
                  </div>
                  <button type="submit" value="Join Now" class="btn btn-black">Join Now</button>   
               </form>
  
            </div>
         </div>
      </div>
   </form>
 
        
         
</html>

