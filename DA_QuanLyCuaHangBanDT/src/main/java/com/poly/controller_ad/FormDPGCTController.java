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
@RequestMapping("admin/dpgct")
public class FormDPGCTController {


	@Autowired
	 DPGCTDAO csDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") DPGCT dl) {
		List<DPGCT> items = csDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formDPGCT";
	}

	@RequestMapping("edit/{idDPGCT}")
	public String edit(Model model, @ModelAttribute("item") DPGCT dl,@PathVariable("idDPGCT") Integer idDPGCT,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		DPGCT item = csDao.findById(idDPGCT).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<DPGCT> page = csDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formDPGCT";
	}
	
	@RequestMapping("update")
	public String update(@Validated @ModelAttribute("item") DPGCT item, BindingResult result) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			return "/template/Admin/formDPGCT";
		}
		csDao.save(item);
		return "redirect:/admin/dpgct/index";
	}

	
	@RequestMapping("delete/{idDPGCS}")
	public String delete(DPGCT dp,@PathVariable("idDPGCT") Integer idDPGCT) throws IllegalStateException, IOException{
		
		csDao.deleteById(idDPGCT);
		return "redirect:/admin/dpgct/index";
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
	public String bai5(Model model,@ModelAttribute("item")DPGCT dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idDPGCT"));	
    	List<DPGCT> acc = csDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("idDPGCT"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<DPGCT> page = csDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formDPGCT";
	}
}