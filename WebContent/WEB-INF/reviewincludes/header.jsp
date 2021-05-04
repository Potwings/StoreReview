<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>${store.name}</title>

  <!-- Bootstrap core CSS -->
   <link href="/storelist/vendor/fontawesome-free//css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
  <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/css/shop-item.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/store/list">GoGilDong Store</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
        <c:if test="${mid != null }">
          <li class="nav-item">
            <a class="nav-link" href="#">WELCOME : ${mid }</a>
          </li>
          </c:if>
          
	

          <li class="nav-item">
          <c:choose>
          <c:when test="${mid == null }">
            <a class="nav-link" href="/member/login">Login</a>
            </c:when>
            <c:when test="${mid != null }">
            <a class="nav-link" href="/member/logout">LogOut</a>
            </c:when>
          </c:choose>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Account</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
