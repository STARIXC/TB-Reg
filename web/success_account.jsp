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
        <title>Account activated</title>
        <link rel="stylesheet" href="assets/bootstrap-3/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery.min.js"></script>
        <script src="assets/bootstrap-3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/select2.min.css">
        <script src="backNoWork.js" type="text/javascript"></script>
    </head>
      <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-default">
                <div class="panel-body">
                    <h1 class="text-center">Account Created successfully</h1>
                    <p class="text-center"> Access your email Address to activate the account</p>
    <center>
        <img src="images/banner.PNG" class="img-responsive">
    </center><br><br>
    
                </div>
            </div>
                </div>
            </div>
            
        </div>
    
</body>
    <script>
        var timer = setTimeout(function() {
            window.location.href="login.jsp";
        }, 5000);
    </script>

</html>
