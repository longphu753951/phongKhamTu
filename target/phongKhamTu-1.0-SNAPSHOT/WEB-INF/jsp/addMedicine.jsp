<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/7/2021
  Time: 11:49 PM
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
<h1 style=" text-align: center; padding: 5% 0px" class="text-center">Thêm thuốc</h1>
<form:form action="add/save" method="post" modelAttribute="medicine" enctype="multipart/form-data"  class="main-form">

    <div class="form-row form-group">
        <div class="col">
            <label for="lthuoc">Tên  thuốc</label>
            <form:input path="fullname" type="text" id="lthuoc" class="form-control"  name="lthuoc" placeholder="Nhập tên loại thuốc"/>
        </div>
    </div>

    <div class="form-row form-group">
        <div class="col">
            <label for="money">Giá tiền</label>
            <form:input path="price" step="10000" type="number" id="money" class="form-control"  name="money" />
        </div>
    </div>

    <div class="form-row form-group">
        <div class="col">
            <label for="chonLoai">Chọn loại</label>
            <select name="chonLoai" class="form-control" id="chonLoai">
                <c:forEach var="category" items="${categories}" varStatus="1">
                    <option value=${category.categoryId}>${category.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>



    <div class="form-row form-group">
        <div class="col">
            <label for="img">Hình ảnh</label>
            <input name="img" type="file" class="form-control-file" id="img" accept="image/x-png,image/gif,image/jpeg"/>
        </div>
    </div>
    <div>
        <input value="Xác nhận" type="submit" class="btn btn-primary"/>
        <a href="<c:url value="/"/>" class="btn btn btn-danger">Hủy</a>
    </div>
</form:form>
