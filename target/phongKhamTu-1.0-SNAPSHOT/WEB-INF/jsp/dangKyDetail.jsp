<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/10/2021
  Time: 1:23 AM
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
<link href="<c:url value="/css/dangKyDetail.css"/>" rel="stylesheet" />
<h1 style=" text-align: center; padding: 3% 0px">Chi tiết khám bệnh</h1>
<form:form action="saveDangKy" method="post" modelAttribute="dangKy" class="main-form">
<div class="form-group">
        <div class="row">
            <div class="col">
               <span class="title">Họ: </span>
                <span class="text">${dangKy.ho}</span>
            </div>
            <div class="col">
                <span class="title">Tên: </span>
                <span class="text">${dangKy.ten}</span>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <span class="title">Email: </span>
                <span class="text">${dangKy.email}</span>
            </div>
            <div class="col">
                <span class="title">Số điện thoại: </span>
                <span class="text">${dangKy.sdt}</span>
            </div>
        </div>
    <div class="row">
        <div class="col">
            <span class="title">Ngày khám: </span>
            <span class="text">${dangKy.ngayKham.day}/${dangKy.ngayKham.month}/${dangKy.ngayKham.year+1900}</span>
        </div>
        <div class="col">
            <span class="title">Buổi khám: </span>
            <span class="text">
                <c:choose>
                    <c:when test="${dangKy.buoiKham == 0}">
                        Buổi sáng
                    </c:when>
                    <c:when test="${dangKy.buoiKham == 1}">
                        Buổi chiều
                    </c:when>
                </c:choose>
            </span>
        </div>
    </div>
    <div class="row">
        <div class="col">
        <p class="title">
            Triệu chứng:
        </p>
        <p class="text">
            ${dangKy.trieuChung}
        </p>
        </div>
    </div>
    <div class="form-row form-group">
        <div class="col">
            <label class="title" for="chonGio">Chọn giờ</label>
            <input class="form-control" type="time" id="chonGio" name="chonGio"/>
        </div>
    </div>
    <div class="float-right">
        <a href="<c:url value="#"/>" class="btn btn-primary">Xác nhận</a>
        <a href="<c:url value="/#"/>" class="btn btn-danger">Hủy</a>
    </div>
</div>
</form:form>
