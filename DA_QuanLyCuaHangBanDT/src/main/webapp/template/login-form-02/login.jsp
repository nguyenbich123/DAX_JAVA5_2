<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <form action="/account/login" method="post">
              <div class="form-group first">
                <label for="username">Tài khoản</label>
                <input type="text" class="form-control" placeholder="Email" id="username">
              </div>
              <div class="form-group last mb-3">
                <label for="password">Mật khẩu</label>
                <input type="password" class="form-control" placeholder="Password" id="password">
              </div>
              <div class="d-flex mb-5 align-items-center">
                <label class="control control--checkbox mb-0"><span class="caption">Ghi nhớ</span>
                  <input type="checkbox" checked="checked"/>
                  <div class="control__indicator"></div>
                </label>
                <span class="ml-auto"><a href="/account/forgot" class="forgot-pass">Quên mật khẩu</a></span> 
              </div>
              <a href="/account/login"><input value="Đăng nhập" class="btn btn-block btn-primary"></a>

              <div class="card-footer py-3 border-0">
                <div class="text-center">
                  Bạn chưa có tài khoản? <a href="/account/signup" class="text-dark">Đăng ký</a>
                </div>
              </div>
            </form>
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