<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/template/Admin/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Tables / Data - NiceAdmin Bootstrap Template</title>
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
			<h1>Sản Phẩm</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item">Tables</li>
					<li class="breadcrumb-item active">Data</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Chi Tiết Sản Phẩm</h5>

							<!-- Table with stripped rows -->
							<table class="table datatable">
								<thead>
									<tr>
										<th><a href="/admin/ctsp/index/${maSP}?field=maCTSP">Mã
												Chi Tiết Sản Phẩm</a></th>
										<th><a href="/admin/ctsp/index/${maSP}?field=maMau">Màu
												sắc</a></th>
										<th><a href="/admin/ctsp/index/${maSP}?field=maDL">Dung
												Lượng</a></th>
										<th><a href="/admin/ctsp/index/${maSP}?field=maRam">RAM</a></th>
										<th><a href="/admin/ctsp/index/${maSP}?field=soluong">Số
												Lượng</a></th>
										<th><a href="/admin/ctsp/index/${maSP}?field=gia">Giá</a></th>
										<th>Hình</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}">
										<tr>
											<td>${item.maCTSP}</td>
											<td>${item.maMau.mauSac}</td>
											<td>${item.maDL.dungLuong}</td>
											<td>${item.maRam.ram}</td>
											<td>${item.soluong}</td>
											<td><fmt:formatNumber value="${item.gia}" pattern="#,###đ" /></td>
											<td><img src="/images/${item.img}" width="90%" height="100px"></td>
											<td>
												<div class="icon">
													<a href="/admin/ctsp/edit/${item.maCTSP}?maSP=${maSP}"><i
														class="bi bi-pencil-fill"></i></a> <a
														href="/admin/ctsp/delete/${item.maCTSP}?maSP=${maSP}"><i
														class="ri-delete-bin-5-fill"></i></a>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- End Table with stripped rows -->
							<div class="text-center">
								<button>
									<a href="/admin/ctsp/add?maSP=${maSP}" class="btn btn-primary">thêm
										mới </a>
								</button>
							</div>
						</div>
					</div>
					<nav aria-label="Page navigation">
						<ul class="pagination justify-content-center">

							<c:if test="${page.number > 0}">
								<li class="page-item"><a class="page-link"
									href="/admin/ctsp/index?field=${field}&p=${page.number - 1}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:if>
							<c:forEach begin="1" end="${page.totalPages}" step="1"
								var="number">
								<li
									class="page-item <c:if test="${number == page.number +1}">active</c:if>">
									<a class="page-link"
									href="/admin/ctsp/index?field=${field}&p=${number - 1}">${number}</a>
								</li>
							</c:forEach>
							<c:if test="${page.number < page.totalPages-1}">
								<li class="page-item"><a class="page-link"
									href="/admin/ctsp/index?field=${field}&p=${page.number + 1}"
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