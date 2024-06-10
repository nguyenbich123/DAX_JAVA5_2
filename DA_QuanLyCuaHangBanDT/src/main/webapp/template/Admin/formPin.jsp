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
			<h1>Quản Lý Pin</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item">Forms</li>
					<li class="breadcrumb-item active">Quản Lý Pin</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Form Pin</h5>

							<!-- Horizontal Form -->
							<form:form action="/admin/ps/index" modelAttribute="item" enctype="multipart/form-data">
								   <form:hidden path="idPin" />
								  <div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">Loại Pin</label>
									<div class="col-sm-9 ">
										<form:select path="loaiPin.idlp" class="form-select">
											<form:options items="${list_lp}" />
										</form:select>
									</div>
								</div>
								  <div class="row mb-3">
                                    <label for="inputEmail3" class="col-sm-3 col-form-label">Tên Pin</label>
                                    <div class="col-sm-9">
                                      <form:input path="tenPin" type="text" class="form-control"/>
                                  </div>
                                </div>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">Dung Lượng Pin</label>
									<div class="col-sm-9">
										<form:select path="DLPin.idDLP" class="form-select">
											<form:options items="${list_dlp}" />
										</form:select>
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">Hỗ Trợ Sạc</label>
									<div class="col-sm-9 ">
										<form:select path="hoTroSac.idHTS" class="form-select">
											<form:options items="${list_hts}" />
										</form:select>
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">Công Nghệ Pin</label>
									<div class="col-sm-9 ">
										<form:select path="CNP.idcnp" class="form-select">
											<form:options items="${list_cnp}" />
										</form:select>
									</div>
								</div>
								<div class="text-center">
									<button formaction="/admin/ps/update" class="btn btn-primary">Lưu</button>
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
										<th><a href="/admin/ps/index?field=idPin">ID</a></th>
										<th><a href="/admin/ps/index?field=loaiPin">Loại Pin</a></th>
										<th><a href="/admin/ps/index?field=tenPin">Tên Pin</a></th>
										<th><a href="/admin/ps/index?field=DLPin">Dung Lượng Pin</a></th>
										<th><a href="/admin/ps/index?field=hoTroSac">Hỗ Trợ Sạc</a></th>
										<th><a href="/admin/ps/index?field=CNP">Công Nghệ Pin</a></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}">
										<tr>
											<td>${item.idPin}</td>
											<td>${item.loaiPin.loaiPin}</td>
											<td>${item.tenPin}</td>
											<td>${item.DLPin.dlPin}</td>
											<td>${item.hoTroSac.hoTroSac}</td>
											<td>${item.CNP.congNghePin}</td>
											<td>
												<div class="icon">
													<a href="/admin/ps/edit/${item.idPin}"><i
														class="bi bi-pencil-fill"></i></a>
													<a href="/admin/ps/delete/${item.idPin}"><i
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
									href="/admin/ps/index?field=${field}&p=${page.number - 1}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:if>
							<c:forEach begin="1" end="${page.totalPages}" step="1"
								var="number">
								<li
									class="page-item <c:if test="${number == page.number +1}">active</c:if>">
									<a class="page-link"
									href="/admin/ps/index?field=${field}&p=${number - 1}">${number}</a>
								</li>
							</c:forEach>
							<c:if test="${page.number < page.totalPages-1}">
								<li class="page-item"><a class="page-link"
									href="/admin/ps/index?field=${field}&p=${page.number + 1}"
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