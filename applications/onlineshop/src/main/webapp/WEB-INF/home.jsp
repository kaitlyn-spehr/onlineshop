<%--
    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
  <meta charset="utf-8">
  <title>ONLINESHOP</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">


  <link href="../assets/css/bootstrap.css" rel="stylesheet">
  <link href="../assets/css/movie.css" rel="stylesheet">
  <style>
    body {
      padding-top: 60px;

    }
  </style>
  <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container">
      <a class="btn btn-navbar" data-toggle="collapse"
         data-target=".nav-collapse"> <span class="icon-bar"></span> <span
          class="icon-bar"></span> <span class="icon-bar"></span>
      </a> <a class="brand" href="/">Home</a>
                       <a class="brand" href="/cart">View Cart</a>

    </div>
  </div>
</div>

<div class="jumbotron">
  <h1 class="display-4">Online Shop</h1>
  <p class="lead">Welcome to the admin portal for Online Shop.</p>
  <hr class="my-4">
  <p>View customers, products, and transactions. Add, delete, and re-order products.</p>
</div>

<div class="container">

  <p>Please select one of the following links:</p>
  <a href="appusers">AppUsers</a> <br/>
  <a href="products">Products</a> <br/>
  <a href="transactions">Transactions</a> <br/>

</div>

</body>
</html>