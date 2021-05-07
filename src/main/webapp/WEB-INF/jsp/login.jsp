<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/4/2021
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="icon" href="https://image.flaticon.com/icons/png/512/120/120082.png">
</head>
<body style="background-color: #5286F3 ">

    <div class="container">
        <spring:url value="/login" var="action" />
        <form  style="background-color:white; border-radius: 20px;width: 40%; left: 30%; top: 20%;padding:2%;position: absolute" action="${action}" method="post" >
            <h3>Đăng nhập</h3>
            <div class="form-group">
                <input name="username" id="usernameId"
                       class="form-control" placeholder="Nhập tài khoản" />
            </div>
            <div class="form-group">
                <label for="passwordId">

                </label>
                <input id="passwordId" name="password"
                       class="form-control" type="password" placeholder="Nhập mật khẩu" />
            </div>
            <div class="form-group">
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="Đăng nhập"  />
            </div>
        </form>
    </div>
</body>
</html>
