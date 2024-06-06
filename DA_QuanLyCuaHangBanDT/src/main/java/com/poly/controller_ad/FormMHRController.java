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

import com.poly.entity.*;
import com.poly.repository.*;


import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/mhr")
public class FormMHRController {
	@Autowired
	MHRDAO rDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getDungLuong(Model model,@ModelAttribute("item") MHR dl) {
		List<MHR> items = rDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formMHR";
	}

	@RequestMapping("edit/{idMHR}")
	public String edit(Model model, @PathVariable("idMHR") Integer idMHR) {
		MHR item = rDao.findById(idMHR).get();
		model.addAttribute("item", item);
		List<MHR> items = rDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formMHR";
	}

	@RequestMapping("update")
	public String update(MHR item) throws IllegalStateException, IOException {
		rDao.save(item);
		return "redirect:/admin/mhr/edit/"+ item.getMhRong();
	}

	@RequestMapping("delete/{idMHR}")
	public String delete(@PathVariable("idMHR") Integer idMHR) {
		rDao.deleteById(idMHR);
		return "redirect:/template/Admin/mhr";
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
	public String bai5(Model model,@ModelAttribute("item") MHR dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idMHR"));	
   	List<MHR> acc = rDao.findAll(sort);	
   	model.addAttribute("field", field.orElse("idMHR"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<MHR> page = rDao.findAll(pageable);
	    model.addAttribute("page", page);
	    return "/template/Admin/formMHR";
	}
	
	
}