<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/11/2021
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<h1 style=" text-align: center; padding: 5% 0px" class="text-center">Khám bệnh</h1>

<link href="<c:url value="/css/dangKyDetail.css"/>" rel="stylesheet" />
<div class="form-group">
    <div class="row">
        <div class="col">
            <span class="title">Họ: </span>
            <span class="text">${khamBenhCt.ho}</span>
        </div>
        <div class="col">
            <span class="title">Tên: </span>
            <span class="text">${khamBenhCt.ten}</span>
        </div>
    </div>
    <form:form action="/phongKhamTu_war/admin/khamBenh/detail/redirect" method="post">
        <%
            request.setCharacterEncoding("UTF-8");
        %>
        <div class="form-row form-group">
            <div class="col">
                <label class="title" for="nguyenNhan">Nguyên nhân</label>
                <textarea name="nguyenNhan" style="resize: none;" class="form-control" id="nguyenNhan" rows="3"></textarea>
            </div>
        </div>
        <div class="form-row form-group">
            <div class="col">
                <label class="title" for="loiKhuyen">Lời khuyên</label>
                <textarea name="loiKhuyen" style="resize: none;" class="form-control" id="loiKhuyen" rows="3"></textarea>
            </div>
        </div>
        <div class="form-row form-group">
            <div class="col">
                <label for="money">Tiền khám dịch vụ</label>
                <input  step="10000" type="number" min="10000" id="money" class="form-control"  name="money" />
            </div>
        </div>
        <div class="float-right">
            <input value="Xác nhận" type="submit" class="btn btn-primary"/>
            <a href="<c:url value="/admin/listDangKy"/>" class="btn btn-primary">Trở về</a>
        </div>
    </form:form>
</div>
