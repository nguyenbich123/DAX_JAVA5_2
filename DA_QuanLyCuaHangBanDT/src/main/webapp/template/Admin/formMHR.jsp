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

<style>
    .short-input {
        width: 50%; /* Adjust the width as needed */
    }
</style>
</head>

<body>

	<!-- ======= Header ======= -->
	<%@ include file="/template/Admin/common/header.jsp"%>

	<!-- ======= Sidebar ======= -->
	<%@ include file="/template/Admin/common/sidebar.jsp"%>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Màn Hình Rộng</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item">Forms</li>
					<li class="breadcrumb-item active">Màn Hình Rộng</li>
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
							<form:form action="/admin/mhr/index" modelAttribute="item"
								enctype="multipart/form-data">
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">
										Mã MH</label>
									<div class="col-sm-9">
										<form:input path="idMHR" type="text" class="form-control short-input"  readonly="true"  />
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">
										Kích Thước</label>
									<div class="col-sm-9">
										<form:input path="mhRong" type="text" class="form-control short-input" />
										<form:errors path="mhRong" cssClass="text-danger" />
									</div>
								</div>
								<div class="text-center">
									<button formaction="/admin/mhr/update" class="btn btn-primary">Lưu</button>
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
							<h5 class="card-title">Loại Màn</h5>

							<!-- Table with stripped rows 1-->
							<table class="table datatable">
								<thead>
									<tr>
										<th><a href="/admin/mhr/index?field=idMHR">Mã Màn Hình</a></th>
										<th><a href="/admin/mhr/index?field=mhRong">Kích Thước Màn</a></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}">
										<tr>
											<td>${item.idMHR}</td>
											<td>${item.mhRong}</td>
											<td>
												<div class="icon">
													<a href="/admin/mhr/edit/${item.idMHR}"><i
														class="bi bi-pencil-fill"></i></a>
													<a href="/admin/mhr/delete/${item.idMHR}"><i
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
									href="/admin/mhr/index?field=${field}&p=${page.number - 1}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:if>
							<c:forEach begin="1" end="${page.totalPages}" step="1"
								var="number">
								<li
									class="page-item <c:if test="${number == page.number +1}">active</c:if>">
									<a class="page-link"
									href="/admin/mhr/index?field=${field}&p=${number - 1}">${number}</a>
								</li>
							</c:forEach>
							<c:if test="${page.number < page.totalPages-1}">
								<li class="page-item"><a class="page-link"
									href="/admin/mhr/index?field=${field}&p=${page.number + 1}"
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
