package com.poly.controller_ad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/chitietsanpham")
public class CTSPController {

	@GetMapping("view")
	public String getAccount() {
		return "/template/Admin/CTSP";
	}
}
