package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("detail_product")
public class DetailProductController {

	@GetMapping("view")
	public String getViewProduct() {
		return "/template/user/detail_product";
	}
}
