package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.ChiTietSP;
import com.poly.entity.SanPham;
import com.poly.repository.ChiTietSanPhamDAO;
import com.poly.repository.SanPhamDAO;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	SanPhamDAO sanPhamDAO;
	

	@Autowired
	ChiTietSanPhamDAO ctspDAO;

	@GetMapping("view")
	public String getProduct(Model model) {
//		ChiTietSP sanPham = new ChiTietSP();
//		model.addAttribute("sanpham", sanPham);
		List<SanPham> listSanPham = sanPhamDAO.findAll();
		model.addAttribute("dsSanPham", listSanPham);
		return "/template/user/product";
	}
	
	
}
