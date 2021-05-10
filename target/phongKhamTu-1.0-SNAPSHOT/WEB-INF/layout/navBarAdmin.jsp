<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/30/2021
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="<c:url value="/admin" />">
            <img src="<c:url value="/image/CanabisIcon.png" />" width="30" height="30" alt="">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/admin/"/>">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/admin/khamBenh"/>">Khám bệnh</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/admin/listDangKy"/>">Danh sách đăng ký</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/admin/ProductManager"/>">Quản lý thuốc</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/admin/"/>">Quản lý doanh thu</a>
                </li>
            </ul>
        </div>
        <div class="form-inline navbar-nav">
            <a class="nav-link nav-item" href="<c:url value="/logout"/>">Đăng xuất</a>
        </div>
    </nav>
