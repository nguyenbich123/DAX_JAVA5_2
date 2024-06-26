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

    <title>Đăng Ký</title>
  </head>
  <body>
  

  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('/template/login-form-02/images/bg_2.jpg');"></div>
    <div class="contents order-2 order-md-1">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <h3>Đăng Ký</h3>
            <p class="mb-4">Đăng ký để có những trãi nghiệm tốt nhất </p>
            <form action="/account/signup" method="post">
                <div class="form-group first">
                    <label for="username">Họ và tên</label>
                    <input type="text" class="form-control" placeholder="Họ tên" id="username">
                  </div>
              <div class="form-group first">
                <label for="username">Tài khoản</label>
                <input type="text" class="form-control" placeholder="Email" id="username">
              </div>
              <div class="form-group last mb-3">
                <label for="password">Mật khẩu</label>
                <input type="password" class="form-control" placeholder="Password" id="password">
              </div>
              
              <div class="d-flex mb-5 align-items-center">
                <label class="control control--checkbox mb-0"><span class="caption">Tôi đồng ý với điều khoản</span>
                  <input type="checkbox" checked="checked"/>
                  <div class="control__indicator"></div>
                </label>
              </div>

              <input type="submit" value="Đăng Ký" class="btn btn-block btn-primary">

              <div class="text-center">
                Bạn đã có tài khoản? <a href="/account/login" class="text-dark">Đăng Nhập</a>
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