<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Components / Carousel - NiceAdmin Bootstrap Template</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="/template/Admin/assets/img/favicon.png" rel="icon">
    <link href="/template/Admin/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link
        href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
        rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="/template/Admin/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/template/Admin/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="/template/Admin/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="/template/Admin/assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="/template/Admin/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="/template/Admin/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="/template/Admin/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="/template/Admin/assets/css/style.css" rel="stylesheet">

    <!-- =======================================================
  * Template Name: NiceAdmin
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Updated: Apr 20 2024 with Bootstrap v5.3.3
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

    <!-- ======= Header ======= -->
    <header id="header" class="header fixed-top d-flex align-items-center">

        <div class="d-flex align-items-center justify-content-between">
            <a href="index.html" class="logo d-flex align-items-center">
                <img src="/template/Admin/assets/img/logo.png" alt="">
                <span class="d-none d-lg-block">Admin</span>
            </a>
            <i class="bi bi-list toggle-sidebar-btn"></i>
        </div><!-- End Logo -->

        <div class="search-bar">
            <form class="search-form d-flex align-items-center" method="POST" action="#">
                <input type="text" name="query" placeholder="Search" title="Enter search keyword">
                <button type="submit" title="Search"><i class="bi bi-search"></i></button>
            </form>
        </div><!-- End Search Bar -->

        <nav class="header-nav ms-auto">
            <ul class="d-flex align-items-center">

                <li class="nav-item d-block d-lg-none">
                    <a class="nav-link nav-icon search-bar-toggle " href="#">
                        <i class="bi bi-search"></i>
                    </a>
                </li><!-- End Search Icon-->

                <li class="nav-item dropdown">

                    <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                        <i class="bi bi-bell"></i>
                        <span class="badge bg-primary badge-number">4</span>
                    </a><!-- End Notification Icon -->

                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
                        <li class="dropdown-header">
                            You have 4 new notifications
                            <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
                        </li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>

                        <li class="notification-item">
                            <i class="bi bi-exclamation-circle text-warning"></i>
                            <div>
                                <h4>Lorem Ipsum</h4>
                                <p>Quae dolorem earum veritatis oditseno</p>
                                <p>30 min. ago</p>
                            </div>
                        </li>

                        <li>
                            <hr class="dropdown-divider">
                        </li>

                        <li class="notification-item">
                            <i class="bi bi-x-circle text-danger"></i>
                            <div>
                                <h4>Atque rerum nesciunt</h4>
                                <p>Quae dolorem earum veritatis oditseno</p>
                                <p>1 hr. ago</p>
                            </div>
                        </li>

                        <li>
                            <hr class="dropdown-divider">
                        </li>

                        <li class="notification-item">
                            <i class="bi bi-check-circle text-success"></i>
                            <div>
                                <h4>Sit rerum fuga</h4>
                                <p>Quae dolorem earum veritatis oditseno</p>
                                <p>2 hrs. ago</p>
                            </div>
                        </li>

                        <li>
                            <hr class="dropdown-divider">
                        </li>

                        <li class="notification-item">
                            <i class="bi bi-info-circle text-primary"></i>
                            <div>
                                <h4>Dicta reprehenderit</h4>
                                <p>Quae dolorem earum veritatis oditseno</p>
                                <p>4 hrs. ago</p>
                            </div>
                        </li>

                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li class="dropdown-footer">
                            <a href="#">Show all notifications</a>
                        </li>

                    </ul><!-- End Notification Dropdown Items -->

                </li><!-- End Notification Nav -->

                <li class="nav-item dropdown">

                    <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                        <i class="bi bi-chat-left-text"></i>
                        <span class="badge bg-success badge-number">3</span>
                    </a><!-- End Messages Icon -->

                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
                        <li class="dropdown-header">
                            You have 3 new messages
                            <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
                        </li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>

                        <li class="message-item">
                            <a href="#">
                                <img src="/template/Admin/assets/img/messages-1.jpg" alt="" class="rounded-circle">
                                <div>
                                    <h4>Maria Hudson</h4>
                                    <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                                    <p>4 hrs. ago</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>

                        <li class="message-item">
                            <a href="#">
                                <img src="/template/Admin/assets/img/messages-2.jpg" alt="" class="rounded-circle">
                                <div>
                                    <h4>Anna Nelson</h4>
                                    <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                                    <p>6 hrs. ago</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>

                        <li class="message-item">
                            <a href="#">
                                <img src="/template/Admin/assets/img/messages-3.jpg" alt="" class="rounded-circle">
                                <div>
                                    <h4>David Muldon</h4>
                                    <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                                    <p>8 hrs. ago</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>

                        <li class="dropdown-footer">
                            <a href="#">Show all messages</a>
                        </li>

                    </ul><!-- End Messages Dropdown Items -->

                </li><!-- End Messages Nav -->

                <li class="nav-item dropdown pe-3">

                    <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                        <img src="/template/Admin/assets/img/user.png" alt="Profile" class="rounded-circle">
                        <span class="d-none d-md-block dropdown-toggle ps-2">Đăng nhập</span>
                    </a><!-- End Profile Iamge Icon -->

                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                        <li>
                            <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                                <i class="ri-account-circle-fill"></i>
                                <span>Đăng Nhập</span>
                            </a>
                        </li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>

                    </ul><!-- End Profile Dropdown Items -->
                </li><!-- End Profile Nav -->

            </ul>
        </nav><!-- End Icons Navigation -->

    </header><!-- End Header -->

    <!-- ======= Sidebar ======= -->
    <aside id="sidebar" class="sidebar">

        <ul class="sidebar-nav" id="sidebar-nav">

            <li class="nav-item">
                <a class="nav-link collapsed" href="FE_home.html">
                    <i class="bi bi-file-earmark"></i>
                    <span>Trang Chủ</span>
                </a>
            </li><!-- End Blank Page Nav -->

        </ul>

    </aside><!-- End Sidebar-->

    <main id="main" class="main">

        <section class="dashboard">

            <!-- Slides with captions -->
            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner" style="height: 600px;">
                    <div class="carousel-item active" style="height: 550px;">
                        <img src="/template/Admin/assets/img/iphone-13-4-2.jpg" class="d-block w-100" alt="..." style=" filter: blur(3px)">
                        <div class="carousel-caption d-none d-md-block" style=" top: 50%; left: 50%;">
                            <h5 class="card-title text-title-slider text-shadow-1" >THELIEM </h5>
                            <p class="card-body text-shadow-1">Chào mừng bạn đã trỏ lại trang quản trị của THELIEM </p>
                        </div>
                    </div>
                    <div class="carousel-item" style="height: 550px;">
                        <img src="/template/Admin/assets/img/iphone-13-5-3.jpg" class="d-block w-100" alt="..." style=" filter: blur(3px)">
                        <div class="carousel-caption d-none d-md-block" style=" top: 50%; left: 50%;">
                            <h5 class="card-title text-title-slider text-shadow-1">THELIEM </h5>
                            <p class="card-body text-shadow-1">Chào mừng bạn đã trỏ lại trang quản trị của THELIEM </p>
                        </div>
                    </div>
                    <div class="carousel-item" style="height: 550px;">
                        <img src="/template/Admin/assets/img/iphone-13-5-2.jpg" class="d-block w-100" alt="..." style=" filter: blur(3px)">
                        <div class="carousel-caption d-none d-md-block" style=" top: 50%; left: 50%;">
                            <h5 class="card-title text-title-slider text-shadow-1">THELIEM </h5>
                            <p class="card-body text-shadow-1">Chào mừng bạn đã trỏ lại trang quản trị của THELIEM </p>
                        </div>
                    </div>
                </div>

                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                    data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                    data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>

            </div><!-- End Slides with captions -->

            <hr>

            <div class="">
                <br>
                <div class="text-center ">
                    <h4 class="card-title" style="font-size: x-large;"> Điểm Nổi Bật </h4>
                </div>
                <hr>
            </div>

            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div id="slidertophot" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#slidertophot" data-bs-slide-to="0" class="active"
                                aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#slidertophot" data-bs-slide-to="1"
                                aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#slidertophot" data-bs-slide-to="2"
                                aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active ">
                                <img src="/template/Admin/assets/img/iphone-13-xanh-glr-4.jpg" class="d-block w-100 " alt="..." style=" filter: blur(3px)">
                                <div class="carousel-caption d-none d-md-block ">
                                    <div class="card-img-top">
                                        <h5 class="text-shadow-1">Top Sản Phẩm Bán Chạy</h5>
                                        <p>Đây là những sản phẩm bán chạy nhất trong tuần vừa qua </p>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img src="/template/Admin/assets/img/iphone-13-xanh-glr-5.jpg" class="d-block w-100" alt="..." style=" filter: blur(3px)">
                                <div class="carousel-caption d-none d-md-block">
                                    <h5 class="text-shadow-1">Top Sản Phẩm Bán Chạy</h5>
                                    <p>Đây là những sản phẩm bán chạy nhất trong tuần vừa qua </p>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img src="/template/Admin/assets/img/samsung-galaxy-s23-ultra-5-1.jpg" class="d-block w-100" alt="..." style=" filter: blur(3px)">
                                <div class="carousel-caption d-none d-md-block">
                                    <h5 class="text-shadow-1">Top Sản Phẩm Bán Chạy</h5>
                                    <p>Đây là những sản phẩm bán chạy nhất trong tuần vừa qua </p>
                                </div>
                            </div>
                        </div>
        
                        <button class="carousel-control-prev" type="button" data-bs-target="#slidertophot"
                            data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#slidertophot"
                            data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>    
                    </div><!-- End Slides with captions -->

                    <br>

                    <!-- Card with an image overlay -->
                    <div class="card">
                        <img src="/template/Admin/assets/img/anhbaocao.png" class="card-img-top" alt="...">
                        <div class="card-img-overlay">
                            <h5 class="card-title">Báo Cáo </h5>
                            <p class="card-text">Biểu đồ thể thiện đơn hàng , danh số bán hàng , thu nhập </p>
                        </div>
                    </div><!-- End Card with an image overlay -->

                </div>

                <div class="col-lg-4 col-md-4">
                    <!-- Card with an image overlay -->
                    <div class="card">
                        <img src="/template/Admin/assets/img/anhtopsp.png" class="card-img-top" alt="...">
                        <div class="card-img-overlay">
                            <h5 class="card-title">Thống Kê Sản Phẩm Bán Chạy</h5>
                            <p class="card-text">Bạn cần đăng nhập để mở khóa tính năng này </p>
                        </div>
                    </div><!-- End Card with an image overlay -->

                    <!-- Card with an image overlay -->
                    <div class="card">
                        <img src="/template/Admin/assets/img/formmau.png" class="card-img-top" alt="...">
                        <div class="card-img-overlay">
                            <h5 class="card-title">Quản Lý</h5>
                            <p class="card-text">Quản lý sản phẩm dễ đàng tiện lợi</p>
                        </div>
                    </div><!-- End Card with an image overlay -->

                </div>

                <div class="col-lg-4 col-md-4">
                    <!-- News & Updates Traffic -->
                    <div class="card">
                        <div class="filter">
                            <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                            <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                <li class="dropdown-header text-start">
                                    <h6>Filter</h6>
                                </li>

                                <li><a class="dropdown-item" href="#">Today</a></li>
                                <li><a class="dropdown-item" href="#">This Month</a></li>
                                <li><a class="dropdown-item" href="#">This Year</a></li>
                            </ul>
                        </div>

                        <div class="card-body pb-0">
                            <h5 class="card-title">Tin tức &amp; Cập nhật<span>| Today</span></h5>

                            <div class="news">
                                <div class="post-item clearfix">
                                    <img src="/template/Admin/assets/img/news-1.jpg" alt="">
                                    <h4><a href="#">Nihil blanditiis at in nihil autem</a></h4>
                                    <p>Sit recusandae non aspernatur laboriosam. Quia enim eligendi sed ut harum...</p>
                                </div>

                                <div class="post-item clearfix">
                                    <img src="/template/Admin/assets/img/news-2.jpg" alt="">
                                    <h4><a href="#">Quidem autem et impedit</a></h4>
                                    <p>Illo nemo neque maiores vitae officiis cum eum turos elan dries werona nande...
                                    </p>
                                </div>

                                <div class="post-item clearfix">
                                    <img src="/template/Admin/assets/img/news-3.jpg" alt="">
                                    <h4><a href="#">Id quia et et ut maxime similique occaecati ut</a></h4>
                                    <p>Fugiat voluptas vero eaque accusantium eos. Consequuntur sed ipsam et totam...
                                    </p>
                                </div>

                                <div class="post-item clearfix">
                                    <img src="/template/Admin/assets/img/news-4.jpg" alt="">
                                    <h4><a href="#">Laborum corporis quo dara net para</a></h4>
                                    <p>Qui enim quia optio. Eligendi aut asperiores enim repellendusvel rerum cuder...
                                    </p>
                                </div>

                                <div class="post-item clearfix">
                                    <img src="/template/Admin/assets/img/news-5.jpg" alt="">
                                    <h4><a href="#">Et dolores corrupti quae illo quod dolor</a></h4>
                                    <p>Odit ut eveniet modi reiciendis. Atque cupiditate libero beatae dignissimos
                                        eius...</p>
                                </div>

                            </div><!-- End sidebar recent posts-->

                        </div>
                    </div>
                    <!-- End News & Updates -->
                </div>
            </div>



            <!-- 
            <div class="">
                <br>
                <div class="text-center ">
                    <h4 class="card-title" style="font-size: x-large;"> Về Chúng Tôi </h4>
                </div>
                <hr>
            </div>

            <div class="row">
                <div class="col-lg-6">
                  <div class="info-box card">
                    <i class="bi bi-geo-alt"></i>
                    <h3>Address</h3>
                    <p>FPoly <br>Cần Thơ</p>
                  </div>
                </div>
                <div class="col-lg-6">
                  <div class="info-box card">
                    <i class="bi bi-telephone"></i>
                    <h3>Call </h3>
                    <p>+84 337 653 876<br>+84 997 333 444</p>
                  </div>
                </div>
                <div class="col-lg-6">
                  <div class="info-box card">
                    <i class="bi bi-envelope"></i>
                    <h3>Email </h3>
                    <p>0men0ngu0@gmail.com<br>luongnguyenmen@example.com</p>
                  </div>
                </div>
                <div class="col-lg-6">
                  <div class="info-box card">
                    <i class="bi bi-clock"></i>
                    <h3>Open Hours</h3>
                    <p>Monday - Friday<br>9:00AM - 08:00PM</p>
                  </div>
                </div>
              </div>
 -->

        </section>

    </main><!-- End #main -->

    <!-- ======= Footer ======= -->
    <footer id="footer" class="footer">
        <div class="copyright">
            &copy; Copyright <strong><span>NiceAdmin</span></strong>. All Rights Reserved
        </div>
        <div class="credits">
            <!-- All the links in the footer should remain intact. -->
            <!-- You can delete the links only if you purchased the pro version. -->
            <!-- Licensing information: https://bootstrapmade.com/license/ -->
            <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
        </div>
    </footer><!-- End Footer -->

    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
            class="bi bi-arrow-up-short"></i></a>

    <!-- Vendor JS Files -->
    <script src="/template/Admin/assets/vendor/apexcharts/apexcharts.min.js"></script>
    <script src="/template/Admin/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="/template/Admin/assets/vendor/chart.js/chart.umd.js"></script>
    <script src="/template/Admin/assets/vendor/echarts/echarts.min.js"></script>
    <script src="/template/Admin/assets/vendor/quill/quill.js"></script>
    <script src="/template/Admin/assets/vendor/simple-datatables/simple-datatables.js"></script>
    <script src="/template/Admin/assets/vendor/tinymce/tinymce.min.js"></script>
    <script src="/template/Admin/assets/vendor/php-email-form/validate.js"></script>

    <!-- Template Main JS File -->
    <script src="/template/Admin/assets/js/main.js"></script>

</body>

</html>