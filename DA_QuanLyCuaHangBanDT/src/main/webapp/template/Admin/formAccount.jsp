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
			<h1>Chỉnh Sửa Thông Tin ACCOUNT</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item">Forms</li>
					<li class="breadcrumb-item active">Quản Lý ACCOUNT</li>
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
							<form action="/admin/formAccount" modelAttribute="item"
								enctype="multipart/form-data">
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">Họ
										và Tên </label>
									<div class="col-sm-9">
										<form:input type="text" path="tenDN" class="form-control" />
									</div>
								</div>

								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">Role</label>
									<div class="col-sm-9">
										<div id="inputState" class="d-flex align-items-center">
											<div class="form-check me-3">
												
											</div>
										</div>
									</div>
								</div>

								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">Trạng
										Thái</label>
									<div class="col-sm-9">
										<div id="inputState" class="d-flex align-items-center">
											<c:forEach items="${list_tthd}" var="tthd">
												<div class="form-check me-3">
													<form:radiobuttons path="tthd" items="${list_tthd}" itemValue="id_TTDH" itemLabel="trangThai" />
												</div>
											</c:forEach>
										</div>
									</div>
								</div>

								<div class="text-center">
									<button type="submit" class="btn btn-primary">Cập Nhật</button>
								</div>
							</form>
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