<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/1/2021
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="tiles"
          uri="http://tiles.apache.org/tags-tiles" %>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <link rel="icon" href="https://image.flaticon.com/icons/png/512/120/120082.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <!-- header -->
        <tiles:insertAttribute name="header" />
        <div class="container">


            <!-- content -->
            <tiles:insertAttribute name="content" />
        </div>
    </body>
</html>
