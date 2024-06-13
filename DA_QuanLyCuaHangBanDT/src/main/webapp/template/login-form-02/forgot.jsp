<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    .form-group {
        margin-bottom: 20px; /* Space between form groups */
    }
    input.form-control {
        height: 40px; /* Adjust height of input */
        font-size: 14px; /* Adjust font size */
    }
    button.btn-primary {
        height: 40px; /* Adjust height of button */
        font-size: 16px; /* Adjust font size */
    }
</style>
</head>
<body>
    <div class="container">
        <div class="form-container border p-4">
            <h3>Quên mật khẩu</h3>
            <p class="mb-4">Nhập E-mail để lấy lại mật khẩu</p>
            <form:form action="/account/forgot" method="post" modelAttribute="tk">
                <div class="form-group">
                    <label for="email">Email</label>
                    <form:input path="email" id="email" type="email" class="form-control" placeholder="Nhập Email" />
                    <form:errors path="email" cssClass="text-danger" />
                </div>
                <button type="submit" class="btn btn-block btn-primary">Lấy mã</button>
            </form:form>
        </div>
    </div>

    <script src="/template/login-form-02/js/jquery-3.3.1.min.js"></script>
    <script src="/template/login-form-02/js/popper.min.js"></script>
    <script src="/template/login-form-02/js/bootstrap.min.js"></script>
    <script src="/template/login-form-02/js/main.js"></script>
</body>
</html>
