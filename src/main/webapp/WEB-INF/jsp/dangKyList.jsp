<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/9/2021
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    request.setCharacterEncoding("UTF-8");
%>

<h2 style="text-align: center; padding: 3% 0px">Danh sách đăng ký khám bệnh</h2>

<c:forEach var="dangKy" items="${dangKys}" varStatus="1">
    <a href="<c:url value="/admin/dangky/detail/${dangKy.dangKyId}"/>" class="card-body alert alert-primary d-flex bd-highlight mb-3" role="alert">
        <h5 class="card-title">${dangKy.ho.toString()}</h5>
        <h5 class="card-title">${dangKy.ten.toString()}</h5>
        <h6>
            <c:choose>
                <c:when test="${dangKy.buoiKham == 0}">
                    Buổi sáng
                </c:when>
                <c:when test="${dangKy.buoiKham == 1}">
                    Buổi chiều
                </c:when>
            </c:choose>
        </h6>
    </a>

</c:forEach>
