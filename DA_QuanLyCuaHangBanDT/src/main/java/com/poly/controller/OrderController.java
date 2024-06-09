package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Account;
import com.poly.entity.ChiTietDonHang;
import com.poly.entity.DonHang;
import com.poly.repository.ChiTietDonHangDAO;
import com.poly.repository.DonHangDAO;
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

    @GetMapping("view")
    public String getOrder(Model model) {
        // Kiểm tra đăng nhập
        Account account = (Account) session.get("account");
        if (account == null) {
            return "redirect:/account/login";
        }

        int currentPage = 0; // Trang hiện tại (mặc định là trang đầu tiên)
        int pageSize = 5; // Số lượng đơn hàng trên mỗi trang
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<DonHang> pageDH = donHangDAO.findByMaKH(account, pageable);
        
        // Chúng ta cần kiểm tra nếu pageDH hoặc chi tiết đơn hàng rỗng
        if (pageDH.isEmpty()) {
            model.addAttribute("message", "Không có đơn hàng nào.");
        } else {
            List<ChiTietDonHang> chitiet = ctdhDAO.findByAccount(account);
            model.addAttribute("pageDH", pageDH);
            model.addAttribute("chitiet", chitiet);
        }

        return "/template/user/order";
    }


}
