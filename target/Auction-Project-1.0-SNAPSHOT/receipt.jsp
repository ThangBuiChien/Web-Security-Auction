<%-- 
    Document   : simpleReceipt
    Created on : Dec 4, 2023, 10:05:04 PM
    Author     : ThangDz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="style/main.css" type="text/css"/>
    <title>Invoice</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
            padding: 20px;
        }

        h1 {
            color: #333;
        }

        p {
            margin-bottom: 10px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }
        .btn {
                background-color: Black; /* Blue background */
                border: none; /* Remove borders */
                color: white; /* White text */
                padding: 12px 16px; /* Some padding */
                font-size: 16px; /* Set a font size */
                cursor: pointer; /* Mouse pointer on hover */
              }

              /* Darker background on mouse-over */
              .btn:hover {
                background-color: #04AA6D;
              }

    </style>
</head>
    
<body>
    
    <button class="btn"onclick="window.location.href = 'index.jsp'"><i class="fa fa-home"></i></button>

    <h1>Thank you for using our services</h1>
    
    <p>This is your invoice</p>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <section>
        <h2>Your Information:</h2>
        <p>Your Name: ${receipt.getBuyer().firstName} ${receipt.getBuyer().lastName}</p>
        <p>Your Address: ${receipt.getBuyer().address}</p>
        <p>Your Email: ${receipt.getBuyer().email}</p>
    </section>

    <section>
        <h2>Details of Winning Product:</h2>
        <table>
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Seller Name</th>
                    <th>Starting Bid Price</th>
                    <th>Your Winning Price</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${receipt.getProduct().productName}</td>
                    <td>${receipt.getProduct().description}</td>
                    <td>${receipt.getProduct().getSeller().firstName} ${receipt.getProduct().getSeller().lastName}</td>
                    <td>${receipt.getProduct().startingBidPrice}</td>
                    <td>${receipt.getProduct().currentPrice}</td>
                </tr>
            </tbody>
        </table>
    </section>
</body>
</html>