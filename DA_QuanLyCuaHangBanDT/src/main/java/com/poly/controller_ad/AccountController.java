package com.poly.controller_ad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/account")
public class AccountController {

	@GetMapping("view")
	public String getAccount() {
		return "/template/Admin/account";
	}
}
