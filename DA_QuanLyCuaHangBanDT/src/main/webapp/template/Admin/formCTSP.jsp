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
                            <h5 class="card-title">Thêm Sản Phẩm</h5>

                            <!-- Horizontal Form -->
                            <form:form action="/admin/ctsp/index" modelAttribute="item" enctype="multipart/form-data">
                                <form:hidden path="maSP" />
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-3 col-form-label">Màu Sắc</label>
                                    <div class="col-sm-9">
                                       <form:select path="maMau.mauSac" class="form-select">
												<form:options items="${list_m}" />
										</form:select>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-3 col-form-label">Dung Lượng</label>
                                    <div class="col-sm-9 ">
                                        <div class="">
                                            <form:select path="maDL.dungLuong" class="form-select">
												<form:options items="${list_dl}" />
											</form:select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-3 col-form-label">RAM</label>
                                    <div class="col-sm-9 ">
                                        <div class="">
                                            <form:select path="maRam.ram" class="form-select">
												<form:options items="${list_r}" />
											</form:select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-3 col-form-label">Số Lượng</label>
                                    <div class="col-sm-9 ">
                                        <form:input path="soluong" type="text" class="form-control" />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-3 col-form-label">Giá</label>
                                    <div class="col-sm-9 ">
                                        <form:input path="gia" type="text" class="form-control" />
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-3 col-form-label">Hình</label>
                                    <div class="col-sm-9 row">
                                        <input class="col-md-9" type="file" class="form-control" id="inputText" name="images[]" multiple>
                                        <button class="col-md-3" type="button" onclick="uploadImages()">Tải lên</button>
                                    </div>
                                </div>
                                <div class="text-center">
                                   <button formaction="/admin/ctsp/create" class="btn btn-primary">Create</button>
                                    <button formaction="/admin/ctsp/update" class="btn btn-primary">Update</button>
                                    <button type="reset" class="btn btn-secondary">Reset</button>
                                </div>
                           </form:form><!-- End Horizontal Form -->

                        </div>
                    </div>


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