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

    <link rel="stylesheet" href="/template/login-form-02/fonts/icomoon/style.css">

    <link rel="stylesheet" href="/template/login-form-02/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/template/login-form-02/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="/template/login-form-02/css/style.css">
    

    <title>Quên mật khẩu</title>
  </head>
  <body>
  

  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('/template/login-form-02/images/bg_2.jpg');"></div>
    <div class="contents order-2 order-md-1">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <h3>Quên mật khẩu</h3>
            <p class="mb-3">Nhập E-mail để lấy lại mật khẩu </p>
            <form:form action="#" method="post" modelAttribute="tk">
              <div class="form-group first">
                <label for="username">Email</label>
                <form:input type="text" class="form-control" placeholder="Nhập Email" path="email"/>
                 <form:errors path="email" cssClass="text-danger" />
              </div> 
				  <button type="submit" value="Lấy mã" class="btn btn-block btn-primary">Đăng nhập</button>
            </form:form>
          </div>
        </div>
      </div>
    </div>

    

    
    

    <script src="/template/login-form-02/js/jquery-3.3.1.min.js"></script>
    <script src="/template/login-form-02/js/popper.min.js"></script>
    <script src="/template/login-form-02/js/bootstrap.min.js"></script>
    <script src="/template/login-form-02/js/main.js"></script>
  </body>
</html>