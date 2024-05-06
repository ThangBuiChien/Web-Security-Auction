<%-- 
    Document   : AddInfoUserForm
    Created on : Dec 4, 2023, 9:01:59 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Add product</title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="style/addproduct.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Add Product Form</h2>
                    
                </div>
                <div class="card-body">
                    <form action="productServlet" method="post">
                        <input type="hidden" name="action" value="addProduct">
                        <div class="form-row">
                            <div class="name">Product Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="productName" value=${product.productName}>
                                </div>
                            </div>
                        </div>
                        <div class="form-row m-b-55">
                            <div class="name">Information</div>
                            <div class="value">
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="tag" value=${product.tag}>
                                            <label class="label--desc">Tag</label>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="startingBidPrice" value=${product.startingBidPrice}>
                                            <label class="label--desc">Starting Price</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Description</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="description" value=${product.description}>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Buy Now Price</div>
                                <div class="value">
                                    <div class="col-9">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="buyNowPrice" value=${product.buyNowPrice}> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                            <div class="name">End time:</div>
                                <div class="value">
                                    <div class="col-9">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="datetime-local" name="endDatetime" value=${product.endDateTime}> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                              <div class="form-row">
                              <p><i style="color: red;">${message}</i></p>
                            </div>          
                        </div>
                        <div>
                           
                            <button class="btn btn--radius-2 btn--red" type="submit" value="Add!" >ADD!</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


</body>

</html>
<!-- end document-->


