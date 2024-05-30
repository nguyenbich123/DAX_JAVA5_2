package com.poly.controller_ad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/formAccount")
public class FormAccountController {

	@GetMapping("view")
	public String getForm() {
		return "/template/Admin/formAccount";
	}	
}
