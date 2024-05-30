package com.poly.controller_ad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/form_dungluong")
public class FormDungLuongController {

	@GetMapping("view")
	public String getForm() {
		return "/template/Admin/formDungLuong";
	}
}
