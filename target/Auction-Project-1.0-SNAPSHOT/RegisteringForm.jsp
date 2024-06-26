<%-- 
    Document   : RegisteringForm
    Created on : Dec 3, 2023, 11:34:58 PM
    Author     : Administrator
--%>

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
            "script-src 'self' 'nonce-" + nonce + "' https://code.jquery.com https://cdn.jsdelivr.net; " +
            "style-src 'self' 'nonce-" + nonce + "' https://cdn.jsdelivr.net; " +
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
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" nonce="<%= nonce %>">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVFQWjT+8BvBv5YhYlIjqp7LWfk7z1HroHfrjDxrAhQgONBq3iE" crossorigin="anonymous" nonce="<%= nonce %>"></script>

    <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous" nonce="<%= nonce %>"></script>

    <link rel="stylesheet" href="./style/logincss.css" nonce="<%= nonce %>"/>
</head>
<!------ Include the above in your HEAD tag ---------->

    <div class="sidenav">
        <div class="login-main-text">
           <h2>Auction'TĐĐ<br> Register Page</h2>
           <p>Register from here to access.</p>
            <p><i>${message}</i></p>
        </div>
    </div>
<%--    <form action="userLogin" method="post">--%>
<%--        <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">--%>
<%--      <div class="main">--%>
<%--         <div class="col-md-6 col-sm-12">--%>
<%--            <div class="login-form">--%>
<%--               <form>--%>
<%--                   <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">--%>
<%--                  <div class="form-group">--%>
<%--                     <label>User Name</label>--%>
<%--                     <input type="hidden" name="action" value="register">--%>
<%--                     <input type="text" class="form-control" name="email" value=${user.email} >--%>
<%--                  </div>--%>
<%--                  <div class="form-group">--%>
<%--                     <label>Password</label>--%>
<%--                     <input type="password" class="form-control" name="password" value=${user.Password} >--%>
<%--                  </div>--%>
<%--                  <button type="submit" value="Join Now" class="btn btn-black">Join Now</button>--%>
<%--               </form>--%>

<%--            </div>--%>
<%--         </div>--%>
<%--      </div>--%>
<%--   </form>--%>

    <form action="userLogin" method="post">
        <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">
        <div class="main">
            <div class="col-md-6 col-sm-12">
                <div class="login-form">
                    <div class="form-group">
                        <label>User Name</label>
                        <input type="hidden" name="action" value="register">
                        <input type="text" class="form-control" name="email" value="${user.email}">
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control" name="password" value="${user.password}">
                    </div>
                    <button type="submit" class="btn btn-black">Join Now</button>
                </div>
            </div>
        </div>
    </form>


</html>

