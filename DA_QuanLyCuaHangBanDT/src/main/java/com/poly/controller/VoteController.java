package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vote")
public class VoteController {

	@GetMapping("view")
	public String getProduct() {
		return "/template/user/vote";
	}
}
