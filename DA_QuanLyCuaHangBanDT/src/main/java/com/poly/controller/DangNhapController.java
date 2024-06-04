package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Account;
import com.poly.repository.AccountDAO;
import com.poly.utils.CookieService;
import com.poly.utils.ParamService;
import com.poly.utils.SessionService;

@Controller
@RequestMapping("account")
public class DangNhapController {

	@Autowired
	CookieService cookieService;
	@Autowired
	ParamService paramService;
	@Autowired
	SessionService sessionService;

	@Autowired
	AccountDAO accountDAO;

	// Đăng nhập
	@GetMapping("login")
	public String getLogin(Model model, @ModelAttribute("tk") Account tk) {
		String user = cookieService.getValue("user");
		return "/template/login-form-02/login";
	}

//	@PostMapping("login")
//	public String postLogin(Model model, @Validated @ModelAttribute("tk") Account tk, BindingResult result) {
//		String un = paramService.getString("username", "");
//		String pw = paramService.getString("password", "");
		
//		String un = tk.getTenDN();
//		String pw = tk.getMatKhau();
//		boolean rm = paramService.getBoolean("remember", false);
//		// Kiểm tra thông tin đăng nhập
//		if (!result.hasErrors()) {
//			for (Account item : accountDAO.findAll()) {
//				if (un.equals(item.getTenDN()) && pw.equals(item.getMatKhau())) {
//					sessionService.set("username", un);
//					if (rm) {
//						cookieService.add("user", un, 10);
//					} else {
//						cookieService.remove("user");
//					}
//					
//				} else {
//					sessionService.remove("username");
//					model.addAttribute("message", "Sai thông tin!");
//					return "/template/login-form-02/login";
//				}
//			}
//			return "redirect:/home/index";
//		}else {
//			return "/template/login-form-02/login";
//		}
//
//		
//	}
	

	// Quên mật khẩu
	@GetMapping("forgot")
	public String getForgot(Model model, @ModelAttribute("tk") Account tk) {
		return "/template/login-form-02/forgot";
	}

	
	// Đăng ký
	@GetMapping("signup")
	public String getSignUp(Model model, @ModelAttribute("tk") Account tk) {
		return "/template/login-form-02/signup";
	}

	// Đặt lại mật khẩu
	@GetMapping("resetpass")
	public String getResetPass(Model model, @ModelAttribute("tk") Account tk) {
		return "/template/login-form-02/resetpass";
	}

}
