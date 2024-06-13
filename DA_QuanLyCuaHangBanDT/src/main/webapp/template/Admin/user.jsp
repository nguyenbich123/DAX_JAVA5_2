<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/template/Admin/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Users / Profile - NiceAdmin Bootstrap Template</title>
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
			<h1>Profile</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
					<li class="breadcrumb-item">Users</li>
					<li class="breadcrumb-item active">Profile</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section profile">
			<div class="row">
				<div class="col-xl-4">

					<div class="card">
						<div
							class="card-body profile-card pt-4 d-flex flex-column align-items-center">

							<img src="/images/${item.img}" alt="Profile"
								class="rounded-circle">
							<h2>${item.hoTen}</h2>
						</div>
					</div>

				</div>

				<div class="col-xl-8">

					<div class="card">
						<div class="card-body pt-3">
							<!-- Bordered Tabs -->
							<ul class="nav nav-tabs nav-tabs-bordered">

								<li class="nav-item">
									<button class="nav-link active" data-bs-toggle="tab"
										data-bs-target="#profile-overview">Thông Tin</button>
								</li>

								<li class="nav-item">
									<button class="nav-link" data-bs-toggle="tab"
										data-bs-target="#profile-edit">Chỉnh Sửa Thông Tin</button>
								</li>

								<li class="nav-item">
									<button class="nav-link" data-bs-toggle="tab"
										data-bs-target="#profile-change-password">Đỗi Mật
										Khẩu</button>
								</li>

								<li class="nav-item">
									<button class="nav-link" data-bs-toggle="tab"
										data-bs-target="#profile-address">Địa Chỉ</button>
								</li>
							</ul>
							<div class="tab-content pt-2">

								<div class="tab-pane fade show active profile-overview"
									id="profile-overview">

									<h5 class="card-title">Thông Tin Cá Nhân</h5>

									<div class="row">
										<div class="col-lg-3 col-md-4 label ">Họ và Tên</div>
										<div class="col-lg-9 col-md-8">${item.hoTen}</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">Số Điện Thoại</div>
										<div class="col-lg-9 col-md-8">${item.sdt}</div>
									</div>

									<div class="row">
										<div class="col-lg-3 col-md-4 label">Email</div>
										<div class="col-lg-9 col-md-8">${item.email}</div>
									</div>

								</div>

								<div class="tab-pane fade profile-edit pt-3" id="profile-edit">

									<!-- Profile Edit Form -->
									<form:form action="/admin/user/index" modelAttribute="item"
										enctype="multipart/form-data">
										<div class="row mb-3">
											<label for="profileImage"
												class="col-md-4 col-lg-3 col-form-label">Hình Ảnh</label>
											<div class="col-md-8 col-lg-9">
												<input type="file" name="photo_file">
											</div>
										</div>
										<form:hidden path="tenDN" />
										<form:hidden path="matKhau" />
										<form:hidden path="img" />
										<form:hidden path="role.Idrole" />
										<form:hidden path="tthd.Idtthd" />
										<div class="row mb-3">
											<label for="fullName"
												class="col-md-4 col-lg-3 col-form-label">Họ và Tên</label>
											<div class="col-md-8 col-lg-9">
												<form:input path="hoTen" type="text" class="form-control" />
											</div>
										</div>

										<div class="row mb-3">
											<label for="Phone" class="col-md-4 col-lg-3 col-form-label">Số
												Điện Thoại</label>
											<div class="col-md-8 col-lg-9">
												<form:input path="sdt" type="text" class="form-control" />
											</div>
										</div>

										<div class="row mb-3">
											<label for="Email" class="col-md-4 col-lg-3 col-form-label">Email</label>
											<div class="col-md-8 col-lg-9">
												<form:input path="email" type="email" class="form-control" />
											</div>
										</div>

										<div class="text-center">
											<button formaction="/admin/user/update"
												class="btn btn-primary">Save</button>
										</div>
									</form:form>
									<!-- End Profile Edit Form -->

								</div>

								<div class="tab-pane fade pt-3" id="profile-change-password">
									<!-- Change Password Form -->
									<form:form action="/admin/user/index" modelAttribute="pass"
										enctype="multipart/form-data">
										<div class="row mb-3">
											<label for="currentPassword"
												class="col-md-4 col-lg-3 col-form-label">Mật khẩu củ</label>
											<div class="col-md-8 col-lg-9">
												<form:input path="opass" type="password"
													class="form-control" />
											</div>
										</div>

										<div class="row mb-3">
											<label for="newPassword"
												class="col-md-4 col-lg-3 col-form-label">Mật khẩu
												mới</label>
											<div class="col-md-8 col-lg-9">
												<form:input path="npass" type="password"
													class="form-control" />
											</div>
										</div>

										<div class="row mb-3">
											<label for="renewPassword"
												class="col-md-4 col-lg-3 col-form-label">Xác nhận
												mật khẩu</label>
											<div class="col-md-8 col-lg-9">
												<form:input path="cfpass" type="password"
													class="form-control" />
											</div>
										</div>
										<div class="text-center">
											<button formaction="/admin/user/updatemk"
												class="btn btn-primary">Save</button>
										</div>
									</form:form>
									<!-- End Change Password Form -->

								</div>

								<div class="tab-pane fade pt-3" id="profile-address">
									Địa Chỉ

									<table class="table datatable">
										<thead>
											<tr>
												<th><b>Đ</b>ường, Số nhà</th>
												<th>Xã , Phường , Thị Trấn</th>
												<th>Quận , Huyện</th>
												<th>Tỉnh , Thành Phố</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="diachi" items="${items}">
												<tr>
													<td>${diachi.duong_Sonha}</td>
													<td>${diachi.xa_Phuong_Thitran}
														<p id="wardName"></p>
													</td>
													<td>${diachi.quan_Huyen}
														<p id="districtName"></p>
													</td>
													<td>${diachi.tinh_ThanhPho}
														<p id="provinceName"></p>
													</td>
													<td>
														<div class="icon">
															<a
																href="/admin/user/viewdc?id_diaChi=${diachi.id_diaChi}"><i
																class="bi bi-pencil-fill"></i></a> <a
																href="/admin/user/deletedc?id_diaChi=${diachi.id_diaChi}"><i
																class="ri-delete-bin-5-fill"></i></a>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<br>
									<h5 class="card-title">Thêm Địa Chỉ Mới</h5>
									<!-- Địa chỉ  Form -->
									<form:form action="/admin/user/viewdc" modelAttribute="diachi">

										<form:hidden path="id_diaChi" />

										<div class="row mb-3">
											<label for="Address3"
												class="col-md-4 col-lg-3 col-form-label">Tỉnh Thành
												Phố</label>
											<div class="col-md-8 col-lg-9">
												<form:select id="province" class="form-control"
													path="tinh_ThanhPho" onchange="fetchDistricts()">
													<option value="${diachi.tinh_ThanhPho}"></option>
												</form:select>
											</div>
										</div>

										<div class="row mb-3">
											<label for="Address2"
												class="col-md-4 col-lg-3 col-form-label">Quận Huyện</label>
											<div class="col-md-8 col-lg-9">
												<form:select id="district" class="form-control"
													path="quan_Huyen" onchange="fetchWards()">
													<option value="${diachi.quan_Huyen}"></option>
												</form:select>

											</div>
										</div>

										<div class="row mb-3">
											<label for="Address2"
												class="col-md-4 col-lg-3 col-form-label">Xã Phường
												Thị Trấn</label>
											<div class="col-md-8 col-lg-9">
												<form:select id="ward" class="form-control"
													path="xa_Phuong_Thitran">
													<option value="${diachi.xa_Phuong_Thitran}"></option>
												</form:select>
											</div>
										</div>

										<div class="row mb-3">
											<label for="Address"
												class="col-md-4 col-lg-3  col-form-label">Đường Số
												Nhà</label>
											<div class="col-md-8 col-lg-9">
												<form:input path="duong_Sonha" type="text"
													class="form-control" />
											</div>
										</div>

										<div class="text-center">
											<button formaction="/admin/user/updatedc"
												class="btn btn-primary">Save</button>
										</div>
									</form:form>
									<!--địa chỉ Form -->

								</div>
							</div>
							<!-- End Bordered Tabs -->

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

	<script>
        const token = '3d21e6d4-2862-11ef-8e53-0a00184fe694';  // Thay thế bằng token thực
        const shopId = '192569';  // Thay thế bằng shop ID thực
        
       
       
        	const provinceId = ${diachi.tinh_ThanhPho};  // ID của tỉnh muốn lấy tên
            const districtId = ${diachi.quan_Huyen};  // ID của quận/huyện muốn lấy tên
            const wardId = ${diachi.xa_Phuong_Thitran};  // ID của phường/xã muốn lấy tên
            
            document.addEventListener("DOMContentLoaded", function() {
                fetchProvinces();		      	        	
                
	
                fetchProvinceNameById(provinceId)
                .then(provinceName => {
                    document.getElementById('provinceName').textContent = provinceName;
                })
                .catch(error => {
                    console.error('Error:', error);
                });

            fetchDistrictNameById(districtId)
                .then(districtName => {
                    document.getElementById('districtName').textContent = districtName;
                })
                .catch(error => {
                    console.error('Error:', error);
                });

            fetchWardNameById(wardId)
                .then(wardName => {
                    document.getElementById('wardName').textContent = wardName;
                })
                .catch(error => {
                    console.error('Error:', error);
                });
            });
        
		
		// Hàm lấy tên tỉnh/thành phố theo ID
        function fetchProvinceNameById(provinceId) {
            return fetch('https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/province', {
                headers: {
                    'Content-Type': 'application/json',
                    'Token': token
                }
            })
            .then(response => response.json())
            .then(data => {
                const province = data.data.find(province => province.ProvinceID === provinceId);
                if (province) {
                	//provinceId = province.ProvinceID; // Lưu lại ID tỉnh/thành phố
                	//document.getElementById('tinh_ThanhPho').value = provinceId;
                    return province.ProvinceName;
                } else {
                    throw new Error('Province not found');
                }
            })
            .catch(error => {
                console.error('Error fetching province name:', error);
                throw error;
            });
        }

        // Hàm lấy tên quận/huyện theo ID
        function fetchDistrictNameById(districtId) {
            return fetch('https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/district?province_id='+provinceId+'&shop_id='+shopId, {
                headers: {
                    'Content-Type': 'application/json',
                    'Token': token
                }
            })
            .then(response => response.json())
            .then(data => {
                const district = data.data.find(district => district.DistrictID === districtId);
                if (district) {
                	//districtId = district.DistrictID; // Lưu lại ID quận/huyện
                	//document.getElementById('quan_Huyen').value = districtId;
                    return district.DistrictName;
                } else {
                    throw new Error('District not found');
                }
            })
            .catch(error => {
                console.error('Error fetching district name:', error);
                throw error;
            });
        }

        // Hàm lấy tên phường/xã theo ID
        function fetchWardNameById(wardId) {
            return fetch('https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id='+districtId+'&shop_id='+shopId, {
            	headers: {
                    'Content-Type': 'application/json',
                    'Token': token
                }
            })
            .then(response => response.json())
            .then(data => {
                const ward = data.data.find(ward => ward.WardCode === wardId);
                if (ward) {
                	//wardId = ward.wardId; // Lưu lại ID phường/xã
                	//document.getElementById('xa_Phuong_Thitran').value = wardId;
                    return ward.WardName;
                } else {
                    throw new Error('Ward not found');
                }
            })
            .catch(error => {
                console.error('Error fetching ward name:', error);
                throw error;
            });
        }
	
        // hàm để fill select option province 
        function fetchProvinces() {
            fetch('https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/province', {
                headers: {
                    'Content-Type': 'application/json',
                    'Token': token
                }
            })
            .then(response => response.json())
            .then(data => {
                const provinceSelect = document.getElementById('province');
                const sortedProvinces = data.data.sort((a, b) => a.ProvinceName.localeCompare(b.ProvinceName));
                sortedProvinces.forEach(province => {
                    const option = document.createElement('option');
                    option.value = province.ProvinceID;
                    option.textContent = province.ProvinceName;
                    provinceSelect.appendChild(option);
                });
            })
            .catch(error => console.error('Error fetching provinces:', error));
        }

        // hàm để fill select option district 
        function fetchDistricts() {
            const provinceId = document.getElementById('province').value;
            if (!provinceId) return;

            fetch('https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/district?province_id='+provinceId+'&shop_id='+shopId, {
                headers: {
                    'Content-Type': 'application/json',
                    'Token': token
                }
            })
            .then(response => response.json())
            .then(data => {
                const districtSelect = document.getElementById('district');
                districtSelect.innerHTML = '<option value="">Chọn Quận/Huyện</option>';
                const wardSelect = document.getElementById('ward');
                wardSelect.innerHTML = '<option value="">Chọn Phường/Xã</option>';
                const sortedDistricts = data.data.sort((a, b) => a.DistrictName.localeCompare(b.DistrictName));
                sortedDistricts.forEach(district => {
                    const option = document.createElement('option');
                    option.value = district.DistrictID;
                    option.textContent = district.DistrictName;
                    districtSelect.appendChild(option);
                });
            })
            .catch(error => console.error('Error fetching districts:', error));
        }
		
     // hàm để fill select option ward 
        function fetchWards() {
            const districtId = document.getElementById('district').value;
            if (!districtId) return;

            fetch('https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id='+districtId+'&shop_id='+shopId, {
                headers: {
                    'Content-Type': 'application/json',
                    'Token': token
                }
            })
            .then(response => response.json())
            .then(data => {
                const wardSelect = document.getElementById('ward');
                wardSelect.innerHTML = '<option value="">Chọn Phường/Xã</option>';
                const sortedWards = data.data.sort((a, b) => a.WardName.localeCompare(b.WardName));
                sortedWards.forEach(ward => {
                    const option = document.createElement('option');
                    option.value = ward.WardCode;
                    option.textContent = ward.WardName;
                    wardSelect.appendChild(option);
                });
            })
            .catch(error => console.error('Error fetching wards:', error));
        }
     
     // hàm để fill lên form 
      function fillform(diachi) {
	 
     }
		
    </script>
</body>

</html>