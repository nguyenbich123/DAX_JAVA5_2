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
			<h1>Dung Lượng Pin</h1>
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
							<h5 class="card-title">Dung Lương Pin</h5>
							<h5 class="card-title"></h5>
							<!-- Horizontal Form -->
							<form:form action="/admin/dlp/index" modelAttribute="item"
								enctype="multipart/form-data">
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">Mã
										DL Pin</label>
									<div class="col-sm-9">
										<div class="row">
											<div class="col-md-4">
												<div id="inputState" class="d-flex align-items-center">

													<form:input path="idDLP" type="text" class="form-control" />


												</div>
											</div>

										</div>
									</div>
								</div>
								<div class="row mb-3">
									<label for="inputPassword3" class="col-sm-3 col-form-label">Dung lượng pin</label>
									<div class="col-sm-9">
										<div class="row">
											<div class="col-md-4">
												<div id="inputState" class="d-flex align-items-center">

													<form:input path="dlPin" type="text" class="form-control" />


												</div>
											</div>

										</div>
									</div>
								</div>
								<div class="text-center">
									<button formaction="/admin/dlp/create"
										class="btn btn-primary">Create</button>
									<button formaction="/admin/dlp/update"
										class="btn btn-primary">Update</button>
									<button type="reset" class="btn btn-secondary">Reset</button>
								</div>
							</form:form>
							<!-- End Horizontal Form -->

						</div>
					</div>
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Dung Lượng Pin</h5>
							<!-- Table with stripped rows -->
							<table class="table datatable">
								<thead>
									<tr>
										<th><a href="/admin/dlp/index?field=idDLP">Mã DL Pin </a></th>
										<th><a href="/admin/dlp/index?field=dlPin">Dung lượng Pin</a></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}">
										<tr>
											<td>${item.idDLP}</td>
											<td>${item.dlPin}</td>
											<td>
												<div class="icon">
													<a href="/admin/dlp/edit/${item.idDLP}"><i
														class="bi bi-pencil-fill"></i></a> <a
														href="/admin/dlp/delete/${item.idDLP}"><i
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
        <a class="page-link" href="/admin/dlp/index?field=${field}&p=${page.number - 1}" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
    </c:if>
    <c:forEach begin="1" end="${page.totalPages}" step="1" var="number">
      <li class="page-item <c:if test="${number == page.number +1}">active</c:if>">
        <a class="page-link" href="/admin/dlp/index?field=${field}&p=${number - 1}">${number}</a>
      </li>
    </c:forEach>
    <c:if test="${page.number < page.totalPages}">
      <li class="page-item">
        <a class="page-link" href="/admin/dlp/index?field=${field}&p=${page.number + 1}" aria-label="Next">
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