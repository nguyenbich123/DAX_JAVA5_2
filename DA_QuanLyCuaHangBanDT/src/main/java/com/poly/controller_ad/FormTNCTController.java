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
@RequestMapping("admin/tnct")
public class FormTNCTController {


	@Autowired
	 TNCTDAO tnDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") TNCT dl) {
		List<TNCT> items = tnDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formTNCT";
	}

	@RequestMapping("edit/{idTNCT}")
	public String edit(Model model, @ModelAttribute("item") TNCT dl,@PathVariable("idTNCT") Integer idTNCT,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		TNCT item = tnDao.findById(idTNCT).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<TNCT> page = tnDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formTNCT";
	}
	
	@RequestMapping("update")
	public String update(Model model,@Validated @ModelAttribute("item") TNCT item, BindingResult result,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			Sort sort = Sort.by(Direction.ASC, field.orElse("idTNCT"));
			model.addAttribute("field", field.orElse("idTNCT"));
			Pageable pageable = PageRequest.of(p.orElse(0),3,sort);
			Page<TNCT> page = tnDao.findAll(pageable);
	        model.addAttribute("page", page);
	        return "/template/Admin/formTNCT";
		}
		tnDao.save(item);
		return "redirect:/admin/tnct/index";
	}

	
	@RequestMapping("delete/{idTNCT}")
	public String delete(TNCT dp,@PathVariable("idTNCT") Integer idTNCT) throws IllegalStateException, IOException{
		
		tnDao.deleteById(idTNCT);
		return "redirect:/admin/tnct/index";
	}

//	@ModelAttribute("list_ram")
//	public Map<Integer, String> getRoles() {
//		Map<Integer, String> map = new HashMap<>();
//
//		List<Ram> x = tnDao.findAll();
//		for (Ram c : x) {
//			map.put(c.getMaRam(), c.getRam());
//		}
//		return map;
//	}
	
	
	@GetMapping("index")
	public String bai5(Model model,@ModelAttribute("item")TNCT dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idTNCT"));	
    	List<TNCT> acc = tnDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("idTNCT"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<TNCT> page = tnDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formTNCT";
	}
}