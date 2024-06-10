<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Thanh Toán Thành Công</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <style>
    body {
      background-color: #f8f9fa;
    }

    .card {
      margin-top: 50px;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .card-header {
      border-top-left-radius: 10px;
      border-top-right-radius: 10px;
    }

    .card-body {
      padding: 2rem;
    }

    .order-number {
      font-size: 1.2rem;
      margin-top: 1rem;
    }

    .btn-primary,
    .btn-secondary {
      margin-top: 1rem;
    }

    .btn-container {
      display: flex;
      justify-content: space-around;
    }
  </style>
  <link rel="stylesheet" href="/template/user/css/index.css">
</head>
<body>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card text-center">
          <div class="card-header bg-success text-white">
            Thanh Toán Thành Công
          </div>
          <div class="card-body">
            <svg xmlns="http://www.w3.org/2000/svg" width="80" height="80" fill="currentColor" class="bi bi-check-circle-fill text-success mb-3" viewBox="0 0 16 16">
              <path d="M16 8a8 8 0 1 1-16 0 8 8 0 0 1 16 0zM6.97 10.03a.75.75 0 0 0 1.08-.02L10.3 7.043a.75.75 0 1 0-1.08-1.04L7.5 8.197l-1.72-1.72a.75.75 0 0 0-1.08 1.04l2.27 2.27z"/>
            </svg>
            <h5 class="card-title">Cảm ơn bạn đã mua hàng!</h5>
            <p class="card-text">Thanh toán của bạn đã được xử lý thành công.</p>
            <p class="card-text order-number">Mã đơn hàng: <strong>${donHang.maDH}</strong></p>   
            <div class="btn-container">
                <a href="/home/index" class="btn btn-primary">Về lại trang chủ</a>
                <a href="/order/view" class="btn btn-secondary">Xem Lại Đơn Hàng</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+2nDzLV8=.bdbd/+bsc0ve81i6" crossorigin="anonymous"></script>
</body>
</html>