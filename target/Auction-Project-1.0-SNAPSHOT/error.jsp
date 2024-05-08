<%--
  Created by IntelliJ IDEA.
<<<<<<< HEAD
  User: ASUS
  Date: 5/8/2024
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Error Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
    }
    .container {
      width: 80%;
      margin: 50px auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
    h1 {
      color: #d9534f;
    }
    p {
      color: #333;
      line-height: 1.6;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>DENIED</h1>
  <p>An error occurred while processing your request URL.</p>
  <%-- Display error details if available --%>
  <% if (request.getAttribute("javax.servlet.error.exception") != null) { %>
  <p><strong>Error Details:</strong></p>
  <pre><%= request.getAttribute("javax.servlet.error.exception") %></pre>
  <% } %>
  <p></p>
  <p>Please try again later or contact support.</p>
  <p>Make sure that the URL is correct.</p>
</div>
=======
  User: ADMIN
  Date: 5/8/2024
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Error page</h1>
    <p>There is an error while using the website</p>
    <p>Please return back to the main page</p>
>>>>>>> origin/main
</body>
</html>
