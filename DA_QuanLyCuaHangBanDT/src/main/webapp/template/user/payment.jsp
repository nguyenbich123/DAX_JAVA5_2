<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<title>TheLiem Cửa hàng điện thoại</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="author" content="">
<meta name="keywords" content="">
<meta name="description" content="">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="/template/user/css/style.css">
<!-- <link rel="stylesheet" href="css/layout.css"> -->
<link rel="stylesheet" href="/template/user/css/index.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="/template/user/css/thanhToan.css">
<link
	href="https://fonts.googleapis.com/css2?family=Jost:wght@300;400;500&family=Lato:wght@300;400;700&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/49bc4d7d5f.js"
	crossorigin="anonymous"></script>
<!-- <link rel="stylesheet" href="css/layout.css"> -->
<!-- script
    ================================================== -->
<script src="/template/user/js/modernizr.js"></script>
<link rel="stylesheet" href="/template/user/css/index.css">
</head>

<body data-bs-spy="scroll" data-bs-target="#navbar"
	data-bs-root-margin="0px 0px -40%" data-bs-smooth-scroll="true"
	tabindex="0">
	<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
        <symbol id="search" xmlns="http://www.w3.org/2000/svg"
			viewBox="0 0 32 32">
            <title>Search</title>
            <path fill="currentColor"
			d="M19 3C13.488 3 9 7.488 9 13c0 2.395.84 4.59 2.25 6.313L3.281 27.28l1.439 1.44l7.968-7.969A9.922 9.922 0 0 0 19 23c5.512 0 10-4.488 10-10S24.512 3 19 3zm0 2c4.43 0 8 3.57 8 8s-3.57 8-8 8s-8-3.57-8-8s3.57-8 8-8z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="user"
			viewBox="0 0 16 16">
            <path
			d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3Zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="cart"
			viewBox="0 0 16 16">
            <path
			d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
        </symbol>
        <svg xmlns="http://www.w3.org/2000/svg" id="chevron-left"
			viewBox="0 0 16 16">
            <path fill-rule="evenodd"
				d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" />
        </svg>
        <symbol xmlns="http://www.w3.org/2000/svg" id="chevron-right"
			viewBox="0 0 16 16">
            <path fill-rule="evenodd"
			d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="cart-outline"
			viewBox="0 0 16 16">
            <path
			d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="quality"
			viewBox="0 0 16 16">
            <path
			d="M9.669.864 8 0 6.331.864l-1.858.282-.842 1.68-1.337 1.32L2.6 6l-.306 1.854 1.337 1.32.842 1.68 1.858.282L8 12l1.669-.864 1.858-.282.842-1.68 1.337-1.32L13.4 6l.306-1.854-1.337-1.32-.842-1.68L9.669.864zm1.196 1.193.684 1.365 1.086 1.072L12.387 6l.248 1.506-1.086 1.072-.684 1.365-1.51.229L8 10.874l-1.355-.702-1.51-.229-.684-1.365-1.086-1.072L3.614 6l-.25-1.506 1.087-1.072.684-1.365 1.51-.229L8 1.126l1.356.702 1.509.229z" />
            <path
			d="M4 11.794V16l4-1 4 1v-4.206l-2.018.306L8 13.126 6.018 12.1 4 11.794z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="price-tag"
			viewBox="0 0 16 16">
            <path
			d="M6 4.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm-1 0a.5.5 0 1 0-1 0 .5.5 0 0 0 1 0z" />
            <path
			d="M2 1h4.586a1 1 0 0 1 .707.293l7 7a1 1 0 0 1 0 1.414l-4.586 4.586a1 1 0 0 1-1.414 0l-7-7A1 1 0 0 1 1 6.586V2a1 1 0 0 1 1-1zm0 5.586 7 7L13.586 9l-7-7H2v4.586z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="shield-plus"
			viewBox="0 0 16 16">
            <path
			d="M5.338 1.59a61.44 61.44 0 0 0-2.837.856.481.481 0 0 0-.328.39c-.554 4.157.726 7.19 2.253 9.188a10.725 10.725 0 0 0 2.287 2.233c.346.244.652.42.893.533.12.057.218.095.293.118a.55.55 0 0 0 .101.025.615.615 0 0 0 .1-.025c.076-.023.174-.061.294-.118.24-.113.547-.29.893-.533a10.726 10.726 0 0 0 2.287-2.233c1.527-1.997 2.807-5.031 2.253-9.188a.48.48 0 0 0-.328-.39c-.651-.213-1.75-.56-2.837-.855C9.552 1.29 8.531 1.067 8 1.067c-.53 0-1.552.223-2.662.524zM5.072.56C6.157.265 7.31 0 8 0s1.843.265 2.928.56c1.11.3 2.229.655 2.887.87a1.54 1.54 0 0 1 1.044 1.262c.596 4.477-.787 7.795-2.465 9.99a11.775 11.775 0 0 1-2.517 2.453 7.159 7.159 0 0 1-1.048.625c-.28.132-.581.24-.829.24s-.548-.108-.829-.24a7.158 7.158 0 0 1-1.048-.625 11.777 11.777 0 0 1-2.517-2.453C1.928 10.487.545 7.169 1.141 2.692A1.54 1.54 0 0 1 2.185 1.43 62.456 62.456 0 0 1 5.072.56z" />
            <path
			d="M8 4.5a.5.5 0 0 1 .5.5v1.5H10a.5.5 0 0 1 0 1H8.5V9a.5.5 0 0 1-1 0V7.5H6a.5.5 0 0 1 0-1h1.5V5a.5.5 0 0 1 .5-.5z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="star-fill"
			viewBox="0 0 16 16">
            <path
			d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="star-empty"
			viewBox="0 0 16 16">
            <path
			d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="star-half"
			viewBox="0 0 16 16">
            <path
			d="M5.354 5.119 7.538.792A.516.516 0 0 1 8 .5c.183 0 .366.097.465.292l2.184 4.327 4.898.696A.537.537 0 0 1 16 6.32a.548.548 0 0 1-.17.445l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256a.52.52 0 0 1-.146.05c-.342.06-.668-.254-.6-.642l.83-4.73L.173 6.765a.55.55 0 0 1-.172-.403.58.58 0 0 1 .085-.302.513.513 0 0 1 .37-.245l4.898-.696zM8 12.027a.5.5 0 0 1 .232.056l3.686 1.894-.694-3.957a.565.565 0 0 1 .162-.505l2.907-2.77-4.052-.576a.525.525 0 0 1-.393-.288L8.001 2.223 8 2.226v9.8z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="quote"
			viewBox="0 0 24 24">
            <path fill="currentColor"
			d="m15 17l2-4h-4V6h7v7l-2 4h-3Zm-9 0l2-4H4V6h7v7l-2 4H6Z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="facebook"
			viewBox="0 0 24 24">
            <path fill="currentColor"
			d="M9.198 21.5h4v-8.01h3.604l.396-3.98h-4V7.5a1 1 0 0 1 1-1h3v-4h-3a5 5 0 0 0-5 5v2.01h-2l-.396 3.98h2.396v8.01Z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="youtube"
			viewBox="0 0 32 32">
            <path fill="currentColor"
			d="M29.41 9.26a3.5 3.5 0 0 0-2.47-2.47C24.76 6.2 16 6.2 16 6.2s-8.76 0-10.94.59a3.5 3.5 0 0 0-2.47 2.47A36.13 36.13 0 0 0 2 16a36.13 36.13 0 0 0 .59 6.74a3.5 3.5 0 0 0 2.47 2.47c2.18.59 10.94.59 10.94.59s8.76 0 10.94-.59a3.5 3.5 0 0 0 2.47-2.47A36.13 36.13 0 0 0 30 16a36.13 36.13 0 0 0-.59-6.74ZM13.2 20.2v-8.4l7.27 4.2Z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="twitter"
			viewBox="0 0 256 256">
            <path fill="currentColor"
			d="m245.66 77.66l-29.9 29.9C209.72 177.58 150.67 232 80 232c-14.52 0-26.49-2.3-35.58-6.84c-7.33-3.67-10.33-7.6-11.08-8.72a8 8 0 0 1 3.85-11.93c.26-.1 24.24-9.31 39.47-26.84a110.93 110.93 0 0 1-21.88-24.2c-12.4-18.41-26.28-50.39-22-98.18a8 8 0 0 1 13.65-4.92c.35.35 33.28 33.1 73.54 43.72V88a47.87 47.87 0 0 1 14.36-34.3A46.87 46.87 0 0 1 168.1 40a48.66 48.66 0 0 1 41.47 24H240a8 8 0 0 1 5.66 13.66Z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="instagram"
			viewBox="0 0 256 256">
            <path fill="currentColor"
			d="M128 80a48 48 0 1 0 48 48a48.05 48.05 0 0 0-48-48Zm0 80a32 32 0 1 1 32-32a32 32 0 0 1-32 32Zm48-136H80a56.06 56.06 0 0 0-56 56v96a56.06 56.06 0 0 0 56 56h96a56.06 56.06 0 0 0 56-56V80a56.06 56.06 0 0 0-56-56Zm40 152a40 40 0 0 1-40 40H80a40 40 0 0 1-40-40V80a40 40 0 0 1 40-40h96a40 40 0 0 1 40 40ZM192 76a12 12 0 1 1-12-12a12 12 0 0 1 12 12Z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="linkedin"
			viewBox="0 0 24 24">
            <path fill="currentColor"
			d="M6.94 5a2 2 0 1 1-4-.002a2 2 0 0 1 4 .002zM7 8.48H3V21h4V8.48zm6.32 0H9.34V21h3.94v-6.57c0-3.66 4.77-4 4.77 0V21H22v-7.93c0-6.17-7.06-5.94-8.72-2.91l.04-1.68z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="nav-icon"
			viewBox="0 0 16 16">
            <path
			d="M14 10.5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-7a.5.5 0 0 0 0 1h7a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-11a.5.5 0 0 0 0 1h11a.5.5 0 0 0 .5-.5z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="close"
			viewBox="0 0 16 16">
            <path
			d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z" />
        </symbol>
        <symbol xmlns="http://www.w3.org/2000/svg" id="navbar-icon"
			viewBox="0 0 16 16">
            <path
			d="M14 10.5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-7a.5.5 0 0 0 0 1h7a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-11a.5.5 0 0 0 0 1h11a.5.5 0 0 0 .5-.5z" />
        </symbol>
    </svg>

	<!-- Hiển thị popup của thanh tìm kiếm -->
	<div class="search-popup">
		<div class="search-popup-container">
			<form role="search" method="get" class="search-form"
				action="/product/search?p=0&sortby=${sortby}&min=${param.min}&max=${param.max}&keywords=${keywords}">
				<input type="search" id="search-form" class="search-field"
					placeholder="Tìm kiếm" value="" name="keywords" />
				<button type="submit" class="search-submit">
					<svg class="search">
                <use xlink:href="#search"></use>
            </svg>
				</button>
			</form>

			<h5 class="cat-list-title">Chọn danh mục</h5>
			<ul class="cat-list">
				<li class="cat-list-item"><a href="" title="Mobile Phones">Iphone15</a></li>
				<li class="cat-list-item"><a href="" title="Smart Watches">Samsung
						S23 Ultra</a></li>
			</ul>
		</div>
	</div>


	<header id="header mb-2">
		<div class="site-header_product text-black">
			<nav id="header-nav" class="navbar navbar-expand-lg px-4 py-4">
          <div class="container-fluid">
            <a  class="navbar-brand " href="/home/0">
              <img src="/template/user/images/TheLiem(2).png" class="logo">
            </a>
            <button class="navbar-toggler d-flex d-lg-none order-3 p-2" type="button" data-bs-toggle="offcanvas" data-bs-target="#bdNavbar" aria-controls="bdNavbar" aria-expanded="false" aria-label="Toggle navigation">
              <svg class="navbar-icon">
                <use xlink:href="#navbar-icon"></use>
              </svg>
            </button>
            <div class="offcanvas offcanvas-end" tabindex="-1" id="bdNavbar" aria-labelledby="bdNavbarOffcanvasLabel">
              <div class="offcanvas-header px-4 pb-0">
                <a class="navbar-brand" href="index.html">
                  <img src="/template/user/images/2.png" class="logo">
                </a>
                <button type="button" class="btn-close btn-close-black" data-bs-dismiss="offcanvas" aria-label="Close" data-bs-target="#bdNavbar"></button>
              </div>
              <div class="offcanvas-body">
                <ul id="navbar" class="navbar-nav text-uppercase justify-content-end align-items-center flex-grow-1 pe-3">
                  <li class="nav-item">
                    <a class="nav-link me-4 active" href="/home/0">Trang chủ</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link me-4" href="/home/0#company-services">Dịch vụ</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link me-4" href="/product/view">Sản phẩm</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link me-4" href="/home/0#yearly-sale">Khuyến mãi</a>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link me-4 dropdown-toggle link-dark" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Trang</a>
                    <ul class="dropdown-menu">
                      <li>
                        <a href="/product/view" class="dropdown-item">Cửa hàng</a>
                      </li>
                      <li>
                      <li>
                        <a href="/contact/view" class="dropdown-item">Liên hệ</a>
                      </li>
                      <li>
                        <a href="/about/view" class="dropdown-item">Giới Thiệu</a>
                      </li>
                      <li>
                        <a href="/feedback/view" class="dropdown-item">Góp Ý</a>
                      </li>
                    </ul>
                  </li>
                  <li class="nav-item">
                    <div class="user-items ps-5">
                      <ul class="d-flex justify-content-end list-unstyled">
                        <li class="search-item pe-3">
                          <a href="#" class="search-button">
                            <svg class="search">
                              <use xlink:href="#search"></use>
                            </svg>
                          </a>
                        </li>
                        <li class="pe-3 dropdown position-relative">
                          <a href="#" class="" data-bs-toggle="dropdown" aria-expanded="false">
                          	  <c:if test="${account != null}">
								    Xin chào, ${account.hoTen}
							  </c:if>
                            <svg class="user">
                              <use xlink:href="#user"></use>
                            </svg>
                          </a>
                          <ul class="dropdown-menu ">
                          	
	                          <c:choose>
								    <c:when test="${account != null}">
									    <li style="max-height: 100px" class="p-2">
										    <div class="avatar">
										        <img alt="" src="/template/user/images/meo.jpg">
										    </div>
										</li>
								        <li>
			                              <a href="" class="dropdown-item">Chỉnh sửa thông tin</a>
			                            </li>
			                            <li>
			                              <a href="/order/view" class="dropdown-item">Đơn hàng của tôi</a>
			                            </li>
			                            <li>
			                              <a href="/account/logout" class="dropdown-item">Đăng xuất</a>
			                            </li>
			                            <li>
			                              <a href="/account/resetpass" class="dropdown-item">Đổi mật khẩu</a>
			                            </li>
								    </c:when>
								    <c:otherwise>
								         <li>
			                              <a href="/account/login" class="dropdown-item">Đăng nhập</a>
			                            </li>
			                            <li>
			                              <a href="/account/signup" class="dropdown-item">Đăng ký</a>
			                            </li>
								    </c:otherwise>
							  </c:choose>  
                          </ul>
                        </li>
                        <li>
                          <a class="nav-icon position-relative text-decoration-none"  href="/cart/view">
                            <svg class="cart">
                              <use xlink:href="#cart"></use>
                            </svg>
                            <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-red text-light">${sl}</span>
                          </a>
                        </li>
                      </ul>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </nav>
		</div>

	</header>

	<div class="container py-5">
		<div class="row">
			<div class="col-md-8">
				<%-- <div class="row">
					<c:forEach var="entry" items="${selectedItemsMap}">
						<tr>
							<td>${entry.key}</td>
							<td>${entry.value.soLuong}</td>
							<td>${entry.value.maCTSP.gia}</td>
							<td>${entry.value.soLuong * entry.value.maCTSP.gia}</td>
						</tr>	
					</c:forEach>
				
				</div> --%>

				<form action="/payment/pay" method="post">
					<input type="hidden" id="selectedItemsMap" name="selectedItemsMap">
					<h2 style="font-weight: bold;">Thanh toán</h2>
					<div class="card mb-3">
						<div class="card-body">
							<div class="row">
								<div class="col-md-6">
									<label for="fullName">Họ và tên:</label> <input type="text"
										class="form-control" id="fullName"
										placeholder="Nhập họ và tên" value="${account.hoTen}" readonly>
								</div>
								<div class="col-md-6">
									<label for="phoneNumber">Số điện thoại:</label> <input
										type="text" class="form-control" id="phoneNumber"
										placeholder="Nhập số điện thoại" value="${account.sdt}"
										readonly>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-md-12">
									<label for="amount">Số tiền:</label> 
									<fmt:formatNumber value="${totalAmount}"  pattern="#,###đ"/>
									<input type="hidden"
										class="form-control" id="amount" name="tongTien"
										value="${totalAmount}" readonly>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-md-12">
									<label for="diachi">Địa Chỉ</label> <select name="diachiHT"
										class="form-select">
										<c:forEach var="dc" items="${diachi}">
											<option
												value="${dc.duong_Sonha}, ${dc.quan_Huyen}, ${dc.tinh_ThanhPho}">
												${dc.duong_Sonha}, ${dc.quan_Huyen}, ${dc.tinh_ThanhPho}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-md-12">
									<label for="note">Ghi chú:</label>
									<textarea class="form-control" id="note" name="note" rows="3"></textarea>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-md-12">
									<label for="paymentMethod">Phương thức thanh toán:</label> <select
										name="phuongThuc" class="form-select">
										<option value="Ví VNPAY">Ví VNPAY</option>
										<option value="Thanh toán khi nhận hàng">Thanh toán
											khi nhận hàng</option>
									</select>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-md-12">
									<label for="discountCode">Nhập Mã Giảm Giá (Nếu Có):</label> <input
										type="text" class="form-control" id="discountCode"
										name="discountCode" placeholder="Nhập mã giảm giá">
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-md-12">
									<strong>
										<h4>Thành tiền:</h4>
									</strong>
								</div>
							</div>
							<div class="mt-3">
								<button type="submit" class="btn btn-dark">Thanh toán</button>
							</div>
						</div>
					</div>
				</form>


			</div>
			<div class="col-md-4">
				<h2>Thông tin thanh toán</h2>
				<div class="card mb-3">
					<div class="card-body">
						<div class="row">
							<div class="col-md-6">
								<i class="fa fa-truck fa-5x"></i>
							</div>
							<div class="col-md-6">
								<h3>Giao hàng miễn phí</h3>
								<p>Giao hàng miễn phí toàn quốc cho đơn hàng từ 500.000đ.</p>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-md-6">
								<i class="fa fa-money-bill fa-5x"></i>
							</div>
							<div class="col-md-6">
								<h3>Giá cả cạnh tranh</h3>
								<p>Cam kết mang đến cho khách hàng sản phẩm chất lượng với
									giá cả cạnh tranh nhất thị trường.</p>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-md-6">
								<i class="fa fa-gift fa-5x"></i>
							</div>
							<div class="col-md-6">
								<h3>Khuyến mãi hấp dẫn</h3>
								<p>Cung cấp nhiều chương trình khuyến mãi hấp dẫn cho khách
									hàng throughout the year.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer id="footer" class="overflow-hidden mt-3 border-top pt-3">
		<div class="container">
			<div class="row">
				<div class="footer-top-area">
					<div class="row d-flex flex-wrap justify-content-between">
						<div class="col-lg-3 col-sm-6 pb-3">
							<div class="footer-menu">
								<img src="/template/user/images/TheLiem(2).png" alt="logo">
								<!-- <p>Nisi, purus vitae, ultrices nunc. Sit ac sit suscipit hendrerit. Gravida massa volutpat aenean odio erat nullam fringilla.</p> -->
								<div class="footer-section">
									<p>Chỉ bán sản phẩm chính hãng, đảm bảo chất lượng cao
										nhất.</p>
									<p>Đảm bảo sản phẩm chính hãng, bảo hành toàn diện.</p>
								</div>
								<div class="social-links">
									<ul class="d-flex list-unstyled">
										<li><a href="#"> <svg class="facebook">
                                                            <use
														xlink:href="#facebook" />
                                                        </svg>
										</a></li>
										<li><a href="#"> <svg class="instagram">
                                                            <use
														xlink:href="#instagram" />
                                                        </svg>
										</a></li>
										<li><a href="#"> <svg class="twitter">
                                                            <use
														xlink:href="#twitter" />
                                                        </svg>
										</a></li>
										<li><a href="#"> <svg class="linkedin">
                                                            <use
														xlink:href="#linkedin" />
                                                        </svg>
										</a></li>
										<li><a href="#"> <svg class="youtube">
                                                            <use
														xlink:href="#youtube" />
                                                        </svg>
										</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-lg-2 col-sm-6 pb-3">
							<div class="footer-menu text-uppercase">
								<h5 class="widget-title pb-2">Liên kết nhanh</h5>
								<ul class="menu-list list-unstyled text-uppercase">
									<li class="menu-item pb-2"><a href="#">Trang chủ</a></li>
									<li class="menu-item pb-2"><a href="#">Giới thiệu</a></li>
									<li class="menu-item pb-2"><a href="#">Cửa hàng</a></li>
									<li class="menu-item pb-2"><a href="#">Bài viết</a></li>
									<li class="menu-item pb-2"><a href="#">Liên hệ</a></li>
								</ul>
							</div>
						</div>
						<div class="col-lg-3 col-sm-6 pb-3">
							<div class="footer-menu text-uppercase">
								<h5 class="widget-title pb-2">Trợ giúp & Thông tin</h5>
								<ul class="menu-list list-unstyled">
									<li class="menu-item pb-2"><a href="#">Theo dõi đơn
											hàng</a></li>
									<li class="menu-item pb-2"><a href="#">Chính sách hoàn
											trả</a></li>
									<li class="menu-item pb-2"><a href="#">Giao hàng + Vận
											chuyển</a></li>
									<li class="menu-item pb-2"><a href="#">Liên hệ</a></li>
									<li class="menu-item pb-2"><a href="#">Câu hỏi thường
											gặp</a></li>
								</ul>
							</div>
						</div>
						<div class="col-lg-3 col-sm-6 pb-3">
							<div class="footer-menu contact-item">
								<h5 class="widget-title text-uppercase pb-2">Liên hệ</h5>
								<p>
									Bạn có bất kỳ thắc mắc hoặc đề xuất nào? <a href="mailto:">theliem2024@gmail.com</a>
								</p>
								<p>
									Nếu bạn cần hỗ trợ? Hãy gọi cho chúng tôi. <a href="">+84
										111 222 333</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>
	</footer>
	<div id="footer-bottom">
		<div class="container">
			<div class="row d-flex flex-wrap justify-content-between">
				<div class="col-md-4 col-sm-6">
					<div class="Shipping d-flex">
						<p>We ship with:</p>
						<div class="card-wrap ps-2">
							<img src="/template/user/images/logo_ghn.png" alt="visa">
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6">
					<div class="payment-method d-flex">
						<p>Payment options:</p>
						<div class="card-wrap ps-2">
							<img src="/template/user/images/logo_momo_out.png" alt="paypal">
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6">
					<div class="copyright">
						<p>© Copyright 2024 TheLiem. Design by TheLiem Team. All
							rights reserved.</p>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	    // Dữ liệu ctsp là danh sách các CartItem từ backend
	    var ctsp = ${dssp};
	
	    // Chuyển đổi thành JSON
	    var selectedItemsJson = JSON.stringify(ctsp);
	
	    // Gán giá trị JSON vào input hidden
    document.getElementById('selectedItemsMap').value = selectedItemsJson;
</script>
	<script src="/template/user/js/jquery-1.11.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
	<script type="text/javascript"
		src="/template/user/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="/template/user/js/plugins.js"></script>
	<script type="text/javascript" src="/template/user/js/script.js"></script>
	<script src="/template/user/js/thanhToan.js"></script>
</body>

</html>