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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Account;
import com.poly.entity.ChiTietDonHang;
import com.poly.entity.DonHang;
import com.poly.entity.TTDH;
import com.poly.repository.ChiTietDonHangDAO;
import com.poly.repository.DonHangDAO;
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

    @GetMapping("view")
    public String getOrder(Model model, 
                           @RequestParam("p") Optional<Integer> p,
                           @RequestParam("filterby") Optional<String> filterby) {
        // Kiểm tra đăng nhập
        Account account = (Account) session.get("account");
        if (account == null) {
            return "redirect:/account/login";
        }

        int pageNumber = p.orElse(0); // Trang hiện tại (mặc định là trang đầu tiên)
        String status = filterby.orElse(null); // Trạng thái lọc

        Pageable pageable = PageRequest.of(pageNumber, 2); // Số lượng đơn hàng trên mỗi trang

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
            for (DonHang donHang : pageDH) {
                List<ChiTietDonHang> chitiet = ctdhDAO.findByMaDH(donHang);
                chiTietDonHangMap.put(donHang.getMaDH(), chitiet);
            }
            
            model.addAttribute("pageDH", pageDH);
            model.addAttribute("chiTietDonHangMap", chiTietDonHangMap);
        }

        model.addAttribute("selectedStatus", status);
        return "/template/user/order";
    }

    
    @RequestMapping("filter")
    public String filter(Model model, 
                         @RequestParam("filterby") Optional<String> status,
                         @RequestParam("p") Optional<Integer> p) {
        return getOrder(model, p, status);
    }
    
    @ModelAttribute("listTT")
    public List<TTDH> getAllTTDH() {
        return ttdhDAO.findAll();
    }
}
