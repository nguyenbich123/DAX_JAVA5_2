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
			<h1>Quản Lý Cam Trước</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item">Forms</li>
					<li class="breadcrumb-item active">Quản Lý Cam Trước</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Form Cam Trước</h5>

							<!-- Horizontal Form -->
							<form:form action="/admin/camtruoc/index" modelAttribute="ct" enctype="multipart/form-data">
								   <form:hidden path="idCamTruoc" />
								  <div class="row mb-3">
                                    <label for="inputEmail3" class="col-sm-3 col-form-label">Tên Cam Trước</label>
                                    <div class="col-sm-9">
                                     <form:input path="tenCamTruoc" type="text" class="form-control"/>
                                     			<br>
										<form:errors path="tenCamTruoc" cssClass="text-danger" />
                                  </div>
                                </div>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">Độ Phân Giải Cam Trước</label>
									<div class="col-sm-9">
										<form:select path="DPGCT"  class="form-select">
										<form:option value="">--Chọn Độ Phân Giải--</form:option>
											<form:options items="${list_dpgct}" />
										</form:select>
													<br>
										<form:errors path="DPGCT" cssClass="text-danger" />
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">Tính Năng Cam Trước</label>
									<div class="col-sm-9 ">
										<form:select path="TNCT" class="form-select">
										<form:option value="">--Chọn Tính Năng--</form:option>
											<form:options items="${list_tnct}" />
										</form:select>
													<br>
										<form:errors path="TNCT" cssClass="text-danger" />
									</div>
								</div>
								<div class="text-center">
									<button formaction="/admin/camtruoc/update" class="btn btn-primary">Lưu</button>
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
							<h5 class="card-title">Quản Lý Pin Sạc</h5>

							<!-- Table with stripped rows 1-->
							<table class="table datatable">
								<thead>
									<tr>
										<th><a href="/admin/camtruoc/index?field=idCamTruoc">ID</a></th>
										<th><a href="/admin/camtruoc/index?field=tenCamTruoc">Tên Cam Trước</a></th>
										<th><a href="/admin/camtruoc/index?field=DPGCT">Độ Phân Giải Cam Trước</a></th>
										<th><a href="/admin/camtruoc/index?field=TNCT">Tính Năng Cam Trước</a></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}">
										<tr>
											<td>${item.idCamTruoc}</td>
											<td>${item.tenCamTruoc}</td>
											<td>${item.DPGCT.dpg}</td>
											<td>${item.TNCT.tinhNang}</td>
											<td>
												<div class="icon">
													<a href="/admin/camtruoc/edit/${item.idCamTruoc}"><i
														class="bi bi-pencil-fill"></i></a>
													<a href="/admin/camtruoc/delete/${item.idCamTruoc}"><i
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
									href="/admin/camtruoc/index?field=${field}&p=${page.number - 1}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:if>
							<c:forEach begin="1" end="${page.totalPages}" step="1"
								var="number">
								<li
									class="page-item <c:if test="${number == page.number +1}">active</c:if>">
									<a class="page-link"
									href="/admin/camtruoc/index?field=${field}&p=${number - 1}">${number}</a>
								</li>
							</c:forEach>
							<c:if test="${page.number < page.totalPages-1}">
								<li class="page-item"><a class="page-link"
									href="/admin/camtruoc/index?field=${field}&p=${page.number + 1}"
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