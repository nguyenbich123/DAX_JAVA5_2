package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("feedback")
public class FeedbackController {

	@GetMapping("view")
	public String getFeedback() {
		return "/template/user/feedback";
	}
}
