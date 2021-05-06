<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/4/2021
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <spring:url value="/login" var="action" />
    <form action="${action}" method="post" >
        <div class="form-group">
            <input name="username" id="usernameId"
                   class="form-control" />
        </div>
        <div class="form-group">
            <label for="passwordId">

            </label>
            <input id="passwordId" name="password"
                   class="form-control" type="password" />
        </div>
        <div class="form-group">
            <input type="submit"  />
        </div>
    </form>
</body>
</html>
