<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/13/2021
  Time: 5:19 PM
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
<link href="<c:url value="/css/ketQuaDetail.css"/>" rel="stylesheet" />
<h1 style=" text-align: center; padding: 3% 0px" class="text-center">Kết quả khám bệnh</h1>


<ul style="list-style-type:none">
    <li>
        <div class="form-group">
            <div class="row">
                <div class="col">
                    <span class="title">Họ: </span>
                    <span class="text">${kb.ho}</span>
                </div>
                <div class="col">
                    <span class="title">Tên: </span>
                    <span class="text">${kb.ten}</span>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <span class="title">Ngày khám: </span>
                    <span class="text">${kb.ngayKham.date}/${kb.ngayKham.month+1}/${kb.ngayKham.year+1900}</span>
                </div>
                <div class="col">
                    <span class="title">Giờ khám: </span>
                    <span class="text">${kb.gioKham}</span>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="title">
                        Nguyên nhân:
                    </p>
                    <p class="text">
                        ${kb.nguyenNhan}
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="title">
                        Lời khuyên:
                    </p>
                    <p class="text">
                        ${kb.loiKhuyen}
                    </p>
                </div>
            </div>
        </div>
    </li>
    <li style="margin-bottom: 2%">
        <p class="title">Danh sách thuốc</p>
    </li>
    <c:forEach var="thuoc" items="${kbm}">
        <div class="item">
            <div class="image image-wrapper">
                <img style="width: 100%;" src="<c:url value="${thuoc.medicine.pic}"/>"/>
            </div>
            <div class="item_detail_text">
                <div class="item_detail_info">
                    <h6>${thuoc.medicine.fullname}</h6>
                    <p>Giá cả: ${thuoc.price} VND</p>
                </div>
            </div>
            <div class="sub_total">
                <p class="sub_total_text">${thuoc.quantity}</p>
            </div>
            <div class="sub_total">
                <p class="sub_total_text">${thuoc.totalPrice} VND</p>
            </div>
        </div>
    </c:forEach>
    <li>
        <div class="row">
            <div class="col d-flex justify-content-start sub_total_text" >
                Tiền khám
            </div>
            <div class="col d-flex justify-content-end" style="font-size: 18px;">
                ${kb.tienKham} VND
            </div>
        </div>
        <div class="row">
            <div class="col d-flex justify-content-start sub_total_text">
                Tổng tiền
            </div>
            <div class="col d-flex justify-content-end" style="font-size: 18px;">
                ${kb.tongTien} VND
            </div>
        </div>
    </li>
</ul>