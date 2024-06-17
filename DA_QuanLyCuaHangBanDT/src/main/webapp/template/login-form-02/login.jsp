<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<title>Đăng Nhập</title>

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
	background: rgba(255, 255, 255, 0.9);
	/* Semi-transparent background for the form */
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

/* Custom checkbox style */
.control {
	position: relative;
	display: inline-block;
	cursor: pointer;
	font-size: 16px;
	line-height: 20px;
}

.control input {
	position: absolute;
	opacity: 0;
	cursor: pointer;
}

.control__indicator {
	position: absolute;
	top: 0;
	left: 0;
	height: 20px;
	width: 20px;
	background-color: #fff;
	border: 1px solid #ccc;
}

.control:hover input ~ .control__indicator, .control input:focus ~
	.control__indicator {
	background-color: #f1f1f1;
}

.control input:checked ~ .control__indicator {
	background-color: #000;
	border-color: #000;
}

.control__indicator:after {
	content: "";
	position: absolute;
	display: none;
}

.control input:checked ~ .control__indicator:after {
	display: block;
}

.control-checkbox .control__indicator:after {
	left: 7px;
	top: 3px;
	width: 6px;
	height: 12px;
	border: solid #fff;
	border-width: 0 2px 2px 0;
	transform: rotate(45deg);
}
</style>
</head>
<body>
	<div class="container">
		<div class="form-container border p-4">
			<h3>Đăng Nhập</h3>
			<p class="mb-4">Trải nghiệm của quý khách là niềm vui của chúng
				tôi</p>
			<%-- <form:form action="/account/login" method="post" modelAttribute="tk">
                <div class="form-group first">
                    <label for="tenDN">Tài khoản</label>
                    <form:input path="tenDN" id="tenDN" class="form-control" placeholder="Account" />
                    <form:errors path="tenDN" cssClass="text-danger" />
                </div>
                <div class="form-group last mb-3">
                    <label for="matKhau">Mật khẩu</label>
                    <form:input path="matKhau" id="matKhau" type="password" class="form-control" placeholder="Password" />
                    <form:errors path="matKhau" cssClass="text-danger" />
                </div>
                <div class="d-flex mb-5 align-items-center">
                    <label class="control control-checkbox mb-0">
                        <span class="caption">Ghi nhớ</span>
                        <input type="checkbox" name="remember" class="form-check-input" />
                        <div class="control__indicator"></div>
                    </label>
                    <span class="ml-auto"><a href="/account/forgot" class="forgot-pass">Quên mật khẩu</a></span>
                </div>
                <button type="submit" class="btn btn-block btn-primary">Đăng Nhập</button>
                <div class="text-center">
                    Bạn chưa có tài khoản? <a href="/account/signup" class="text-dark">Đăng Ký</a>
                </div>
            </form:form> --%>
			<form:form action="/account/login" method="post" modelAttribute="tk">
				<div class="form-group first">
					<label for="tenDN">Tài khoản</label>
					<form:input path="tenDN" id="tenDN" class="form-control"
						placeholder="Account" />
					<form:errors path="tenDN" cssClass="text-danger" />
				</div>
				<div class="form-group last mb-3">
					<label for="matKhau">Mật khẩu</label>
					<form:input path="matKhau" id="matKhau" type="password"
						class="form-control" placeholder="Password" />
					<form:errors path="matKhau" cssClass="text-danger" />
				</div>
				<div class="d-flex mb-5 align-items-center">
					<label class="control control-checkbox mb-0"> <span
						class="caption">Ghi nhớ</span> <input type="checkbox"
						name="remember" class="form-check-input" />
						<div class="control__indicator"></div>
					</label> <span class="ml-auto"><a href="/account/forgot"
						class="forgot-pass">Quên mật khẩu</a></span>
				</div>
				<button type="submit" class="btn btn-block btn-primary">Đăng
					Nhập</button>
				<div class="text-center">
					Bạn chưa có tài khoản? <a href="/account/signup" class="text-dark">Đăng
						Ký</a>
				</div>
				<div class="text-danger">
					<form:input type="hidden" path="sdt" value="a"/>
					<form:input type="hidden" path="hoTen" value="a"/>
					<form:input type="hidden" path="email" value="a@gmail.com"/>
				</div>
			</form:form>

		</div>
	</div>

	<script src="/template/login-form-02/js/jquery-3.3.1.min.js"></script>
	<script src="/template/login-form-02/js/popper.min.js"></script>
	<script src="/template/login-form-02/js/bootstrap.min.js"></script>
	<script src="/template/login-form-02/js/main.js"></script>
</body>
</html>
