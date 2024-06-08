package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class InformationController {
	@GetMapping("index")
	public String getFeedback() {
		return "/template/user/information";
	}
}
