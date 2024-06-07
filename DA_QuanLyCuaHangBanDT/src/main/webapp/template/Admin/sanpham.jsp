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
							<h5 class="card-title">Sản Phẩm</h5>

							<!-- Table with stripped rows -->
							<table class="table datatable">
								<thead>
									<tr>
										<th><a href="/admin/sanpham/index?field=maSP">Mã Sản
												Phẩm</a></th>
										<th><a href="/admin/sanpham/index?field=tenSP"><b>T</b>ên
												Sản Phẩm</a></th>
										<th><a href="/admin/sanpham/index?field=maHang">Hãng
												sản xuất</a></th>
										<th><a href="/admin/sanpham/index?field=maHDH">Hệ
												điều hành</a></th>
										<th><a href="/admin/sanpham/index?field=chip">Chip</a></th>
										<th><a href="/admin/sanpham/index?field=manHinh">Màn
												hình</a></th>
										<th><a href="/admin/sanpham/index?field=pinSac">Pin</a></th>
										<th><a href="/admin/sanpham/index?field=pinSac">Hỗ
												Trợ Sạc</a></th>
										<th><a href="/admin/sanpham/index?field=sim">Sim</a></th>
										<th><a href="/admin/sanpham/index?field=camTruoc">Camera
												Trước</a></th>
										<th><a href="/admin/sanpham/index?field=camSau">Camera
												Sau</a></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}">
										<tr>
											<td>${item.maSP}</a></td>
											<td>${item.tenSP}</a></td>
											<td>${item.maHang.tenHang}</td>
											<td>${item.maHDH.tenHDH}</a></td>
											<td>${item.chip}</td>
											<td>${item.manHinh.CNMH.cnmh}${item.manHinh.MHR.mhRong}</td>
											<td>${item.pinSac.DLPin.dlPin}</td>
											<td>${item.pinSac.hoTroSac.hoTroSac}</td>
											<td>${item.sim}</td>
											<td>Độ phân giải : ${item.camTruoc.DPGCT.dpg} tính năng
												: ${item.camTruoc.TNCT.tinhNang}</td>
											<td>Độ phân giải : ${item.camSau.DPGCS.dpg} tính năng :
												${item.camSau.TNCS.tinhNang}</td>
											<td>
												<div class="icon">
													<a href="/admin/sanpham/edit/${item.maSP}"><i
														class="bi bi-pencil-fill"></i></a> <a
														href="/admin/sanpham/delete/${item.maSP}"><i
														class="ri-delete-bin-5-fill"></i></a>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="text-center">
								<button> <a href="/admin/sanpham/add" class="btn btn-primary">thêm mới </a></button>
							</div>


							<c:forEach begin="1" end="${page.totalPages}" step="1"
								var="number">
								<a href="/admin/sanpham/index?field=${field}&p=${number-1}">${number}</a>
							</c:forEach>

							<!-- End Table with stripped rows -->

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