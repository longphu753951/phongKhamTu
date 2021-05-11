<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/10/2021
  Time: 11:22 PM
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

<h2 style="text-align: center; padding: 3% 0px">Danh sách chờ khám bệnh</h2>

<c:forEach var="khamBenh" items="${khamBenhs}" varStatus="1">
    <a style="margin-bottom: 2%" href="<c:url value="/admin/khamBenh/detail/${khamBenh.khamBenh_Id}"/>" class="list-group-item list-group-item-action flex-column align-items-start active">
        <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">${khamBenh.ho.toString()} ${khamBenh.ten.toString()}</h5>
            <small>
                    ${khamBenh.ngayKham.date}/${khamBenh.ngayKham.month+1}/${khamBenh.ngayKham.year+1900}
            </small>
        </div>
        <p class="mb-1">Giờ khám: ${khamBenh.gioKham.toString()}</p>
        <small>Bấm để xem thêm chi tiết</small>
    </a>
</c:forEach>
