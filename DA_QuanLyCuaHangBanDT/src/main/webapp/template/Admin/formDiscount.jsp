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
			<h1>Quản Lý Hãng</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item">Forms</li>
					<li class="breadcrumb-item active">Quản Lý Giảm Giá</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Thêm</h5>
							<!-- Horizontal Form -->
						<form:form action="/admin/giamgia/index" modelAttribute="item"
								enctype="multipart/form-data">
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">
										Id Mã Giảm Giá</label>
									<div class="col-sm-9">
										<form:input path="idGiamGia" type="text" class="form-control" readonly="true"/>
										<br>
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">
										Mã Giảm Giá</label>
									<div class="col-sm-9">
										<form:input path="maGG" type="text" class="form-control" />
											<br>
										<form:errors path="maGG" cssClass="text-danger" />
										
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">
										Giảm giá %</label>
									<div class="col-sm-9">
										<form:input path="giamGia" name="giamGia" type="text" class="form-control" />
											<br>
										<form:errors path="giamGia" cssClass="text-danger" />
										
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">
										Đơn Hàng Tối Thiểu</label>
									<div class="col-sm-9">
										<form:input path="dhtt" type="text" class="form-control" />
											<br>
										<form:errors path="dhtt" cssClass="text-danger" />
										
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">
										Số Tiền Giảm Tối Đa</label>
									<div class="col-sm-9">
										<form:input path="stgtd" type="text" class="form-control" />
											<br>
										<form:errors path="stgtd" cssClass="text-danger" />
										
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">
										Thời Gian Bắt Đầu</label>
									<div class="col-sm-9">
										<form:input path="tgAp" type="date" class="form-control" />
										<br>
										<form:errors path="tgAp" cssClass="text-danger" />
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">
										Thời Gian Kết Thúc</label>
									<div class="col-sm-9">
										<form:input path="tgKt" type="date" class="form-control" />
										<br>
										<form:errors path="tgKt" cssClass="text-danger" />
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">
										Hình</label>
									<div class="col-sm-9">
										<input type="file" name="photo_file" class="form-control" />
										<br>
										<form:hidden path="img" />
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">
										Số Lượng </label>
									<div class="col-sm-9">
										<form:input type="text" path="soLuong" class="form-control" />
										<br>
										<form:errors path="soLuong" cssClass="text-danger" />
									</div>
								</div>
								<div class="text-center">
									<button formaction="/admin/giamgia/update" class="btn btn-primary">Lưu</button>
									<button type="reset" class="btn btn-secondary">Làm Mới</button>
								</div>
							</form:form>
							<!-- End Horizontal Form -->

						</div>
					</div>
				</div>
			</div>
		</section>
		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Quản Lý Giảm Giá</h5>

							<!-- Table with stripped rows 1-->
							<table class="table datatable">
								<thead>
									<tr>
										<!-- <th><a href="/admin/giamgia/index?field=idGiamGia">ID</a></th>
										<th><a href="/admin/giamgia/index?field=maGG">Mã Giảm Giá</a></th>
										<th><a href="/admin/giamgia/index?field=giamGia">Giảm Giá</a></th>
										<th><a href="/admin/giamgia/index?field=dhtt">Đơn Hàng Tối Thiểu</a></th>
										<th><a href="/admin/giamgia/index?field=stgtd">Số Tiền Giảm Tối Đa</a></th>
										<th><a href="/admin/giamgia/index?field=tgAp">Thời Gian Áp Dụng</a></th>
										<th><a href="/admin/giamgia/index?field=tgKt">Thời Gian Kết Thúc</a></th>
										<th><a href="/admin/giamgia/index?field=soLuong">Số Lượng</a></th>
										<th><a href="/admin/giamgia/index?field=img">Hình</a></th>
									</tr> -->
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}">
										<tr>
											<td>${item.idGiamGia}</td>
											<td>${item.maGG}</td>
											<td>${item.giamGia}</td>
											<td>${item.dhtt}</td>
											<td>${item.stgtd}</td>
											<td>${item.tgAp}</td>
											<td>${item.tgKt}</td>
											<td>${item.soLuong}</td>
											<td><img src="/images/${item.img}" alt="" style="max-width: 100px;"></td>
											<td>
												<div class="icon">
													<a href="/admin/giamgia/edit/${item.idGiamGia}"><i
														class="bi bi-pencil-fill"></i></a>
														<a href="/admin/giamgia/delete/${item.idGiamGia}"><i
														class="ri-delete-bin-5-fill"></i></a>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- End Table with stripped rows -->

						</div>
					</div>
					<nav aria-label="Page navigation">
						<ul class="pagination justify-content-center">

							<c:if test="${page.number > 0}">
								<li class="page-item"><a class="page-link"
									href="/admin/giamgia/index?field=${field}&p=${page.number - 1}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:if>
							<c:forEach begin="1" end="${page.totalPages}" step="1"
								var="number">
								<li
									class="page-item <c:if test="${number == page.number +1}">active</c:if>">
									<a class="page-link"
									href="/admin/giamgia/index?field=${field}&p=${number - 1}">${number}</a>
								</li>
							</c:forEach>
							<c:if test="${page.number < page.totalPages-1}">
								<li class="page-item"><a class="page-link"
									href="/admin/giamgia/index?field=${field}&p=${page.number + 1}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</c:if>

						</ul>
					</nav>
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