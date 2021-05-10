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
<div class="list-group">
    <c:forEach var="dangKy" items="${dangKys}" varStatus="1">
        <a style="margin-bottom: 2%" href="<c:url value="/admin/dangky/detail/${dangKy.dangKyId}"/>" class="list-group-item list-group-item-action flex-column align-items-start active">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">${dangKy.ho.toString()} ${dangKy.ten.toString()}</h5>
                <small>
                    <c:choose>
                        <c:when test="${dangKy.buoiKham == 0}">
                            Buổi sáng
                        </c:when>
                        <c:when test="${dangKy.buoiKham == 1}">
                            Buổi chiều
                        </c:when>
                    </c:choose>
                </small>
            </div>
            <p class="mb-1">Ngày khám: ${dangKy.ngayKham.date}/${dangKy.ngayKham.month+1}/${dangKy.ngayKham.year+1900}</p>
            <small>Bấm để xem thêm chi tiết</small>
        </a>

    </c:forEach>

</div>

