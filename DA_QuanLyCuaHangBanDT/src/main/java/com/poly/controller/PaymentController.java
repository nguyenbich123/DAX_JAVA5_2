package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("payment")
public class PaymentController {

	@GetMapping("view")
	public String getProduct() {
		return "/template/user/payment";
	}
}
