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
			<h1>Quản Lý Hệ Điều Hành</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item">Forms</li>
					<li class="breadcrumb-item active">Quản Lý Hệ Điều Hành</li>
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
							<form:form action="/admin/hedieuhanh/index" modelAttribute="item"
								enctype="multipart/form-data">
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">
										Mã Hệ Điều Hành</label>
									<div class="col-sm-9">
										<form:input path="maHDH" type="text" class="form-control" readonly="true"/>
										
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">
										Hệ Điều Hành</label>
									<div class="col-sm-9">
										<form:input path="tenHDH" type="text" class="form-control" />
										<br>
										<form:errors path="tenHDH" cssClass="text-danger" /> 
									</div>
								</div>
								<div class="text-center">
									<button formaction="/admin/hedieuhanh/update" class="btn btn-primary">Lưu</button>
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
							<h5 class="card-title">Quản Lý Hệ Điều Hành</h5>

							<!-- Table with stripped rows 1-->
							<table class="table datatable">
								<thead>
									<tr>
										<th><a href="/admin/hedieuhanh/index?field=maHDH">Mã Hệ Điều Hành</a></th>
										<th><a href="/admin/hedieuhanh/index?field=tenHDH">Hệ Điều Hành</a></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}">
										<tr>
											<td>${item.maHDH}</td>
											<td>${item.tenHDH}</td>
											<td>
												<div class="icon">
													<a href="/admin/hedieuhanh/edit/${item.maHDH}"><i
														class="bi bi-pencil-fill"></i></a> <a
														href="/admin/hedieuhanh/delete/${item.maHDH}"><i
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
						href="/admin/hedieuhanh/index?field=${field}&p=${page.number - 1}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<c:forEach begin="1" end="${page.totalPages}" step="1" var="number">
					<li
						class="page-item <c:if test="${number == page.number +1}">active</c:if>">
						<a class="page-link"
						href="/admin/hedieuhanh/index?field=${field}&p=${number - 1}">${number}</a>
					</li>
				</c:forEach>
				<c:if test="${page.number < page.totalPages}">
					<li class="page-item"><a class="page-link"
						href="/admin/hedieuhanh/index?field=${field}&p=${page.number + 1}"
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