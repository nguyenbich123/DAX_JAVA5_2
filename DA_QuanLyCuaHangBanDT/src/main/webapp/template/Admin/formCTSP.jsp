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
            <h1>Form Điện Thoại</h1>
            <nav>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
                    <li class="breadcrumb-item">Forms</li>
                    <li class="breadcrumb-item active">Layouts</li>
                </ol>
            </nav>
        </div><!-- End Page Title -->
        <section class="section">
            <div class="row">
                <div class="col-lg-12">

                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Form Sản Phẩm</h5>

                            <!-- Horizontal Form -->
                            <form:form action="/admin/ctsp/index" modelAttribute="ctsp" enctype="multipart/form-data">
                                
                              	<form:hidden path="maCTSP" />
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-3 col-form-label">Màu Sắc</label>
                                    <div class="col-sm-9">
                                       <form:select path="maMau" class="form-select">
                                       <form:option value="">--Chọn Màu Sắc--</form:option>
												<form:options items="${list_m}" />
										</form:select>
										<form:errors path="maMau" cssClass="text-danger" />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-3 col-form-label">Dung Lượng</label>
                                    <div class="col-sm-9 ">
                                            <form:select path="maDL" class="form-select">
                                            <form:option value="">--Chọn Dung Lượng--</form:option>
												<form:options items="${list_dl}" />
											</form:select>
											<form:errors path="maDL" cssClass="text-danger" />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-3 col-form-label">RAM</label>
                                    <div class="col-sm-9 ">   
                                            <form:select path="maRam" class="form-select">
                                              <form:option value="">--Chọn Ram--</form:option>
												<form:options items="${list_r}" />
											</form:select>
											<form:errors path="maRam" cssClass="text-danger" />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-3 col-form-label">Số Lượng</label>
                                    <div class="col-sm-9 ">
                                        <form:input path="soluong" type="text" class="form-control" />
                                        <form:errors path="soluong" cssClass="text-danger" />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-3 col-form-label">Giá</label>
                                    <div class="col-sm-9 ">
                                        <form:input path="gia" type="text" class="form-control" />
                                        <form:errors path="gia" cssClass="text-danger" />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-3 col-form-label">Hình</label>
                                    <div class="col-sm-9 row">                          
                                       <input type="file" name="photo_file">
                                       <form:hidden path="img" />
                                    </div>
                                </div>
                                <div class="text-center">
                                    <button formaction="/admin/ctsp/update?maSP=${maSP}" class="btn btn-primary">Lưu</button>
                                    <button type="reset" class="btn btn-secondary">Làm Mới</button>
                                </div>
                           </form:form><!-- End Horizontal Form -->

                        </div>
                    </div>

				${err}
                </div>
            </div>
        </section>

    </main><!-- End #main -->

    <!-- ======= Footer ======= -->
  <%@ include file="/template/Admin/common/footer.jsp"%>

	<!-- JS Files -->
	<%@ include file="/template/Admin/common/jsfile.jsp"%>
</body>

</html>