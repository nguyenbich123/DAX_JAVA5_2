<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đánh Giá</title>
    <link rel="stylesheet" href="/template/user/css/vote.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>

<body>
    <div class="vote-body">
        <form method="post">
            <div class="rating-container">
                <h3 class="text-center font-title"> Đánh Giá</h3>
                <div class="row">
                    <div class="rating">
                        <input type="radio" id="star5" name="rating" value="5" />
                        <label for="star5" title="Tuyệt vời" class="star"></label>
                        <input type="radio" id="star4" name="rating" value="4" />
                        <label for="star4" title="Tốt" class="star"></label>
                        <input type="radio" id="star3" name="rating" value="3" />
                        <label for="star3" title="Trung bình" class="star"></label>
                        <input type="radio" id="star2" name="rating" value="2" />
                        <label for="star2" title="Tệ" class="star"></label>
                        <input type="radio" id="star1" name="rating" value="1" />
                        <label for="star1" title="Rất tệ" class="star"></label>
                    </div>
                </div>
                <div class="submit-container">
                    <input type="submit" value="Gửi đánh giá" class="submit-btn">
                </div>
            </div>
        </form>
    </div>
</body>

</html>