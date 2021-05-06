<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/1/2021
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link href="<c:url value="/css/dangKyLichKham.css"/>" rel="stylesheet" />
<div style="height: 100px;padding-top: 2%" class="container">
    <h1 style=" text-align: center" class="text-center">Kết quả khám bệnh</h1>
    <form class="main-form">
        <div class="form-row form-group">
            <div class="col">
                <input type="text" id="fname" class="form-control"  name="fname" placeholder="Nhập mã khám bệnh">
            </div>
        </div>
        <div>
            <button type="button" class="btn btn-primary">Xác nhận</button>
        </div>
    </form>
</div>
