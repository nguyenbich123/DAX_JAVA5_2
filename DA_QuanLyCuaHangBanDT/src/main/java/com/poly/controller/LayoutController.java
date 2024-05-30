package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("layout")
public class LayoutController {

	@GetMapping("view")
	public String getLayout() {
		return "/template/user/layout";
	}
}
