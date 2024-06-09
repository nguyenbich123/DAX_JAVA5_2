<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/template/Admin/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Quản lý Acccount</title>
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
			<h1>Account</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item">Admin</li>
					<li class="breadcrumb-item active">Account</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Quản Lý Account</h5>

							<!-- Table with stripped rows -->
							<table class="table datatable">
								<thead>
									<tr>
										<th><a href="/admin/account/index?field=tenDN">Tên Đăng Nhập</a></th>
										<th><a href="/admin/account/index?field=hoTen">Họ Tên</a></th>
										<th><a href="/admin/account/index?field=sdt">Số Điện Thoại</a></th>
										<th><a href="/admin/account/index?field=email">Email</a></th>
										<th>Ảnh</th>
										<th><a href="/admin/account/index?field=role">Role</a></th>
										<th><a href="/admin/account/index?field=tthd">Trạng Thái</a></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${page.content}">
										<tr>
											<td>${item.tenDN}</td>
											<td>${item.hoTen}</td>
											<td>${item.sdt}</td>
											<td>${item.email}</td>
											<td><img src="/template/Admin/assets/img/${item.img}"
												alt=""></td>
											<td>${item.role.roles}</td>
											<td>${item.tthd.trangThai}</td>
											<td>
												<div class="icon">
													<a href="/admin/account/edit/${item.tenDN}"><i
														class="bi bi-pencil-fill"></i></a> <a
														href="/admin/account/delete/${item.tenDN}"><i
														class="ri-delete-bin-5-fill"></i></a>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- End Table with stripped rows -->
							<c:forEach begin="1" end="${page.totalPages}" step="1" var="number">
								<a href="/admin/account/index?field=${field}&p=${number-1}">${number}</a>
							</c:forEach>
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