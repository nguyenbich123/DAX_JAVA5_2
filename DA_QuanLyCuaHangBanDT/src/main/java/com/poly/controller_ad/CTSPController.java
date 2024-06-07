package com.poly.controller_ad;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.ChiTietSP;
import com.poly.entity.DungLuong;
import com.poly.entity.HeDieuHanh;
import com.poly.entity.Mau;
import com.poly.entity.Ram;
import com.poly.entity.SanPham;
import com.poly.repository.ChiTietSanPhamDAO;
import com.poly.repository.DungLuongDAO;
import com.poly.repository.MauDAO;
import com.poly.repository.RamDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/ctsp")
public class CTSPController {
	@Autowired
	ChiTietSanPhamDAO ctspDao; 
	@Autowired
	MauDAO mDao; 
	@Autowired
	DungLuongDAO dlDao; 
	@Autowired
	RamDAO rDao;
	@Autowired
	ServletContext app;

	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") ChiTietSP ctsp) {
		List<ChiTietSP> items = ctspDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/CTSP";
	}

	@RequestMapping("edit/{MaCTSP}")
	public String edit(Model model, @PathVariable("MaCTSP") Integer MaCTSP) {
		ChiTietSP item = ctspDao.findById(MaCTSP).get();
		model.addAttribute("item", item);
		List<ChiTietSP> items = ctspDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formCTSP";
	}
	
	@RequestMapping("create")
	public String create(ChiTietSP item) throws IllegalStateException, IOException {
		ctspDao.save(item);
		return "redirect:index";
	}
	
	@RequestMapping("update")
	public String update(ChiTietSP item) throws IllegalStateException, IOException {
		ctspDao.save(item);
		return "redirect:edit/"+ item.getMaCTSP();
	}

	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("MaCTSP") Integer MaCTSP) {
		ctspDao.deleteById(MaCTSP);
		return "redirect:/index";
	}
	@GetMapping("/index/{maSP}")
	public String bai5(Model model,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p,@PathVariable("maSP") Integer maSP) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("maCTSP"));	
    	List<ChiTietSP> sp = ctspDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("maCTSP"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 10,sort);
	    Page<ChiTietSP> page = ctspDao.findAll(pageable);
	    model.addAttribute("page", page);
	    return "/template/Admin/CTSP";
	}
	
	@ModelAttribute("list_m")
	public Map<Integer, String> getmau() {
		Map<Integer, String> map = new HashMap<>();
		List<Mau> x = mDao.findAll();
		for (Mau c : x) {
			map.put(c.getMaMau(), c.getMauSac());
		}
		return map;
	}
	
	@ModelAttribute("list_dl")
	public Map<Integer, String> getdl() {
		Map<Integer, String> map = new HashMap<>();
		List<DungLuong> x = dlDao.findAll();
		for (DungLuong c : x) {
			map.put(c.getMaDL(), c.getDungLuong());
		}
		return map;
	}
	
	@ModelAttribute("list_r")
	public Map<Integer, String> getr() {
		Map<Integer, String> map = new HashMap<>();
		List<Ram> x = rDao.findAll();
		for (Ram c : x) {
			map.put(c.getMaRam(), c.getRam());
		}
		return map;
	}
}
