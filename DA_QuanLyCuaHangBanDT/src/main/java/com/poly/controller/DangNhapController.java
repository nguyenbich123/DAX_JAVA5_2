package com.poly.controller;

import java.util.Optional;

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
import com.poly.utils.SessionService;

@Controller
@RequestMapping("account")
public class DangNhapController {

	@Autowired
	AccountDAO accountDao;

	@Autowired
	SessionService session;

	@GetMapping("login")
	public String showLoginForm(Model model) {
		model.addAttribute("tk", new Account());
		if(session.get("account") != null) {
			return "redirect:/home/index";
		}
		return "/template/login-form-02/login";
	}

	@PostMapping("login")
	public String login(Model model, @Validated @ModelAttribute("tk") Account tk, BindingResult result) {
		if (!result.hasErrors()) {
			return "/template/login-form-02/login";
		}
		
//		Optional<Account> account = accountDao.findById(tk.getTenDN());
//		if (account.get().getRole().equals("Admin")) {
//			return "redirect:/admin/home/view";
//		} else {
//			return "redirect:/home/index";
//		}

		try {
			Account account = accountDao.findById(tk.getTenDN()).orElseThrow(() -> new Exception("Account not found"));
			if (!account.getMatKhau().equals(tk.getMatKhau())) {
				model.addAttribute("message", "Login failed!");
			} else {
				session.set("account", account);
				if (account.getRole().getRole().equals("Admin")) {
					return "redirect:/admin/home/view";
				} else {
					return "redirect:/home/index";
				}
			}
		} catch (Exception e) {
			model.addAttribute("message", "Login failed!");
		}

		return "/template/login-form-02/login";
	}

	@GetMapping("logout")
	public String logout() {
		session.remove("account");
		return "redirect:/layout/view";
	}

	// Quên mật khẩu
	@GetMapping("forgot")
	public String getForgot() {
		return "/template/login-form-02/forgot";
	}

	// Đăng ký
	@GetMapping("signup")
	public String getSignUp() {
		return "/template/login-form-02/signup";
	}

	// Đặt lại mật khẩu
	@GetMapping("resetpass")
	public String getResetPass() {
		return "/template/login-form-02/resetpass";
	}

}
