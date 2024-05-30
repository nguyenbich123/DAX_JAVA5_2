package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController {

	@GetMapping("view")
	public String getProduct() {
		return "/template/user/product";
	}
}
