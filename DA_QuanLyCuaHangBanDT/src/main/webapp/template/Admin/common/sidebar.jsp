<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside id="sidebar" class="sidebar">

        <ul class="sidebar-nav" id="sidebar-nav">

            <li class="nav-item">
                <a class="nav-link collapsed" href="/admin/home/view">
                    <i class="bi bi-grid"></i>
                    <span>Trang Chủ</span>
                </a>
            </li><!-- End Dashboard Nav -->
			<li class="nav-item">
                <a class="nav-link collapsed" data-bs-target="#sanpham" data-bs-toggle="collapse" href="#">
                    <i class="bi bi-layout-text-window-reverse"></i><span>Quản Lý Sản Phẩm</span><i
                        class="bi bi-chevron-down ms-auto"></i>
                </a>
                <ul id="sanpham" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                    <li>
                        <a href="/admin/sanpham/index">
                            <i class="bi bi-circle"></i><span>Thông Tin Sản Phẩm</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/sanpham/add">
                            <i class="bi bi-circle"></i><span>Thêm Mới Sản Phẩm</span>
                        </a>
                    </li>
                </ul>
            </li><!-- End Tables Nav -->
			
			<li class="nav-item">
                <a class="nav-link collapsed" data-bs-target="#ttchitietsp" data-bs-toggle="collapse" href="#">
                    <i class="bi bi-journal-text"></i><span>Quản Lý Chi Tiết Sản Phẩm  </span><i class="bi bi-chevron-down ms-auto"></i>
                </a>
                <ul id="ttchitietsp" class="nav-content collapse" data-bs-parent="#sidebar-nav">
                    <li>
                        <a href="/admin/mau/index">
                            <i class="bi bi-circle"></i><span>Màu Sắc</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/dungluong/index">
                            <i class="bi bi-circle"></i><span>Dung Lượng</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/ram/index">
                            <i class="bi bi-circle"></i><span>Ram</span>
                        </a>
                    </li>
                </ul>
            </li><!-- End Forms Nav -->
			
            <li class="nav-item">
                <a class="nav-link collapsed" data-bs-target="#linhkien" data-bs-toggle="collapse" href="#">
                    <i class="bi bi-menu-button-wide"></i><span>Quản lý Linh Kiện</span><i
                        class="bi bi-chevron-down ms-auto"></i>
                </a>
                <ul id="linhkien" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                    <li>
                        <a href="/admin/mh/index">
                            <i class="bi bi-circle"></i><span>Màn Hình</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/ps/index">
                            <i class="bi bi-circle"></i><span>Pin Sạc</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/camtruoc/index">
                            <i class="bi bi-circle"></i><span>Cam Trước</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/camsau/index">
                            <i class="bi bi-circle"></i><span>Cam Sau</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/hedieuhanh/index">
                            <i class="bi bi-circle"></i><span>Hệ Điều Hành</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/hang/index">
                            <i class="bi bi-circle"></i><span>Hãng Sản Xuất</span>
                        </a>
                    </li>
                </ul>
            </li><!-- End Components Nav -->

          
            <li class="nav-item">
                <a class="nav-link collapsed" data-bs-target="#pinsac" data-bs-toggle="collapse" href="#">
                   <i class="bi bi-menu-button-wide"></i><span>Quản Lý Pin Sạc</span><i class="bi bi-chevron-down ms-auto"></i>
                </a>
                <ul id="pinsac" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                    <li>
                        <a href="/admin/lp/index">
                            <i class="bi bi-circle"></i><span>Loại Pin</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/dlp/index">
                            <i class="bi bi-circle"></i><span>Dung Lượng Pin</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/cnp/index">
                            <i class="bi bi-circle"></i><span>Công Nghệ Pin</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/hts/index">
                            <i class="bi bi-circle"></i><span>Hỗ Trợ Sạc</span>
                        </a>
                    </li>
                </ul>
            </li><!-- End pin -->

             <li class="nav-item">
                <a class="nav-link collapsed" data-bs-target="#manhinh" data-bs-toggle="collapse" href="#">
                   <i class="bi bi-menu-button-wide"></i><span>Quản Lý Màn Hình</span><i class="bi bi-chevron-down ms-auto"></i>
                </a>
                <ul id="manhinh" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                    <li>
                        <a href="/admin/cnmh/index">
                            <i class="bi bi-circle"></i><span>Công Nghệ Màn Hình</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/dpgmh/index">
                            <i class="bi bi-circle"></i><span>Độ Phân Giải Màn Hình</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/mhr/index">
                            <i class="bi bi-circle"></i><span>Màn Hình Rộng</span>
                        </a>
                    </li>
                </ul>
            </li><!-- End màn hình -->

          	<li class="nav-item">
                <a class="nav-link collapsed" data-bs-target="#camera" data-bs-toggle="collapse" href="#">
                   <i class="bi bi-menu-button-wide"></i><span>Quản Lý Cammera</span><i class="bi bi-chevron-down ms-auto"></i>
                </a>
                <ul id="camera" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                    <li>
                        <a href="/admin/tnct/index">
                            <i class="bi bi-circle"></i><span>Tính Năng Camera Trước</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/tncs/index">
                            <i class="bi bi-circle"></i><span>Tính Năng Camera Sau</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/dpgct/index">
                            <i class="bi bi-circle"></i><span>Độ Phân Giải Camera Trước</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/dpgcs/index">
                            <i class="bi bi-circle"></i><span>Độ Phân Giải Camera Sau</span>
                        </a>
                    </li>
                </ul>
            </li><!-- End màn hình -->
			<li class="nav-item">
                <a class="nav-link collapsed" data-bs-target="#nguoidung" data-bs-toggle="collapse" href="#">
                   <i class="bi bi-menu-button-wide"></i><span>Quản Lý Người Dùng</span><i class="bi bi-chevron-down ms-auto"></i>
                </a>
                <ul id="nguoidung" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                    <li>
                        <a href="/admin/account/index">
                            <i class="bi bi-circle"></i><span>Người Dùng</span>
                        </a>
                    </li>
                    
                </ul>
            </li><!-- End màn hình -->
    </aside><!-- End Sidebar-->