<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/template/Admin/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Forms / Layouts - NiceAdmin Bootstrap Template</title>
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
			<h1>Form Điện Thoại</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item">Forms</li>
					<li class="breadcrumb-item active">Phone Manage</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Thêm Sản Phẩm</h5>

							<!-- Horizontal Form -->
							<form:form action="/admin/sanpham/index" modelAttribute="item"
								enctype="multipart/form-data">
								<form:hidden path="maSP" />
								<div class="row mb-3">
									<label for="inputHName" class="col-sm-3 col-form-label">Hãng
										Điện Thoại</label>
									<div class="col-sm-9">
										<form:select path="maHang.maHang" class="form-select">
											<form:options items="${list_h}" />
										</form:select>
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">Tên
										Điện Thoại</label>
									<div class="col-sm-9">
										<form:input path="tenSP" type="text" class="form-control" />
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputHName" class="col-sm-3 col-form-label">Hệ
										Điều Hành</label>
									<div class="col-sm-9">
										<form:select path="maHDH.maHDH" class="form-select">
											<form:options items="${list_hdh}" />
										</form:select>
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputEmail3" class="col-sm-3 col-form-label">Chip</label>
									<div class="col-sm-9">
										<form:input path="chip" type="text" class="form-control"
											placeholder="VD: Apple A17 Pro 6 nhân" />
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">Màn
										Hình</label>
									<div class="col-sm-9">
										<form:select path="manHinh.idManHinh" class="form-select">
											<form:options items="${list_mh}" />
										</form:select>
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">PIN và Sạc</label>
									<div class="col-sm-9">
										<form:select path="pinSac.idPin" class="form-select">
													<form:options items="${list_ps}" />
												</form:select>
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputEmail3" class="col-sm-3 col-form-label">Sim</label>
									<div class="col-sm-6">
										<form:input path="sim" type="text" class="form-control"
											placeholder="VD: 1 Nano SIM & 1 eSIM" />
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">CAMERA
										Trước</label>
									<div class="col-sm-9">
										<form:select path="camTruoc.idCamTruoc" class="form-select">
													<form:options items="${list_ct}" />
												</form:select>
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">CAMERA
										Sau</label>
									<div class="col-sm-9">
										<form:select path="camSau.idCamSau" class="form-select">
													<form:options items="${list_cs}" />
												</form:select>
									</div>
								</div>
								<div class="text-center">
									<a href="/admin/ctsp/index/${maSP}">Đi tới chi tiết sản
										phẩm</a>
									<button formaction="/admin/sanpham/update"
										class="btn btn-primary">Save</button>
									<button type="reset" class="btn btn-secondary">Reset</button>
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