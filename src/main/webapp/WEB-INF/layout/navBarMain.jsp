<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/6/2021
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="<c:url value="/admin/" />">
            <img src="<c:url value="/image/CanabisIcon.png" />" width="30" height="30" alt="">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/"/>">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/dangKyLichKham"/>">Đăng ký lịch khám</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/ketQuaKhamBenh"/>">Lịch sử khám</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About us</a>
                </li>
            </ul>
        </div>
    </nav>
