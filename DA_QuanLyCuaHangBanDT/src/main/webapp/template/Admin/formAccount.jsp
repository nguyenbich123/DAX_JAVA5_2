<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/Admin/common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Forms / Quản Lý Acccount</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

   <%@ include file="/template/Admin/common/head.jsp" %>
</head>

<body>

    <!-- ======= Header ======= -->
    <%@ include file="/template/Admin/common/header.jsp" %>

    <!-- ======= Sidebar ======= -->
    <%@ include file="/template/Admin/common/sidebar.jsp" %>

    <main id="main" class="main">

        <div class="pagetitle">
            <h1>Chỉnh Sửa Thông Tin ACCOUNT</h1>
            <nav>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="FE_home.html">Home</a></li>
                    <li class="breadcrumb-item">Forms</li>
                    <li class="breadcrumb-item active">Quản Lý ACCOUNT</li>
                </ol>
            </nav>
        </div><!-- End Page Title -->
        <section class="section">
            <div class="row">
                <div class="col-lg-12">

                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Sửa</h5>

                            <!-- Horizontal Form -->
                            <form action="save" method="post" enctype="multipart/form-data">
                                <div class="row mb-3">
                                    <label for="inputName" class="col-sm-3 col-form-label">Tên Đăng Nhập </label>
                                    <div class="col-sm-9">
                                        <input type="text" id="name" name="name" class="form-control">
                                    </div>
                                </div>

                                <div class="row mb-3">
                                    <label for="inputName" class="col-sm-3 col-form-label">Role</label>
                                    <div class="col-sm-9">
                                        <div id="inputState" class="d-flex align-items-center">
                                            <div class="form-check me-3">
                                                <input class="form-check-input" type="radio" name="options" id="option1" value="admin" checked>
                                                <label class="form-check-label" for="option1">
                                                    Admin
                                                </label>
                                            </div>
                                            <div class="form-check me-3">
                                                <input class="form-check-input" type="radio" name="options" id="option2" value="product" checked>
                                                <label class="form-check-label" for="option2">
                                                    Product Manage
                                                </label>
                                            </div>
                                            <div class="form-check me-3">
                                                <input class="form-check-input" type="radio" name="options" id="option3" value="member" checked>
                                                <label class="form-check-label" for="option3">
                                                    Member
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="row mb-3">
                                    <label for="inputName" class="col-sm-3 col-form-label">Trạng Thái</label>
                                    <div class="col-sm-9">
                                        <div id="inputState" class="d-flex align-items-center">
                                            <div class="form-check me-3">
                                                <input class="form-check-input" type="radio" name="trangthai" id="option4" value="true" checked>
                                                <label class="form-check-label" for="option4">
                                                    Hoạt Động
                                                </label>
                                            </div>
                                            <div class="form-check me-3">
                                                <input class="form-check-input" type="radio" name="trangthai" id="option5" value="fasle" checked>
                                                <label class="form-check-label" for="option5">
                                                    Bị Khóa
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">Cập Nhật</button>
                                </div>
                            </form><!-- End Horizontal Form -->

                        </div>
                    </div>


                </div>
            </div>
        </section>

    </main><!-- End #main -->

    <!-- ======= Footer ======= -->
    <%@ include file="/template/Admin/common/footer.jsp" %>

    <!-- JS Files -->
    <%@ include file="/template/Admin/common/jsfile.jsp" %>

</body>

</html>