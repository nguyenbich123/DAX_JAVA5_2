package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Account;
import com.poly.service.CartService;
import com.poly.utils.SessionService;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	SessionService session;;

	@GetMapping("0")
	public String getIndex(Model model) {

        // Kiểm tra đăng nhập
        if(session.get("account") != null) {
        	// Lấy thông tin tài khoản người dùng
//            Account currentAccount = (Account)session.get("account");
//    		int sl = cartService.getTotalQuantity(currentAccount.getTenDN());
//    		model.addAttribute("sl", sl == null);
    		
        }
        return "/template/user/index";
	}
	
	
}
