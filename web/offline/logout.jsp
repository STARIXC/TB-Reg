<%-- 
    Document   : logout
    Created on : Jun 11, 2019, 9:26:03 AM
    Author     : starixc
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Page</title>
        <script src="backNoWork.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Expires", "0");
            response.setDateHeader("Expires", -1);
            session.invalidate(); 
        %>
    <center><h1>Logout Successful....</h1></center><br>
    <center>
        <img src="images/banner.PNG">
    </center>
    <center><h3>After Logout You Can't Go Back....</h3></center><br>
    <center><a href="login.jsp">Login Again.</a></center>
    </body>
   
</html>
