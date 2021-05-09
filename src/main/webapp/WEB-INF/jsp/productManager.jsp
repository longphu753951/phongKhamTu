<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/7/2021
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="<c:url value="/css/home.css"/>" rel="stylesheet" />

<div>
    <h2 style="text-align: center; padding: 5% 0px">Quản lý sản phẩm</h2>
    <div style="padding-bottom: 3%;" class="row d-flex justify-content-center" >
        <a href="<c:url value="/admin/Medicine"/>" class="card" style="width: 30%;">
            <img src="<c:url value="/image/drug_icon.png" />"  class="card-img card-img-top">
            <div class="card-body">
                <h5 style="text-align: center" class="card-title">Quản lý thuốc</h5>
            </div>
        </a>
        <a href="<c:url value="/admin/caterogy"/>" class="card" class="card" style="width: 30%;">
            <img src="<c:url value="/image/category_icon.png" />"  class="card-img card-img-top">
            <div class="card-body">
                <h5 style="text-align: center" class="card-title">Quản lý loại thuốc</h5>
            </div>
        </a>
    </div>
</div>
