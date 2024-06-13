<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
    href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
    rel="stylesheet">

<link rel="stylesheet"
    href="/template/login-form-02/fonts/icomoon/style.css">

<link rel="stylesheet"
    href="/template/login-form-02/css/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
    href="/template/login-form-02/css/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet" href="/template/login-form-02/css/style.css">

<title>Đăng Ký</title>

<style>
    body, html {
        height: 100%;
        margin: 0;
    }
    body {
        display: flex;
        align-items: center;
        justify-content: center;
        background-image: url('/template/login-form-02/images/TheLiem3.png');
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        height: 100hv;
    }
    .form-container {
        background: rgba(255, 255, 255, 0.9); /* Semi-transparent background for the form */
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .container {
        margin-top: 50px; /* Adjust the margin to add space from the top */
    }
</style>
</head>
<body>

    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7">
                <div class="form-container border p-4">
                    <h3>Đăng Ký</h3>
                    <p class="mb-4">Đăng ký để có những trãi nghiệm tốt nhất</p>
                    <form:form action="/account/signup" method="post"
                        modelAttribute="tk">
                        <div class="row">
                            <div class="col-md-6 form-group first">
                                <label for="hoTen">Họ và tên</label>
                                <form:input path="hoTen" id="hoTen" class="form-control"
                                    placeholder="Họ tên" />
                                <form:errors path="hoTen" cssClass="text-danger" />
                            </div>

                            <div class="col-md-6 form-group first">
                                <label for="tenDN">Tài khoản</label>
                                <form:input path="tenDN" id="tenDN" class="form-control"
                                    placeholder="Tên đăng nhập" />
                                <form:errors path="tenDN" cssClass="text-danger" />
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6 form-group last mb-3">
                                <label for="matKhau">Mật khẩu</label>
                                <form:input path="matKhau" id="matKhau" type="password"
                                    class="form-control" placeholder="Mật khẩu" />
                                <form:errors path="matKhau" cssClass="text-danger" />
                            </div>

                            <div class="col-md-6 form-group first">
                                <label for="sdt">Số điện thoại</label>
                                <form:input path="sdt" id="sdt" class="form-control"
                                    placeholder="Số điện thoại" />
                                <form:errors path="sdt" cssClass="text-danger" />
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6 form-group first">
                                <label for="email">Email</label>
                                <form:input path="email" id="email" type="email"
                                    class="form-control" placeholder="Email" />
                                <form:errors path="email" cssClass="text-danger" />
                            </div>
                        </div>

                        <div class="d-flex mb-5 align-items-center">
                            <label class="control control--checkbox mb-0"> <span
                                class="caption">Tôi đồng ý với điều khoản</span> <input
                                type="checkbox" name="terms" class="control__indicator"
                                checked="checked" />
                            </label>
                        </div>

                        <input type="submit" value="Đăng Ký"
                            class="btn btn-block btn-primary">

                        <div class="text-center">
                            Bạn đã có tài khoản? <a href="/account/login" class="text-dark">Đăng
                                Nhập</a>
                        </div>
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
