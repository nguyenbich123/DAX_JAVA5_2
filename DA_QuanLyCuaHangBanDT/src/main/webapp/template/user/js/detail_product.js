/*

TemplateMo 559 Zay Shop

https://templatemo.com/tm-559-zay-shop

*/

'use strict';
$(document).ready(function() {

    // Accordion
    var all_panels = $('.templatemo-accordion > li > ul').hide();

    $('.templatemo-accordion > li > a').click(function() {
        console.log('Hello world!');
        var target =  $(this).next();
        if(!target.hasClass('active')){
            all_panels.removeClass('active').slideUp();
            target.addClass('active').slideDown();
        }
      return false;
    });
    // End accordion

    // Product detail
    $('.product-links-wap a').click(function(){
      var this_src = $(this).children('img').attr('src');
      $('#product-detail').attr('src',this_src);
      return false;
    });
    $('#btn-minus').click(function(){
      var val = $("#var-value").html();
      val = (val=='1')?val:val-1;
      $("#var-value").html(val);
      $("#product-quantity").val(val);
      // Ẩn thông báo nếu số lượng sản phẩm chưa đạt đến mức tối đa
      $("#maxQuantityMessage").addClass("d-none");
      return false;
    });
    $('#btn-plus').click(function(){
      var val = parseInt($("#var-value").html()); // Chuyển đổi val thành số nguyên
      var sanPhamSoLuong = parseInt($("#sanPhamSoLuong").text()); // Lấy giá trị số lượng từ thẻ HTML
      console.log(sanPhamSoLuong)
      // So sánh val với giá trị của sanPhamSoLuong
      if (val === sanPhamSoLuong) {
        $("#maxQuantityMessage").removeClass("d-none");
          // Nếu val bằng với giá trị số lượng của sản phẩm, không thực hiện thêm 1 vào val
          // và kết thúc hàm
          return false;
      }
  
      // Nếu val không bằng giá trị số lượng của sản phẩm, thì tăng val lên 1
      val++;
      $("#var-value").html(val);
      $("#product-quantity").val(val);

      // Ẩn thông báo nếu số lượng sản phẩm chưa đạt đến mức tối đa
      $("#maxQuantityMessage").addClass("d-none");
      return false;
  });
  
  
    $('.btn-size').click(function(){
      var this_val = $(this).html();
      $("#product-size").val(this_val);
      $(".btn-size").removeClass('btn-secondary');
      $(".btn-size").addClass('btn-warning');
      $(this).removeClass('btn-warning');
      $(this).addClass('btn-secondary');
      return false;
    });
    // End roduct detail

});
