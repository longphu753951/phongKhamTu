<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/7/2021
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<link href="<c:url value="/css/dangKyLichKham.css"/>" rel="stylesheet" />
<div style="height: 100px;padding-top: 2%" class="container">
    <h1 style=" text-align: center" class="text-center">Thêm loại thuốc</h1>
    <form:form action="add/save" method="post" modelAttribute="category" class="main-form">
        <div class="form-row form-group">
            <div class="col">
                <label for="lthuoc">Tên loại thuốc</label>
                <form:input path="name" type="text" id="lthuoc" class="form-control"  name="lthuoc" placeholder="Nhập tên loại thuốc"/>
            </div>
        </div>
        <div class="form-group">
            <label for="description">Mô tả</label>
            <form:textarea path="description"  style="resize: none;" class="form-control" id="description" rows="3"/>
        </div>
        <div>
            <input value="Xác nhận" type="submit" class="btn btn-primary"/>
            <a href="<c:url value="/admin/caterogy"/>" class="btn btn btn-danger">Hủy</a>
        </div>
    </form:form>
</div>