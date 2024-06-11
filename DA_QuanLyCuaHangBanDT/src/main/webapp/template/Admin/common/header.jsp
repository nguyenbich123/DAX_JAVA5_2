<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header id="header" class="header fixed-top d-flex align-items-center">

	<div class="d-flex align-items-center justify-content-between">
		<a href="/admin/home/view" class="logo d-flex align-items-center"> <img
			src="/template/Admin/assets/img/logo.png" alt=""> <span
			class="d-none d-lg-block">Admin</span>
		</a> <i class="bi bi-list toggle-sidebar-btn"></i>
	</div>
	<!-- End Logo -->



	<nav class="header-nav ms-auto">
		<ul class="d-flex align-items-center">
			<li class="nav-item dropdown pe-3"><a
				class="nav-link nav-profile d-flex align-items-center pe-0" href="#"
				data-bs-toggle="dropdown"> <img src="/images/<c:if test="${account != null}">${account.img}</c:if>" alt="Profile"
					class="rounded-circle"> <span
					class="d-none d-md-block dropdown-toggle ps-2"><c:if test="${account != null}">
								   ${account.hoTen}
							  </c:if></span>
			</a> <!-- End Profile Iamge Icon -->

				<ul
					class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
					<li class="dropdown-header">
						<h6><c:if test="${account != null}">
								   ${account.hoTen}
							  </c:if></h6> <span><c:if test="${account != null}">
								   ${account.role.roles}
							  </c:if></span>
					</li>
					<li>
						<hr class="dropdown-divider">
					</li>

					<li><a class="dropdown-item d-flex align-items-center"
						href="/admin/user/view/men0ngu"> <i class="bi bi-person"></i> <span>My
								Profile</span>
					</a></li>
					<li>
						<hr class="dropdown-divider">
					</li>
					<li><a class="dropdown-item d-flex align-items-center"
						href="/account/logout"> <i class="bi bi-box-arrow-right"></i> <span>Sign
								Out</span>
					</a></li>

				</ul> <!-- End Profile Dropdown Items --></li>
			<!-- End Profile Nav -->

		</ul>
	</nav>
	<!-- End Icons Navigation -->

</header>
<!-- End Header -->