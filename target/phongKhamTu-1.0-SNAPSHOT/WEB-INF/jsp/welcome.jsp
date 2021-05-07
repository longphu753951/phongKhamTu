<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/29/2021
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Phòng khám tư nhân - Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script th:src="@{/js/home.js}"></script>
    <link href="<c:url value="/css/home.css"/>" rel="stylesheet" />
    <link rel="icon" href="https://image.flaticon.com/icons/png/512/120/120082.png">
</head>
<body>
    <div class="header justify-content-center" >
        <img src="<c:url value="/image/blue-gradient-background.png" />" style="width: 100%; height: 350px">
        <div style="position: absolute;top:20%;left: 32%" >
            <img src="<c:url value="/image/CanabisIcon.png" />"  class="logo" >
            <h1 style=" color: #ffffff; text-align: center">Welcome to Phòng Khám Nụ Cười</h1>
        </div>
    </div>
    <div style="width: 100%; margin-top: 5%; margin-bottom: 5%" class="container">

        <div class="row d-flex justify-content-center" >
            <a href="<c:url value="/dangKyLichKham" />"  class="card" style="width: 30%;">
                <img src="<c:url value="/image/register_icon.png" />" class="card-img card-img-top" >
                <div class="card-body">
                    <h5 style="text-align: center" class="card-title">Đăng ký lịch khám</h5>
                </div>
            </a>

            <a href="<c:url value="/ketQuaKhamBenh"/>" class="card" style="width: 30%;">
                <img src="<c:url value="/image/search_icon.png" />"  class="card-img card-img-top">
                <div class="card-body">
                    <h5 style="text-align: center" class="card-title">Tra cứu lịch sử khám</h5>
                </div>
            </a>
            <a class="card" style="width: 30%;">
                <img src="<c:url value="/image/about-us-icon.png" />"  class="card-img card-img-top">
                <div class="card-body">
                    <h5 style="text-align: center" class="card-title">About us</h5>
                </div>
            </a>
        </div>
    </div>
</body>

</html>
