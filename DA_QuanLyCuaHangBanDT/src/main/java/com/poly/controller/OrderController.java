package com.poly.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poly.entity.Account;
import com.poly.entity.ChiTietDonHang;
import com.poly.entity.DonHang;
import com.poly.entity.SanPham;
import com.poly.entity.TTDH;
import com.poly.repository.ChiTietDonHangDAO;
import com.poly.repository.ChiTietSanPhamDAO;
import com.poly.repository.DanhGiaDAO;
import com.poly.repository.DonHangDAO;
import com.poly.repository.SanPhamDAO;
import com.poly.repository.TTDH_DAO;
import com.poly.utils.SessionService;

@Controller
@RequestMapping("order")
public class OrderController {

	@Autowired
	SessionService session;

	@Autowired
	DonHangDAO donHangDAO;

	@Autowired
	ChiTietDonHangDAO ctdhDAO;

	@Autowired
	TTDH_DAO ttdhDAO;

	@Autowired
	DanhGiaDAO dgDAO;

	@Autowired
	SanPhamDAO spDAO;

	@Autowired
	ChiTietSanPhamDAO ctspDAO;

	@Autowired
	DonHangDAO dhDAO;

//    @GetMapping("view")
//    public String getOrder(Model model, 
//                           @RequestParam("p") Optional<Integer> p,
//                           @RequestParam("filterby") Optional<String> filterby) {
//        // Kiểm tra đăng nhập
//        Account account = (Account) session.get("account");
//        if (account == null) {
//            return "redirect:/account/login";
//        }
//
//        int pageNumber = p.orElse(0); // Trang hiện tại (mặc định là trang đầu tiên)
//        String status = filterby.orElse(null); // Trạng thái lọc
//
//        Pageable pageable = PageRequest.of(pageNumber, 2); // Số lượng đơn hàng trên mỗi trang
//
//        Page<DonHang> pageDH;
//        if (status == null || status.isEmpty()) {
//            // Nếu không có trạng thái nào được chọn, hiển thị tất cả đơn hàng
//            pageDH = donHangDAO.findByMaKH(account, pageable);
//        } else {
//            // Nếu có trạng thái được chọn, lọc đơn hàng theo trạng thái đó
//            pageDH = donHangDAO.findByMaKHAndTtdhTrangThai(account, status, pageable);
//        }
//        
//        // Kiểm tra nếu pageDH rỗng
//        if (pageDH.isEmpty()) {
//            model.addAttribute("message", "Không có đơn hàng nào.");
//        } else {
//            // Tạo một map để lưu danh sách chi tiết đơn hàng cho từng đơn hàng
//            Map<Integer, List<ChiTietDonHang>> chiTietDonHangMap = new HashMap<>();
//            for (DonHang donHang : pageDH) {
//                List<ChiTietDonHang> chitiet = ctdhDAO.findByMaDH(donHang);
//                chiTietDonHangMap.put(donHang.getMaDH(), chitiet);
//            
//            }
//            
//            if(dgDAO.daMuaVaDanhGiaSanPham(account, ))
//            
//            model.addAttribute("pageDH", pageDH);
//            model.addAttribute("chiTietDonHangMap", chiTietDonHangMap);
//        }
//
//        model.addAttribute("selectedStatus", status);
//        return "/template/user/order";
//    }

	@GetMapping("view")
	public String getOrder(Model model, @RequestParam("p") Optional<Integer> p,
			@RequestParam("filterby") Optional<String> filterby) {
		// Kiểm tra đăng nhập
		Account account = (Account) session.get("account");
		if (account == null) {
			return "redirect:/account/login";
		}

		int pageNumber = p.orElse(0); // Trang hiện tại (mặc định là trang đầu tiên)
		String status = filterby.orElse(null); // Trạng thái lọc

		Pageable pageable = PageRequest.of(pageNumber, 3); // Số lượng đơn hàng trên mỗi trang

		Page<DonHang> pageDH;
		if (status == null || status.isEmpty()) {
			// Nếu không có trạng thái nào được chọn, hiển thị tất cả đơn hàng
			pageDH = donHangDAO.findByMaKH(account, pageable);
		} else {
			// Nếu có trạng thái được chọn, lọc đơn hàng theo trạng thái đó
			pageDH = donHangDAO.findByMaKHAndTtdhTrangThai(account, status, pageable);
		}

		// Kiểm tra nếu pageDH rỗng
		if (pageDH.isEmpty()) {
			model.addAttribute("message", "Không có đơn hàng nào.");
		} else {
			// Tạo một map để lưu danh sách chi tiết đơn hàng cho từng đơn hàng
			Map<Integer, List<ChiTietDonHang>> chiTietDonHangMap = new HashMap<>();
			Map<Integer, Boolean> danhGiaMap = new HashMap<>();
			for (DonHang donHang : pageDH) {
				List<ChiTietDonHang> chitiet = ctdhDAO.findByMaDH(donHang);
				chiTietDonHangMap.put(donHang.getMaDH(), chitiet);
				// Kiểm tra và lưu kết quả cho từng chi tiết đơn hàng
				for (ChiTietDonHang ct : chitiet) {
					SanPham sanPham = ct.getMaCTSP().getMaSP();
					boolean daDanhGia = dgDAO.daMuaVaDanhGiaSanPham(account, sanPham);
					danhGiaMap.put(ct.getId_CTDH(), daDanhGia);
				}
			}

			model.addAttribute("pageDH", pageDH);
			model.addAttribute("chiTietDonHangMap", chiTietDonHangMap);
			model.addAttribute("danhGiaMap", danhGiaMap); // Thêm map này để lưu trạng thái đánh giá
		}

		model.addAttribute("selectedStatus", status);
		return "/template/user/order";
	}

	@RequestMapping("remove/{maDH}")
	public String cancelOrder(@PathVariable("maDH") Integer maDH, RedirectAttributes redirectAttributes) {
	    // Tìm đơn hàng theo mã đơn hàng
	    DonHang dh = donHangDAO.findByMaDH2(maDH);
	    
	    if (dh == null) {
	        redirectAttributes.addFlashAttribute("errorMessage", "Đơn hàng không tồn tại.");
	        return "redirect:/order/view";
	    }
	    
	    // Tìm trạng thái "Đã hủy"
	    Optional<TTDH> ttdh = ttdhDAO.findByTrangThai("Đã hủy");
	    
	    if (!ttdh.isPresent()) {
	        redirectAttributes.addFlashAttribute("errorMessage", "Trạng thái 'Đã hủy' không tồn tại.");
	        return "redirect:/order/view";
	    }
	    
	    // Cập nhật trạng thái đơn hàng
	    dh.setTtdh(ttdh.get());
	    
	    // Lưu thay đổi
	    donHangDAO.save(dh);
	    
	    redirectAttributes.addFlashAttribute("successMessage", "Đơn hàng đã được hủy thành công.");
	    return "redirect:/order/view";
	}

	@RequestMapping("filter")
	public String filter(Model model, @RequestParam("filterby") Optional<String> status,
			@RequestParam("p") Optional<Integer> p) {
		return getOrder(model, p, status);
	}

	@ModelAttribute("listTT")
	public List<TTDH> getAllTTDH() {
		return ttdhDAO.findAll();
	}
}
