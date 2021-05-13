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
    Object a  =  request.getAttribute("dangKy");
%>
<link href="<c:url value="/css/dangKyDetail.css"/>" rel="stylesheet" />
<h1 style=" text-align: center; padding: 3% 0px">Chi tiết khám bệnh</h1>

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
            <span class="text">${dangKy.ngayKham.date}/${dangKy.ngayKham.month+1}/${dangKy.ngayKham.year+1900}</span>
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
    <form:form action="/phongKhamTu_war/admin/dangKy/detail/approve" method="post">
        <div class="form-row form-group">
            <div class="col">
                <label class="title" for="chonGio">Chọn giờ</label>
                <input class="form-control" type="time" id="chonGio" name="chonGio"/>
            </div>
        </div>
        <div class="float-right">
            <input value="Xác nhận" type="submit" class="btn btn-primary"/>
            <a href="<c:url value="/admin/listDangKy"/>" class="btn btn-primary">Trở về</a>
            <a href="<c:url value="/admin/dangky/detail/cancel"/>" class="btn btn-danger">Hủy</a>
        </div>
    </form:form>
</div>

