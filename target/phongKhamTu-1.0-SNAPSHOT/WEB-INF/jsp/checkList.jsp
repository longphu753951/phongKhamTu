<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/12/2021
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<link href="<c:url value="/css/checkList.css"/>" rel="stylesheet" />
<h1 style=" text-align: center; padding: 5% 0px" class="text-center">Danh sách thuốc đã chọn</h1>
<table>
    <c:forEach var="item" items="${sessionScope.cart}" varStatus="loop">
        <ul style="list-style-type:none">
           <li>
               <form action="/phongKhamTu_war/admin/khambenh/chonthuoc/checklist/update" method="post">
               <div class="item">
                   <div class="image image-wrapper">
                       <img style="width: 100%;" src="<c:url value="${item.medicine.pic}"/>"/>
                   </div>
                   <div class="item_detail_text">
                       <div class="item_detail_info">
                           <h6>${item.medicine.fullname}</h6>
                           <p>Giá cả: ${item.price} VND</p>
                           <a href="<c:url value="/admin/khambenh/chonthuoc/checklist/remove/${loop.index}"/>">Xóa</a>
                       </div>
                   </div>
                   <div class="sub_total">
                       <p class="sub_total_text">${item.totalPrice} VND</p>
                   </div>

                       <input type='hidden' name='itemIndex' value='<c:out value="${loop.index}"/>'>
                       <div class="sub_total">
                           <input min="1" type="number" value="<c:out value="${item.quantity}"/>" name="quantity" id="quantity"/>
                       </div>
                       <div class="sub_total">
                           <input class="btn btn-primary" type="submit" name="action" value="Sửa"/>
                       </div>

               </div>
               </form>
           </li>

        </ul>
    </c:forEach>
</table>

