package com.poly.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Account;
import com.poly.entity.CartItem;
import com.poly.entity.ChiTietDonHang;
import com.poly.entity.ChiTietSP;
import com.poly.entity.DonHang;
import com.poly.entity.GiamGia;
import com.poly.entity.PTTT;
import com.poly.entity.TTDH;
import com.poly.entity.TrangThaiTT;
import com.poly.repository.ChiTietDonHangDAO;
import com.poly.repository.ChiTietGioHangDAO;
import com.poly.repository.ChiTietSanPhamDAO;
import com.poly.repository.DonHangDAO;
import com.poly.repository.GiamGiaDAO;
import com.poly.repository.GioHangDAO;
import com.poly.repository.PTTT_DAO;
import com.poly.repository.TTDH_DAO;
import com.poly.repository.TrangThaiTTDAO;
import com.poly.service.VNPayService;
import com.poly.utils.SessionService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	private SessionService session;
	
	@Autowired
	GiamGiaDAO giamGiaDAO;
	
	@Autowired
	DonHangDAO donHangDAO;
	
	@Autowired
	PTTT_DAO ptttDAO;
	
	@Autowired
	TrangThaiTTDAO trangThaiTTDAO;
	
	@Autowired
	TTDH_DAO ttdhDAO;
	
	@Autowired
	TrangThaiTTDAO ttttDAO;
	
	@Autowired
	ChiTietGioHangDAO chiTietGioHangDAO;
	
	@Autowired
	GioHangDAO gioHangDAO;
	
	@Autowired
	ChiTietSanPhamDAO chiTietSanPhamDAO;

	@Autowired
	ChiTietDonHangDAO ctdhDAO;
	
	@Autowired
	ChiTietSanPhamDAO ctspDAO;
	
	@Autowired
	DonHangDAO dhDAO;
	
	@Autowired
	VNPayService vnPayService;
	
	@RequestMapping("pay")
	public String payment(@RequestParam("diaChiChon") String diaChiHT,
	                      @RequestParam("note") String note,
	                      @RequestParam("discountCode") String discountCode,
	                      @RequestParam("thanhTien") String tongTien,
	                      @RequestParam("phuongThuc") String phuongThuc,
	                      Model model) {

	    // Kiểm tra đăng nhập
	    Account currentAccount = (Account) session.get("account");
	    if (currentAccount == null) {
	        return "redirect:/account/login";
	    }

	    // Tạo đơn hàng mới
	    DonHang donHang = new DonHang();
	    donHang.setMaKH(currentAccount);
	    if(diaChiHT.isEmpty()) {
	    	donHang.setDiaChi(null);
	    }else {
	    	donHang.setDiaChi(diaChiHT);
	    }
	    donHang.setGhiChu(note);
	    donHang.setNgayTT(new Date());
	    donHang.setMaPT(findPhuongThuc(phuongThuc)); // Hàm tìm phương thức thanh toán
	    donHang.setTongTien(Double.valueOf(tongTien)); // Hàm tính tổng tiền
	    donHang.setMaGG(findDiscountCode(discountCode)); // Hàm tìm mã giảm giá
	    donHang.setTttt(findDefaultTrangThaiTT(phuongThuc)); // Hàm tìm trạng thái thanh toán mặc định
	    donHang.setTtdh(findDefaultTrangThaiDH()); // Hàm tìm trạng thái đơn hàng mặc định
	   
	    
	    // Lưu đơn hàng vào cơ sở dữ liệu
	    donHangDAO.save(donHang);
	    
	    if(findDiscountCode(discountCode) != null) {
	    	GiamGia gg = findDiscountCode(discountCode);
	    	gg.setSoLuong(gg.getSoLuong()-1);
	    }

	    List<CartItem> selectedItems = session.get("dssp");

	    ChiTietDonHang ctdh;
	    for(CartItem item : selectedItems) {
	        ctdh = new ChiTietDonHang();
	        ctdh.setMaCTSP(getChiTietSP(item.getMactsp()));
	        ctdh.setSoLuong(item.getSl());
	        ctdh.setGia(item.getGia());
	        ctdh.setMaDH(getDonHang(donHang.getMaDH()));
	        ctdhDAO.save(ctdh);

	        chiTietGioHangDAO.deleteByMaCTSP(item.getMactsp());
	    }

	    if(phuongThuc.equals("Thanh toán khi nhận hàng")) {
	    	return "/template/user/confirmation";
	    }
	    // Lưu mã đơn hàng và tổng tiền vào session
	    session.set("latestOrderId", donHang.getMaDH());
	    session.set("latestOrderTotal", donHang.getTongTien());
	    // Chuyển hướng tới phương thức submitOrder
	    return "redirect:/payment/submitOrder";
	}

	@RequestMapping("/submitOrder")
	public String submitOrder(HttpServletRequest request) {
	    Integer latestOrderId = session.get("latestOrderId");
	    Double latestOrderTotal = session.get("latestOrderTotal");

	    if (latestOrderId == null || latestOrderTotal == null) {
	        return "redirect:/payment"; // hoặc trang lỗi
	    }

	    String orderInfo = "Order ID: " + latestOrderId;
	    String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	    String vnpayUrl = vnPayService.createOrder(latestOrderTotal.intValue(), orderInfo, baseUrl);
	    return "redirect:" + vnpayUrl;
	}

	@RequestMapping("vnpay-payment")
	public String vnpayPayment(HttpServletRequest request, Model model) {
		int paymentStatus = vnPayService.orderReturn(request);

	    String orderInfo = request.getParameter("vnp_OrderInfo");
	    String paymentTime = request.getParameter("vnp_PayDate");
	    String transactionId = request.getParameter("vnp_TransactionNo");
	    String totalPrice = request.getParameter("vnp_Amount");

	    model.addAttribute("orderId", orderInfo);
	    model.addAttribute("totalPrice", totalPrice);
	    model.addAttribute("paymentTime", paymentTime);
	    model.addAttribute("transactionId", transactionId);

	    return paymentStatus == 1 ? "/template/user/orderSuccess" : "/template/user/orderFail";
	}

	
	
//	@PostMapping("/pay")
//	public String payment(@RequestParam("diachiHT") String diaChiHT,
//	                      @RequestParam("note") String note,
//	                      @RequestParam("discountCode") String discountCode,
//	                      @RequestParam("tongTien") String tongTien,
//	                      @RequestParam("phuongThuc") String phuongThuc,
//	                      Model model) {
//
//	    // Kiểm tra đăng nhập
//	    Account currentAccount = (Account) session.get("account");
//	    if (currentAccount == null) {
//	        return "redirect:/account/login";
//	    }
//
//	    // Tạo đơn hàng mới
//	    DonHang donHang = new DonHang();
//	    donHang.setMaKH(currentAccount);
//	    donHang.setDiaChi(diaChiHT);
//	    donHang.setGhiChu(note);
//	    donHang.setNgayTT(new Date());
//	    donHang.setMaPT(findPhuongThuc(phuongThuc)); // Hàm tìm phương thức thanh toán
//	    donHang.setTongTien(calculateTotalAmount(discountCode, Double.valueOf(tongTien))); // Hàm tính tổng tiền
//	    donHang.setMaGG(findDiscountCode(discountCode)); // Hàm tìm mã giảm giá
//	    donHang.setTttt(findDefaultTrangThaiTT(phuongThuc)); // Hàm tìm trạng thái thanh toán mặc định
//	    donHang.setTtdh(findDefaultTrangThaiDH()); // Hàm tìm trạng thái đơn hàng mặc định
//
//	    // Lưu đơn hàng vào cơ sở dữ liệu
//	    donHangDAO.save(donHang);
//	    
//	    List<CartItem> selectedItems =  session.get("dssp");
//	    
//	    ChiTietDonHang ctdh;
//	    ChiTietSP ctsp;
//	    for(CartItem item : selectedItems) {
//	    	ctdh = new ChiTietDonHang();
//	    	ctdh.setMaCTSP(getChiTietSP(item.getMactsp()));
//	    	ctdh.setSoLuong(item.getSl());
//	    	ctdh.setGia(item.getGia());
//	    	ctdh.setMaDH(getDonHang(donHang.getMaDH()));
//	    	ctdhDAO.save(ctdh);
//	    	
//	    	ctsp = ctspDAO.findByMaCTSP3(item.getMactsp());
//	    	ctsp.setSoluong(ctsp.getSoluong() -item.getSl());
//	    	ctspDAO.save(ctsp);
//	    	
//	    	chiTietGioHangDAO.deleteByMaCTSP(item.getMactsp());
//	    	
//	    }
//	    
//	    
//
//	    
//	    // Trả về view xác nhận thanh toán
//	    model.addAttribute("donHang", donHang);
//	    return "/template/user/confirmation";
//	}
	
	
	// Phương thức kiểm tra xem một chuỗi có phải là một số nguyên hay không
	private boolean isInteger(String s) {
	    try {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	    // Hàm tính tổng tiền (ví dụ)
	    private Double calculateTotalAmount(String discountCode, Double tong) {
	        double thanhTien = tong;
	        GiamGia a = findDiscountCode(discountCode);
	        if (a != null) {
	            thanhTien = tong - tong * a.getGiamGia();
	        }
	        return thanhTien;
	    }

	    // Hàm tìm mã giảm giá (ví dụ)
	    private GiamGia findDiscountCode(String discountCode) {
	        Optional<GiamGia> gg = giamGiaDAO.findByMaGG(discountCode);
	        return gg.orElse(null); // Trả về null nếu không có mã giảm giá
	    }

	    // Hàm tìm phương thức thanh toán (ví dụ)
	    private PTTT findPhuongThuc(String phuongThuc) {
	        Optional<PTTT> pt = ptttDAO.findByTenPT(phuongThuc);
	        return pt.orElse(null); // Trả về null nếu không tìm thấy phương thức thanh toán
	    }

	    // Hàm tìm trạng thái thanh toán mặc định (ví dụ)
	    private TrangThaiTT findDefaultTrangThaiTT(String phuongThuc) {
	    	Optional<TrangThaiTT> tttt = null;
	    	if(findPhuongThuc(phuongThuc).getTenPT().equals("Thanh toán khi nhận hàng")) {
	    		tttt = ttttDAO.findByTrangThai("Chưa thanh toán");
	    	}else {
	    		tttt = ttttDAO.findByTrangThai("Đã thanh toán");
	    	}
	         return tttt.orElse(null);
	    }

	    // Hàm tìm trạng thái đơn hàng mặc định (ví dụ)
	    private TTDH findDefaultTrangThaiDH() {
	    	Optional<TTDH> ttdh = ttdhDAO.findByTrangThai("Chờ xác nhận");
	        return ttdh.get();
	    }
	    
	    private ChiTietSP getChiTietSP(Integer mactsp) {
	    	Optional<ChiTietSP> ctsp = ctspDAO.findByMaCTSP2(mactsp);
	    	return ctsp.orElse(null);
	    }
	    
	    private DonHang getDonHang(Integer madh) {
	    	Optional<DonHang> dh = dhDAO.findByMaDH(madh);
	    	return dh.orElse(null);
	    }
	    
		
	    
	    
	    
}
