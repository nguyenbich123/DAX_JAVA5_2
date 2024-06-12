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
@RequestMapping("admin/dpgcs")
public class FormDPGCSController {


	@Autowired
	 DPGCSDAO csDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") DPGCS dl) {
		List<DPGCS> items = csDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formDPGCS";
	}

	@RequestMapping("edit/{idDPGCS}")
	public String edit(Model model, @ModelAttribute("item") DPGCS dl,@PathVariable("idDPGCS") Integer idDPGCS,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		DPGCS item = csDao.findById(idDPGCS).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<DPGCS> page = csDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formDPGCS";
	}
	
	@RequestMapping("update")
	public String update(Model model,@Validated @ModelAttribute("item") DPGCS item, BindingResult result,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) throws IllegalStateException, IOException {
	
		if(result.hasErrors()) {
			Sort sort = Sort.by(Direction.ASC, field.orElse("idDPGCS"));
			model.addAttribute("field", field.orElse("idDPGCS"));
			Pageable pageable = PageRequest.of(p.orElse(0),3,sort);
			Page<DPGCS> page = csDao.findAll(pageable);
	        model.addAttribute("page", page);
	        return "/template/Admin/formDPGCS";
		}
		csDao.save(item);
		return "redirect:/admin/dpgcs/index";
	}

	
	@RequestMapping("delete/{idDPGCS}")
	public String delete(DPGCS dp,@PathVariable("idDPGCS") Integer idDPGCS) throws IllegalStateException, IOException{
		
		csDao.deleteById(idDPGCS);
		return "redirect:/admin/dpgcs/index";
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
	public String bai5(Model model,@ModelAttribute("item")DPGCS dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idDPGCS"));	
    	List<DPGCS> acc = csDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("idDPGCS"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<DPGCS> page = csDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formDPGCS";
	}
}