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
@RequestMapping("admin/tncs")
public class FormTNCSController {


	@Autowired
	 TNCSDAO tnDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") TNCS dl) {
		List<TNCS> items = tnDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formTNCS";
	}

	@RequestMapping("edit/{idTNCS}")
	public String edit(Model model, @ModelAttribute("item") TNCS dl,@PathVariable("idTNCS") Integer idTNCS,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		TNCS item = tnDao.findById(idTNCS).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<TNCS> page = tnDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formTNCS";
	}
	
	@RequestMapping("update")
	public String update(@Validated @ModelAttribute("item") TNCS item, BindingResult result) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			return "/template/Admin/formTNCS";
		}
		tnDao.save(item);
		return "redirect:/admin/tncs/index";
	}

	
	@RequestMapping("delete/{idTNCS}")
	public String delete(TNCS dp,@PathVariable("idTNCS") Integer idTNCS) throws IllegalStateException, IOException{
		
		tnDao.deleteById(idTNCS);
		return "redirect:/admin/tncs/index";
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
	public String bai5(Model model,@ModelAttribute("item")TNCS dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idTNCS"));	
    	List<TNCS> acc = tnDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("idTNCS"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<TNCS> page = tnDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formTNCS";
	}
}