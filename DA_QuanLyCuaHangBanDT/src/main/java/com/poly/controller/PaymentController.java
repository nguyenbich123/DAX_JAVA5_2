package com.poly.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Account;
import com.poly.entity.CartItem;
import com.poly.entity.ChiTietDonHang;
import com.poly.entity.ChiTietGioHang;
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
import com.poly.utils.SessionService;

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

	
	
	@PostMapping("/pay")
	public String payment(@RequestParam("diachiHT") String diaChiHT,
	                      @RequestParam("note") String note,
	                      @RequestParam("discountCode") String discountCode,
	                      @RequestParam("tongTien") String tongTien,
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
	    donHang.setDiaChi(diaChiHT);
	    donHang.setGhiChu(note);
	    donHang.setNgayTT(new Date());
	    donHang.setMaPT(findPhuongThuc(phuongThuc)); // Hàm tìm phương thức thanh toán
	    donHang.setTongTien(calculateTotalAmount(discountCode, Double.valueOf(tongTien))); // Hàm tính tổng tiền
	    donHang.setMaGG(findDiscountCode(discountCode)); // Hàm tìm mã giảm giá
	    donHang.setTttt(findDefaultTrangThaiTT(phuongThuc)); // Hàm tìm trạng thái thanh toán mặc định
	    donHang.setTtdh(findDefaultTrangThaiDH()); // Hàm tìm trạng thái đơn hàng mặc định

	    // Lưu đơn hàng vào cơ sở dữ liệu
	    donHangDAO.save(donHang);
	    
	    List<CartItem> selectedItems =  session.get("dssp");
	    
	    ChiTietDonHang ctdh;
	    ChiTietSP ctsp;
	    for(CartItem item : selectedItems) {
	    	ctdh = new ChiTietDonHang();
	    	ctdh.setMaCTSP(getChiTietSP(item.getMactsp()));
	    	ctdh.setSoLuong(item.getSl());
	    	ctdh.setGia(item.getGia());
	    	ctdh.setMaDH(getDonHang(donHang.getMaDH()));
	    	ctdhDAO.save(ctdh);
	    	
	    	ctsp = ctspDAO.findByMaCTSP3(item.getMactsp());
	    	ctsp.setSoluong(ctsp.getSoluong() -item.getSl());
	    	ctspDAO.save(ctsp);
	    	
	    	chiTietGioHangDAO.deleteByMaCTSP(item.getMactsp());
	    	
	    }
	    
	    

	    
	    // Trả về view xác nhận thanh toán
	    model.addAttribute("donHang", donHang);
	    return "/template/user/confirmation";
	}
	
	
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
