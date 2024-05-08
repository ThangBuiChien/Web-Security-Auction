<%--
  Created by IntelliJ IDEA.
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
</body>
</html>
