package com.poly.controller_ad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.repository.AccountDAO;
import com.poly.repository.DonHangDAO;
import com.poly.repository.SanPhamDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/home")
public class HomeAdminController {

	@Autowired
	SanPhamDAO spDao;
	@Autowired
	DonHangDAO dhDao;
	@Autowired
	AccountDAO acDao;
	@Autowired
	ServletContext app;

	@GetMapping("view")
	public String getForm(Model model) {
		List<Object> khtd = dhDao.findKHBytday(new Date());

		List<Object> khttData = dhDao.findKHByngayTT(new Date());
		model.addAttribute("datakh",khttData);
//		List<Object> dhttData = dhDao.findDHByngayTT(new Date());
//		model.addAttribute("datadh",dhttData);
//		List<Object> dtttData = dhDao.findDTByngayTT(new Date());
//		model.addAttribute("datadt",dtttData);
		
		return "/template/Admin/home";
	}

}
