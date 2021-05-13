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
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%
    request.setCharacterEncoding("UTF-8");
%>

<link href="<c:url value="/css/dangKyLichKham.css"/>" rel="stylesheet" />
<div style="height: 100px;padding-top: 2%" class="container">
    <h1 style=" text-align: center" class="text-center">Kết quả khám bệnh</h1>
    <form:form action="/phongKhamTu_war/ketQuaKhamBenh/result" class="main-form">
        <div class="form-row form-group">
            <div class="col">
                <input type="text" id="maBenh" class="form-control"  name="maBenh" placeholder="Nhập mã khám bệnh">
            </div>
        </div>
        <div>
            <input type="submit" class="btn btn-primary" value="Xác nhận" />
        </div>
    </form:form>
</div>
