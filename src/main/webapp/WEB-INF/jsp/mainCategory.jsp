<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/30/2021
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h2 style="text-align: center; padding: 3% 0px">Quản lý sản phẩm</h2>
<div style="padding-bottom: 2%" class="btn-group" role="group" aria-label="Basic example">
    <a href="<c:url value="/admin/category/add"/>" class="btn btn-primary">Thêm loại sản phẩm</a>
</div>
<c:forEach var="category" items="${categories}" varStatus="1">
    <div class="alert alert-primary d-flex bd-highlight mb-3" role="alert">
        <div class="mr-auto p-2 bd-highlight">${category.name}</div>
        <div class="p-2 bd-highlight">
            <a href="<c:url value="/admin/category/edit/${category.categoryId}"/>" class="btn btn-warning">Sửa</a>
            <a href="<c:url value="/admin/category/delete/${category.categoryId}"/>" class="btn btn-danger">Xóa</a>
        </div>
    </div>

</c:forEach>
