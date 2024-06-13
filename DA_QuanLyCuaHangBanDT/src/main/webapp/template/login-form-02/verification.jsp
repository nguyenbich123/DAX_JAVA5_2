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

<title>Xác nhận mã</title>

<style>
    html, body {
        height: 100%;
        margin: 0;
    }
    body {
        background-image: url('/template/login-form-02/images/TheLiem3.png');
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .form-container {
        background: rgba(255, 255, 255, 0.9); /* Semi-transparent background for the form */
        padding: 20px;
        border-radius: 10px;
        max-width: 100%;
        box-sizing: border-box;
    }
    .container {
        width: 100%;
        max-width: 700px;
        padding: 20px;
        box-sizing: border-box;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="form-container border p-4">
            <h3>Xác nhận mã</h3>
            <form action="/account/verify" method="post">
                <div class="form-group first">
                    <label for="code">Nhập mã</label>
                    <input type="text" class="form-control" placeholder="Code" id="code" name="code">
                </div>
                <input type="submit" value="Xác nhận" class="btn btn-block btn-primary">
                <div class="card-footer py-3 border-0">
                    <div class="text-center">
                        Bạn chưa nhận được mã? <a href="/account/forgot" class="text-dark">Lấy mã</a>
                    </div>
                </div>
                <div class="text-danger">
                    <p>${error}</p>
                </div>
            </form>
        </div>
    </div>

    <script src="/template/login-form-02/js/jquery-3.3.1.min.js"></script>
    <script src="/template/login-form-02/js/popper.min.js"></script>
    <script src="/template/login-form-02/js/bootstrap.min.js"></script>
    <script src="/template/login-form-02/js/main.js"></script>
</body>
</html>
