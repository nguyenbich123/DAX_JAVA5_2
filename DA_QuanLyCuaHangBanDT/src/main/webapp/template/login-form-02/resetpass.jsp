<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="css/style.css">

    <title>Login #2</title>
  </head>
  <body>
  

  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('images/bg_2.jpg');"></div>
    <div class="contents order-2 order-md-1">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <h3>Đặt lại mật khẩu</h3>

            <form:form action="/account/resetpass" method="post" modelAttribute="tk">
             
              <div class="form-group last mb-3">
                <label for="password">Mật khẩu mới</label>
                <form:input type="password" cssClass="form-control" placeholder="New Password" path="matKhau"/>
                 <form:errors path="matKhau" cssClass="text-danger" />
              </div>
              <div class="form-group last mb-3">
                <label for="password">Xác nhận Mật khẩu</label>
                <form:input type="password" cssClass="form-control" placeholder="Confirm Password" path="matKhau"/>
                <form:errors path="matKhau" cssClass="text-danger" />
              </div>
                <button type="submit" class="btn btn-block btn-primary">Đăng nhập</button>

              <div class="card-footer py-3 border-0">
                <div class="text-center">
                  Quay về trang đăng nhập? <a href="/account/login" class="text-dark">Đăng Nhập</a>
                </div>
              </div>
            </form:form>
          </div>
        </div>
      </div>
    </div>

    
  </div>
    
    

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>