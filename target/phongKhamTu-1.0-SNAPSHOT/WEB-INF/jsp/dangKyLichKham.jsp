<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/30/2021
  Time: 11:13 PM
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
        <h1 style=" text-align: center" class="text-center">Đăng ký lịch khám</h1>
        <form:form action="saveDangKy" method="post" modelAttribute="dangKy" class="main-form">

            <div class="form-row form-group">
                <div class="col">
                    <label for="fname">Tên</label>
                    <form:input path="ten" type="text" id="fname" class="form-control"  name="fname" placeholder="Nhập tên"/>
                </div>
                <div class="col">
                    <label for="lname">Họ</label>
                    <form:input path="ho"  type="text" id="lname" class="form-control" name="lname" placeholder="Nhập họ"/>
                </div>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input  type="email" id="email" class="form-control" name="email" placeholder="Nhập email">
            </div>
            <div class="form-group">
                <label for="telephone">Số điện thoại</label>
                <form:input path="sdt"  type="tel" id="telephone" class="form-control" name="telephone" placeholder="Nhập số điện thoại"/>
            </div>
            <div class="form-group">
                <label for="chonNgay">Chọn ngày khám</label>
                <fmt:formatDate value="${dangKy.ngayKham}" var="dateString" pattern="dd/MM/yyyy" />
                <form:input path="ngayKham" class="form-control" type="date" id="chonNgay" name="chonNgay"/>
            </div>
            <div class="form-group">
                <label for="chonBuoi">Chọn buổi khám bệnh</label>
                <form:select path="buoiKham" name="chonBuoi" class="form-control" id="chonBuoi">
                    <option value="0">Buổi sáng</option>
                    <option value="1">Buổi chiều</option>
                </form:select>
            </div>
            <div class="form-group">
                <label for="trieuChung">Triệu chứng</label>
                <form:textarea path="trieuChung"  style="resize: none;" class="form-control" id="trieuChung" rows="3"/>
            </div>
            <div>
                <input value="Đăng ký" type="submit" class="btn btn-primary"/>
            </div>
        </form:form>
    </div>

