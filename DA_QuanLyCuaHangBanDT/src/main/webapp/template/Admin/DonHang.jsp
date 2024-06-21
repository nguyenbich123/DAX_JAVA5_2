<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/template/Admin/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Quản lý Đơn Hàng</title>
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
			<h1>Quản Lý Đơn Hàng</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item">Admin</li>
					<li class="breadcrumb-item active">Đơn Hàng</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Quản Lý Đơn Hàng</h5>

							<!-- Table with stripped rows -->
							<table class="table datatable">
								<thead>
									<tr>
										<th><a href="/admin/donhang/index?field=maDH">Mã Đơn
												Hàng</a></th>
										<th><a href="/admin/donhang/index?field=ngayTT">Ngày
												Đặt Hàng</a></th>
										<th><a href="/admin/donhang/index?field=maPT">Phương
												Thức Thanh Toán</a></th>
										<th><a href="/admin/donhang/index?field=tongTien">Thành
												Tiền</a></th>
										<th><a href="/admin/donhang/index?field=ttdh">Trạng
												Thái Đơn</a></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="dh" items="${page.content}">
										<tr>
											<td>${dh.maDH}</td>
											<td>${dh.ngayTT}</td>
											<td>${dh.maPT.tenPT}</td>
											<td><fmt:formatNumber value="${dh.tongTien}"
													pattern="#,### ₫" /></td>
											<td style="">${dh.ttdh.trangThai}</td>
											<td>
												<div class="icon">
													<a href="#" data-bs-toggle="modal"
														data-bs-target="#exampleModal-${dh.maDH}"><i
														class="bi bi-pencil-fill"></i>Chi Tiết</a>
												</div>
											</td>
											<!-- Modal -->
											<div class="modal fade" id="exampleModal-${dh.maDH}" tabindex="-1"
												aria-labelledby="exampleModalLabel-${dh.maDH}" aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel-${dh.maDH}">Thông
																tin chi tiết đơn hàng</h5>
															<button type="button" class="btn-close"
																data-bs-dismiss="modal" aria-label="Close"></button>
														</div>
														<div class="modal-body">
															<p>Mã đơn: ${dh.maDH}</p>
															<div class="row">
																<c:forEach var="ctdh"
																	items="${chiTietDonHangMap[dh.maDH]}">
																	<div class="d-flex row align-items-center">
																		<div class="col-md-3">
																			<a
																				href="/product/product-detail/${ctdh.maCTSP.maCTSP}">
																				<img src="/images/${ctdh.maCTSP.img}" alt=""
																				width="50" />
																			</a>
																		</div>
																		<div class="col-md-4">
																			<b>${ctdh.maCTSP.maSP.tenSP}</b> Màu:
																			${ctdh.maCTSP.maMau.mauSac}
																		</div>
																		<div class="col-md-3">
																			<b> <fmt:formatNumber value="${ctdh.maCTSP.gia}"
																					pattern="#,###đ" />
																			</b>
																			<!-- <span class="color-circle"style="background-color: black;"></span> -->
																		</div>
																		<div class="col-md-2">x${ctdh.soLuong}</div>
																	</div>
																	<div>
																		<span>${ct.maCTSP.maSP.tenSP}</span>
																		
																		<%-- <c:choose>
																			<c:when test="${danhGiaMap[ct.id_CTDH]}">
																				<button>Đánh giá sản phẩm</button>
																			</c:when>
																			<c:otherwise>
																				<span class="text-danger">Bạn chưa mua sản
																					phẩm này nên không thể đánh giá</span>
																			</c:otherwise>
																		</c:choose> --%>
																	</div>
																</c:forEach>
															</div>
															<hr>
															<div class="row">
																<div class="col-md-6">
																	<h6>Tổng quan đơn hàng</h6>
																	<div>
																		Tổng tiền:
																		<fmt:formatNumber value="${dh.tongTien}"
																			pattern="#,###đ" />
																	</div>
																	
																	<div>
																		Giảm giá:
																		<fmt:formatNumber value="${dh.maGG.giamGia * dh.tongTien}"
																			pattern="#,###đ" />
																	</div>
																	<b>Thành tiền: <fmt:formatNumber
																			value="${dh.tongTien}" pattern="#,###đ" />
																	</b>
																</div>
																<div class="col-md-6">
																	<h6>Chi tiết đơn hàng</h6>
																	<div>Tên khách hàng: ${dh.maKH.hoTen}</div>
																	<div>Số điện thoại: ${dh.maKH.sdt}</div>
																	<div>Địa chỉ: ${dh.diaChi}</div>
																	<div style="color: green;">
																		Ngày đặt hàng:
																		<fmt:parseDate value="${dh.ngayTT}"
																			pattern="yyyy-MM-dd HH:mm:ss.S" var="parsedDate" />
																		<fmt:formatDate value="${parsedDate}"
																			pattern="dd/MM/yyyy" />
																	</div>

																	<div style="color: green;">Phương thức thanh
																		toán: ${dh.maPT.tenPT}</div>
																	<div style="color: rgb(61, 59, 59);">Trạng thái
																		thanh toán: ${dh.tttt.trangThai}</div>
																</div>
															</div>
														</div>
														<form:form action="/admin/donhang/index" modelAttribute="">
														<div class="modal-footer">
														<c:if test="${dh.ttdh.trangThai == 'Chờ xác nhận'}">
																<button formaction="/admin/donhang/xn?maDH=${dh.maDH}" class="btn btn-success">Xác Nhận</button>					
														</c:if>
															
															<button formaction="/admin/donhang/huy?maDH=${dh.maDH}" class="btn btn-warning">Hủy</button>
															<button type="button" class="btn btn-secondary"
																data-bs-dismiss="modal">Đóng</button>
														</div>
														</form:form>
													</div>
												</div>
											</div>

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
									href="/admin/donhang/index?field=${field}&p=${page.number - 1}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:if>
							<c:forEach begin="1" end="${page.totalPages}" step="1"
								var="number">
								<li
									class="page-item <c:if test="${number == page.number +1}">active</c:if>">
									<a class="page-link"
									href="/admin/donhang/index?field=${field}&p=${number - 1}">${number}</a>
								</li>
							</c:forEach>
							<c:if test="${page.number < page.totalPages-1}">
								<li class="page-item"><a class="page-link"
									href="/admin/donhang/index?field=${field}&p=${page.number + 1}"
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