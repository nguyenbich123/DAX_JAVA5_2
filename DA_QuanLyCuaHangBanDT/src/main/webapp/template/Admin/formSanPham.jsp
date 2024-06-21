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
										<form:select path="maHang" class="form-select">
											<c:if test="${!not empty item.maHang }">
												<form:option value="">--Chọn Hãng--</form:option>
												<form:options items="${list_h}" />
											</c:if>
											<c:if test="${not empty item.maHang }">
												<form:option value="${item.maHang.maHang}">${item.maHang.tenHang}</form:option>
												<form:options items="${list_h}" />
											</c:if>
										</form:select>

										<form:errors path="maHang" cssClass="text-danger" />
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">Tên
										Điện Thoại</label>
									<div class="col-sm-9">
										<form:input path="tenSP" type="text" class="form-control" />
										<form:errors path="tenSP" cssClass="text-danger" />
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputHName" class="col-sm-3 col-form-label">Hệ
										Điều Hành</label>
									<div class="col-sm-9">
										<form:select path="maHDH" class="form-select">
											<c:if test="${!not empty item.maHDH }">
												<form:option value="">--Chọn Hệ Điều Hành--</form:option>
												<form:options items="${list_hdh}" />
											</c:if>
											<c:if test="${not empty item.maHDH }">
												<form:option value="${item.maHDH.maHDH}">${item.maHDH.tenHDH}</form:option>
												<form:options items="${list_hdh}" />
											</c:if>
										</form:select>
										<form:errors path="maHDH" cssClass="text-danger" />
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputEmail3" class="col-sm-3 col-form-label">Chip</label>
									<div class="col-sm-9">
										<form:input path="chip" type="text" class="form-control"
											placeholder="VD: Apple A17 Pro 6 nhân" />
										<form:errors path="chip" cssClass="text-danger" />
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">Màn
										Hình</label>
									<div class="col-sm-9">
										<form:select path="manHinh" class="form-select">
											<c:if test="${!not empty item.manHinh }">
												<form:option value="">--Chọn Màn Hình--</form:option>
												<form:options items="${list_mh}" />
											</c:if>
											<c:if test="${not empty item.manHinh }">
												<form:option value="${item.manHinh.idManHinh}">${item.manHinh.tenManhHinh}</form:option>
												<form:options items="${list_mh}" />
											</c:if>
										</form:select>
										<form:errors path="manHinh" cssClass="text-danger" />
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">PIN
										và Sạc</label>
									<div class="col-sm-9">
										<form:select path="pinSac" class="form-select">
											<c:if test="${!not empty item.pinSac }">
												<form:option value="">--Chọn Pin Sạc--</form:option>
												<form:options items="${list_ps}" />
											</c:if>
											<c:if test="${not empty item.pinSac }">
												<form:option value="${item.pinSac.idPin}">${item.pinSac.tenPin}</form:option>
												<form:options items="${list_ps}" />
											</c:if>
										</form:select>
										<form:errors path="pinSac" cssClass="text-danger" />
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputEmail3" class="col-sm-3 col-form-label">Sim</label>
									<div class="col-sm-6">
										<form:input path="sim" type="text" class="form-control"
											placeholder="VD: 1 Nano SIM & 1 eSIM" />
										<form:errors path="sim" cssClass="text-danger" />
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">CAMERA
										Trước</label>
									<div class="col-sm-9">
										<form:select path="camTruoc" class="form-select">
											<c:if test="${!not empty item.camTruoc }">
												<form:option value="">--Chọn Cam Trước--</form:option>
												<form:options items="${list_ct}" />
											</c:if>
											<c:if test="${not empty item.camTruoc }">
												<form:option value="${item.camTruoc.idCamTruoc}">${item.camTruoc.tenCamTruoc}</form:option>
												<form:options items="${list_ct}" />
											</c:if>
										</form:select>
										<form:errors path="camTruoc" cssClass="text-danger" />
									</div>
								</div>
								<hr>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">CAMERA
										Sau</label>
									<div class="col-sm-9">
										<form:select path="camSau" class="form-select">
											<c:if test="${!not empty item.camSau }">
												<form:option value="">--Chọn Cam Sau--</form:option>
												<form:options items="${list_cs}" />
											</c:if>
											<c:if test="${not empty item.camSau }">
												<form:option value="${item.camSau.idCamSau}">${item.camSau.tenCamSau}</form:option>
												<form:options items="${list_cs}" />
											</c:if>
											
										</form:select>
										<form:errors path="camSau" cssClass="text-danger" />
									</div>
								</div>
								<div class="text-center">
									<a href="/admin/ctsp/index/${maSP}">Đi tới chi tiết sản
										phẩm</a>
									<button formaction="/admin/sanpham/update"
										class="btn btn-primary">Lưu</button>
									<button type="reset" class="btn btn-secondary">Làm Mới</button>
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