<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Thanh toán</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <img src="/template/user/images/vnpay-logo.png" style="width: 200px">
                    <h2 class="card-title">Thanh Toán Đơn Hàng</h2>
                    <form action="/submitOrder" method="post">
                        <div class="form-group">
                            <label for="amount">Số tiền:</label>
                            <input type="number" class="form-control" id="amount" name="amount" value="${totalAmount}" readonly="readonly" required>
                        </div>
                        <div class="form-group">
                            <label for="orderInfo">Thông tin đơn hàng:</label>
                            <input type="text" class="form-control" id="orderInfo" name="orderInfo" value="${donHang.maDH}" readonly="readonly" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Thanh toán</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>