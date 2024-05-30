package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account")
public class DangNhapController {
	
	//Đăng nhập
	@GetMapping("login")
	public String getLogin() {
		return "/template/login-form-02/login";
	}
	
	//Quên mật khẩu
	@GetMapping("forgot")
	public String getForgot() {
		return "/template/login-form-02/forgot";
	}
	
	//Đăng ký
	@GetMapping("signup")
	public String getSignUp() {
		return "/template/login-form-02/signup";
	}
	
	//Đặt lại mật khẩu
	@GetMapping("resetpass")
	public String getResetPass() {
		return "/template/login-form-02/resetpass";
	}
	
}
