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

    <title>Login</title>
  </head>
  <body>
  

  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('/template/login-form-02/images/bg_2.jpg');"></div>
    <div class="contents order-2 order-md-1">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <h3>Đăng nhập tới <strong style="color: orangered;">THELIEM</strong></h3>
            <p class="mb-4">Trải nghiệm của quý khách là niềm vui của chúng tôi </p>
            <form:form action="/account/login" method="post"  modelAttribute="tk">
              <div class="form-group first">
                <label for="username">Tài khoản</label>
                <form:input type="text" class="form-control" placeholder="Email" path="tenDN"/>
                <form:errors path="tenDN" cssClass="text-danger" />
              </div>
              <div class="form-group last mb-3">
                <label for="password">Mật khẩu</label>
                <form:input path="matKhau" type="password" cssClass="form-control" placeholder="Password"/>
                <form:errors path="matKhau" cssClass="text-danger" />
              </div>
              <div class="d-flex mb-5 align-items-center">
                <label class="control control--checkbox mb-0"><span class="caption">Ghi nhớ</span>
                  <input type="checkbox" name="remember" cssClass="form-check-input"/>
                  <div class="control__indicator"></div>
                </label>
                <span class="ml-auto"><a href="/account/forgot" class="forgot-pass">Quên mật khẩu</a></span> 
              </div>
             <button type="submit" class="btn btn-block btn-primary">Đăng nhập</button>

              <div class="card-footer py-3 border-0">
                <div class="text-center">
                  Bạn chưa có tài khoản? <a href="/account/signup" class="text-dark">Đăng ký</a>
                </div>
              </div>
            </form:form>
          </div>
      
         
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