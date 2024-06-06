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
			<h1>Tính Năng Cam Trước</h1>
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
							<h5 class="card-title">Tính Năng Cam Trước</h5>
							<h5 class="card-title"></h5>
							<!-- Horizontal Form -->
							<form:form action="/admin/tnct/index" modelAttribute="item"
								enctype="multipart/form-data">
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">Mã
										Tính Năng</label>
									<div class="col-sm-9">
										<div class="row">
											<div class="col-md-4">
												<div id="inputState" class="d-flex align-items-center">

													<form:input path="idTNCT" type="text" class="form-control" />


												</div>
											</div>

										</div>
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">Tính năng cam trước</label>
									<div class="col-sm-9">
										<div class="row">
											<div class="col-md-4">
												<div id="inputState" class="d-flex align-items-center">

													<form:input path="tinhNang" type="text" class="form-control" />


												</div>
											</div>

										</div>
									</div>
								</div>
								<div class="text-center">
									<button formaction="/admin/tnct/create"
										class="btn btn-primary">Create</button>
									<button formaction="/admin/tnct/update"
										class="btn btn-primary">Update</button>
									<button type="reset" class="btn btn-secondary">Reset</button>
								</div>
							</form:form>
							<!-- End Horizontal Form -->

						</div>
					</div>
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Tính Năng Cam Trước</h5>
							<!-- Table with stripped rows -->
							<table class="table datatable">
								<thead>
									<tr>
										<th><a href="/admin/tnct/index?field=idTNCT">Mã tính năng </a></th>
										<th><a href="/admin/tnct/index?field=tinhNang">Tính năng Cam</a></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}">
										<tr>
											<td>${item.idTNCT}</td>
											<td>${item.tinhNang}</td>
											<td>
												<div class="icon">
													<a href="/admin/tnct/edit/${item.idTNCT}"><i
														class="bi bi-pencil-fill"></i></a> <a
														href="/admin/tnct/delete/${item.idTNCT}"><i
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
      <li class="page-item">
        <a class="page-link" href="/admin/tnct/index?field=${field}&p=${page.number - 1}" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
    </c:if>
    <c:forEach begin="1" end="${page.totalPages}" step="1" var="number">
      <li class="page-item <c:if test="${number == page.number +1}">active</c:if>">
        <a class="page-link" href="/admin/tnct/index?field=${field}&p=${number - 1}">${number}</a>
      </li>
    </c:forEach>
    <c:if test="${page.number < page.totalPages}">
      <li class="page-item">
        <a class="page-link" href="/admin/tnct/index?field=${field}&p=${page.number + 1}" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
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