package com.poly.controller_ad;

import java.io.IOException;
import java.util.List;
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

import com.poly.entity.Hang;
import com.poly.entity.SanPham;
import com.poly.repository.HangDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/hang")
public class FormHangController {


	@Autowired
	 HangDAO hangDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") Hang hang) {
		List<Hang> items = hangDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formHang";
	}

	@RequestMapping("edit/{maHang}")
	public String edit(Model model, @ModelAttribute("item") Hang hang,@PathVariable("maHang") Integer maHang,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Hang item = hangDao.findById(maHang).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<Hang> page = hangDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formHang";
	}
	
	@RequestMapping("update")
	public String update(Hang item) throws IllegalStateException, IOException {
		hangDao.save(item);
		return "redirect:/admin/hang/index";
	}

	
	@RequestMapping("delete/{maHang}")
	public String delete(Hang hang,@PathVariable("maHang") Integer maHang) throws IllegalStateException, IOException{
		
		hangDao.deleteById(maHang);
		return "redirect:/admin/hang/index";
	}

//	@ModelAttribute("list_ram")
//	public Map<Integer, String> getRoles() {
//		Map<Integer, String> map = new HashMap<>();
//
//		List<Ram> x = rDao.findAll();
//		for (Ram c : x) {
//			map.put(c.getMaRam(), c.getRam());
//		}
//		return map;
//	}
	
	
	@GetMapping("index")
	public String bai5(Model model,@ModelAttribute("item") Hang hang,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("maHang"));	
    	List<Hang> acc = hangDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("maHang"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<Hang> page = hangDao.findAll(pageable);
	    model.addAttribute("page", page);
	    return "/template/Admin/formHang";
	}
}
