<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/template/Admin/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Admin Tool</title>
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
			<h1>Trang chủ</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item active">Dashboard</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">

				<!-- Left side columns -->
				<div class="col-lg-8">
					<div class="row">

						<!-- Sales Card -->
						<div class="col-xxl-4 col-md-6">
							<div class="card info-card sales-card">

								<div class="filter">
									<a class="icon" href="#" data-bs-toggle="dropdown"><i
										class="bi bi-three-dots"></i></a>
									<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
										<li class="dropdown-header text-start">
											<h6>Filter</h6>
										</li>

										<li><a class="dropdown-item" href="/admin/home/view?BCTKDH=today">Today</a></li>
										<li><a class="dropdown-item" href="/admin/home/view?BCTKDH=month">This Month</a></li>
										<li><a class="dropdown-item" href="/admin/home/view?BCTKDH=year">This Year</a></li>
									</ul>
								</div>

								<div class="card-body">
									<h5 class="card-title">
										Đơn Hàng <span>| ${BCTKDH}</span>
									</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-cart"></i>
										</div>
										<div class="ps-3">
											<h6>${dhtk}</h6>
										</div>
									</div>
								</div>

							</div>
						</div>
						<!-- End Sales Card -->

						<!-- Revenue Card -->
						<div class="col-xxl-4 col-md-6">
							<div class="card info-card revenue-card">

								<div class="filter">
									<a class="icon" href="#" data-bs-toggle="dropdown"><i
										class="bi bi-three-dots"></i></a>
									<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
										<li class="dropdown-header text-start">
											<h6>Filter</h6>
										</li>

										<li><a class="dropdown-item" href="/admin/home/view?BCTKDT=today">Today</a></li>
										<li><a class="dropdown-item" href="/admin/home/view?BCTKDT=month">This Month</a></li>
										<li><a class="dropdown-item" href="/admin/home/view?BCTKDT=year">This Year</a></li>
									</ul>
								</div>

								<div class="card-body">
									<h5 class="card-title">
										Doanh Thu <span>| ${BCTKDT}</span>
									</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-currency-dollar"></i>
										</div>
										<div class="ps-3">
											<h6>${dttk} tr</h6>
										</div>
									</div>
								</div>

							</div>
						</div>
						<!-- End Revenue Card -->

						<!-- Customers Card -->
						<div class="col-xxl-4 col-xl-12">

							<div class="card info-card customers-card">

								<div class="filter">
									<a class="icon" href="#" data-bs-toggle="dropdown"><i
										class="bi bi-three-dots"></i></a>
									<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
										<li class="dropdown-header text-start">
											<h6>Filter</h6>
										</li>

										<li><a class="dropdown-item" href="/admin/home/view?BCTKKH=today">Today</a></li>
										<li><a class="dropdown-item" href="/admin/home/view?BCTKKH=month">This Month</a></li>
										<li><a class="dropdown-item" href="/admin/home/view?BCTKKH=year">This Year</a></li>
									</ul>
								</div>

								<div class="card-body">
									<h5 class="card-title">
										Khách Hàng <span>| ${BCTKKH}</span>
									</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-people"></i>
										</div>
										<div class="ps-3">
											<h6>${khtk}</h6>											
										</div>
									</div>

								</div>
							</div>

						</div>
						<!-- End Customers Card -->

						<!-- Reports -->
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<h5 class="card-title">
										Báo Cáo <span><a>/tháng này</a></span>
									</h5>

									<!-- Line Chart -->
									<div id="reportsChart"></div>

									<script>
									
                    document.addEventListener("DOMContentLoaded", () => {
                    	const datakh = ${datakh} ;
                    	const datadh = ${datadh} ;
                    	const datadt = ${datadt} ;
                    	const timedata = ${timedata} ; 
                    	
                      new ApexCharts(document.querySelector("#reportsChart"), {
                        series: [{
                          name: 'Đơn Hàng',
                          data: datadh.map(item => item),
                        }, {
                          name: 'Doanh Thu',
                          data: datadt.map(item => item),
                        }, {
                          name: 'Khách Hàng',
                          data: datakh.map(item => item),
                        }],
                        chart: {
                          height: 350,
                          type: 'area',
                          toolbar: {
                            show: false
                          },
                        },
                        markers: {
                          size: 4
                        },
                        colors: ['#4154f1', '#2eca6a', '#ff771d'],
                        fill: {
                          type: "gradient",
                          gradient: {
                            shadeIntensity: 1,
                            opacityFrom: 0.3,
                            opacityTo: 0.4,
                            stops: [0, 90, 100]
                          }
                        },
                        dataLabels: {
                          enabled: false
                        },
                        stroke: {
                          curve: 'smooth',
                          width: 2
                        },
                        xaxis: {
                          type: 'datetime',
                          categories: timedata.map(item => item),
                        },
                        tooltip: {
                          x: {
                            format: 'dd/MM/yyyy'
                          },
                        }
                      }).render();
                    });
                  </script>
									<!-- End Line Chart -->

								</div>

							</div>
						</div>
						<!-- End Reports -->

						<!-- Recent Sales -->


						<!-- Top Selling -->
						<!-- <div class="col-12">
							<div class="card top-selling overflow-auto">

								<div class="filter">
									<a class="icon" href="#" data-bs-toggle="dropdown"><i
										class="bi bi-three-dots"></i></a>
									<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
										<li class="dropdown-header text-start">
											<h6>Filter</h6>
										</li>
									</ul>
								</div>

								<div class="card-body pb-0">
									<h5 class="card-title">
										Top Sản Phẩm
									</h5>

									<table class="table table-borderless">
										<thead>
											<tr>
												<th scope="col">Xem Trước</th>
												<th scope="col">Sản Phẩm</th>
												<th scope="col">Giá</th>
												<th scope="col">Đã Bán</th>
												<th scope="col">Doanh Thu</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th scope="row"><a href="#"><img
														src="/template/Admin/assets/img/product-1.jpg" alt=""></a></th>
												<td><a href="#" class="text-primary fw-bold">Ut
														inventore ipsa voluptas nulla</a></td>
												<td>$64</td>
												<td class="fw-bold">124</td>
												<td>$5,828</td>
											</tr>
											<tr>
												<th scope="row"><a href="#"><img
														src="/template/Admin/assets/img/product-2.jpg" alt=""></a></th>
												<td><a href="#" class="text-primary fw-bold">Exercitationem
														similique doloremque</a></td>
												<td>$46</td>
												<td class="fw-bold">98</td>
												<td>$4,508</td>
											</tr>
											<tr>
												<th scope="row"><a href="#"><img
														src="/template/Admin/assets/img/product-3.jpg" alt=""></a></th>
												<td><a href="#" class="text-primary fw-bold">Doloribus
														nisi exercitationem</a></td>
												<td>$59</td>
												<td class="fw-bold">74</td>
												<td>$4,366</td>
											</tr>
											<tr>
												<th scope="row"><a href="#"><img
														src="/template/Admin/assets/img/product-4.jpg" alt=""></a></th>
												<td><a href="#" class="text-primary fw-bold">Officiis
														quaerat sint rerum error</a></td>
												<td>$32</td>
												<td class="fw-bold">63</td>
												<td>$2,016</td>
											</tr>
											<tr>
												<th scope="row"><a href="#"><img
														src="/template/Admin/assets/img/product-5.jpg" alt=""></a></th>
												<td><a href="#" class="text-primary fw-bold">Sit
														unde debitis delectus repellendus</a></td>
												<td>$79</td>
												<td class="fw-bold">41</td>
												<td>$3,239</td>
											</tr>
										</tbody>
									</table>

								</div>

							</div>
						</div>
						End Top Selling -->

					</div>
				</div>
				<!-- End Left side columns -->

				<!-- Right side columns -->
				<div class="col-lg-4">

					

				</div>
				<!-- End Right side columns -->

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