<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/template/Admin/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Forms / Quản Lý Acccount</title>
<meta content="" name="description">
<meta content="" name="keywords">
<%@ include file="/template/Admin/common/head.jsp"%>
</head>

<body>
	<!-- ======= Header ======= -->
	<%@ include file="/template/Admin/common/header.jsp"%>

	<!-- ======= Sidebar ======= -->
	<%@ include file="/template/Admin/common/sidebar.jsp"%>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Account</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item">Admin</li>
					<li class="breadcrumb-item active">Account</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Sửa</h5>

							<!-- Horizontal Form -->
							<form:form action="/admin/account/index" modelAttribute="item" enctype="multipart/form-data">
								<form:hidden path="tenDN" />
								<form:hidden path="hoTen" />
								<form:hidden path="matKhau" />
								<form:hidden path="sdt" />
								<form:hidden path="email" />
								<form:hidden path="img" />
								
								<div class="row mb-3">
									<label for="inputName" class="col-sm-2 col-form-label">Tên Đăng Nhập </label>
									<label class="col-sm-4 col-form-label"> ${item.tenDN}</label>
									<label for="inputName" class="col-sm-2 col-form-label">Họ và Tên </label>							
									<label class="col-sm-4 col-form-label"> ${item.hoTen}</label>
								</div>
	
								<div class="row mb-3">
									<label for="inputName" class="col-sm-2 col-form-label">Role</label>
									<div class="col-sm-4">
										<div id="inputState" class="d-flex align-items-center">
											<form:select path="role.Idrole" class="form-select">
												<form:options items="${list_role}" />
											</form:select>
										</div>
									</div>
									<label for="inputName" class="col-sm-2 col-form-label">Trạng Thái</label>
									<div class="col-sm-4">
										<div id="inputState" class="d-flex align-items-center">
											<form:select path="tthd.Idtthd" class="form-select">
												<form:options items="${list_tthd}" />
											</form:select>
										</div>
									</div>
								</div>
	<br>
								<div class="text-center">
									<a href="/admin/account/index"><button class="btn btn-primary">Quay lại</button></a>
									<button formaction="/admin/account/update" class="btn btn-primary">Cập Nhật</button>								
								</div>
							</form:form>
							<!-- End Horizontal Form -->

						</div>
					</div>


				</div>
			</div>
		</section>

	</main>
	<!-- End #main -->
	<!-- ======= Footer ======= -->
	<%@ include file="/template/Admin/common/footer.jsp"%>

	<!-- JS Files -->
	<%@ include file="/template/Admin/common/jsfile.jsp"%>
</body>

</html>