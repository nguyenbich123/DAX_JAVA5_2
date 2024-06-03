package com.poly.controller;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.poly.repository.ChiTietGioHangDAO;
import com.poly.repository.ChiTietSanPhamDAO;

@Controller
@RequestMapping("product_detail")
public class DetailProductController {

	@Autowired
	ChiTietSanPhamDAO ctspDAO;
	
	@Autowired
	ChiTietGioHangDAO ctghDAO;
	
	@RequestMapping("view")
	public String getViewProduct() {
		return "/template/user/product_detail";
	}
	
	
//	@RequestMapping("/add/{id}")
//	public String add(@PathVariable("id") Integer id) {
//		Item sp = new Item();
//		sp = DB.items.get(id);
//		cart.add(id, sp);
//		return "redirect:/cart/view";
//	}
	
	
}
