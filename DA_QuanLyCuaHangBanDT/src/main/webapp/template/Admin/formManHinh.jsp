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
			<h1>Quản Lý Màn Hình</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item">Forms</li>
					<li class="breadcrumb-item active">Quản Lý Màn Hình</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Form Màn Hình</h5>

							<!-- Horizontal Form -->
							<form:form action="/admin/mh/index" modelAttribute="item" enctype="multipart/form-data">
								  <form:hidden path="idManHinh" />
								  <div class="row mb-3">
                                    <label for="inputEmail3" class="col-sm-3 col-form-label">Tên Màn Hình</label>
                                    <div class="col-sm-9">
                                      <form:input path="tenManhHinh" type="text" class="form-control"/>
                                      <form:errors path="tenManhHinh" />
                                  </div>
                                </div>
								<div class="row mb-3">
									<label for="inputName" class="col-sm-3 col-form-label">Công
										Nghệ Màn Hình</label>
									<div class="col-sm-9">
										<form:select path="CNMH.idCNMH" class="form-select">
											<form:options items="${list_cnmh}" />
										</form:select>
									</div>
								</div>

								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">Màn
										Hình Rộng</label>
									<div class="col-sm-9 ">
										<form:select path="MHR.idMHR" class="form-select">
											<form:options items="${list_mhr}" />
										</form:select>
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">Độ
										Phân Giải</label>
									<div class="col-sm-9 ">
										<form:select path="DPGMH.idDPGMH" class="form-select">
											<form:options items="${list_dpg}" />
										</form:select>
									</div>
								</div>
								<div class="text-center">
									<button formaction="/admin/mh/update" class="btn btn-primary">Lưu</button>
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
							<h5 class="card-title">Quản Lý Màn Hình</h5>

							<!-- Table with stripped rows 1-->
							<table class="table datatable">
								<thead>
									<tr>
										<th><a href="/admin/mh/index?field=idManHinh">ID</a></th>
										<th><a href="/admin/mh/index?field=tenManhHinh">Tên Màn Hình</a></th>
										<th><a href="/admin/mh/index?field=CNMH">Công Nghệ Màn Hình</a></th>
										<th><a href="/admin/mh/index?field=MHR">Màn Hình Rộng</a></th>
										<th><a href="/admin/mh/index?field=DPGMH">Độ Phân Giải</a></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}">
										<tr>
											<td>${item.idManHinh}</td>
											<td>${item.tenManhHinh }</td>
											<td>${item.CNMH.cnmh}</td>
											<td>${item.MHR.mhRong}</td>
											<td>${item.DPGMH.dpg}</td>
											<td>
												<div class="icon">
													<a href="/admin/mh/edit/${item.idManHinh}"><i
														class="bi bi-pencil-fill"></i></a>
													<a href="/admin/mh/delete/${item.idManHinh}"><i
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
									href="/admin/mh/index?field=${field}&p=${page.number - 1}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:if>
							<c:forEach begin="1" end="${page.totalPages}" step="1"
								var="number">
								<li
									class="page-item <c:if test="${number == page.number +1}">active</c:if>">
									<a class="page-link"
									href="/admin/mh/index?field=${field}&p=${number - 1}">${number}</a>
								</li>
							</c:forEach>
							<c:if test="${page.number < page.totalPages-1}">
								<li class="page-item"><a class="page-link"
									href="/admin/mh/index?field=${field}&p=${page.number + 1}"
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