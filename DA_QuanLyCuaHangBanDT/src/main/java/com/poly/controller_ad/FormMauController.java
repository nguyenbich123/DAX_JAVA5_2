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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.*;
import com.poly.repository.*;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/mau")
public class FormMauController {


	@Autowired
	 MauDAO mDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") Mau mau) {
		List<Mau> items = mDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formMau";
	}

	@RequestMapping("edit/{maMau}")
	public String edit(Model model, @ModelAttribute("item") Mau mau,@PathVariable("maMau") Integer maMau,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Mau item = mDao.findById(maMau).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<Mau> page = mDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formMau";
	}
	
	@RequestMapping("update")
	public String update(Model model, @Validated @ModelAttribute("item") Mau item,BindingResult result, @RequestParam("field") Optional<String> field,@RequestParam("p") Optional<Integer> p) throws IllegalStateException, IOException {

		List<Mau> y= mDao.findAll();
		
		for(Mau x: y) {
			if(item.getMauSac().equalsIgnoreCase(x.getMauSac())) {
				model.addAttribute("err", "Lỗi màu sắc đã tồn tại !");
				Sort sort = Sort.by(Direction.ASC, field.orElse("maMau"));	
		    	List<Mau> acc = mDao.findAll(sort);	
		    	model.addAttribute("field", field.orElse("maMau"));
			    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
			    System.out.println(field);
			    Page<Mau> page = mDao.findAll(pageable);
		        model.addAttribute("page", page);
			    return "/template/Admin/formMau";
			}
		}
		
		if(result.hasErrors()) {
			Sort sort = Sort.by(Direction.ASC, field.orElse("maMau"));
			model.addAttribute("field", field.orElse("maMau"));
			Pageable pageable = PageRequest.of(p.orElse(0),3,sort);
			Page<Mau> page = mDao.findAll(pageable);
	        model.addAttribute("page", page);
			return "/template/Admin/formMau";
		}
		mDao.save(item);
		return "redirect:/admin/mau/index";
	}

	
	@RequestMapping("delete/{maMau}")
	public String delete(Mau mau,@PathVariable("maMau") Integer maMau) throws IllegalStateException, IOException{
		
		mDao.deleteById(maMau);
		return "redirect:/admin/mau/index";
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
	public String bai5(Model model,@ModelAttribute("item") Mau mau,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("maMau"));	
    	List<Mau> acc = mDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("maMau"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<Mau> page = mDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formMau";
	}
}