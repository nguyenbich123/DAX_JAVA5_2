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
@RequestMapping("admin/dpgmh")
public class FormDPGMHController {


	@Autowired
	 DPGMHDAO mDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") DPGMH dl) {
		List<DPGMH> items = mDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formDPGMH";
	}

	@RequestMapping("edit/{idDPGMH}")
	public String edit(Model model, @ModelAttribute("item") DPGMH dl,@PathVariable("idDPGMH") Integer idDPGMH,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		DPGMH item = mDao.findById(idDPGMH).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<DPGMH> page = mDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formDPGMH";
	}
	
	@RequestMapping("update")
	public String update(@Validated @ModelAttribute("item") DPGMH item , BindingResult result) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			return "/template/Admin/formDPGMH";
		}
		mDao.save(item);
		return "redirect:/admin/dpgmh/index";
	}

	
	@RequestMapping("delete/{idDPGMH}")
	public String delete(DPGMH dp,@PathVariable("idDPGMH") Integer idDPGMH) throws IllegalStateException, IOException{
		
		mDao.deleteById(idDPGMH);
		return "redirect:/admin/dpgmh/index";
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
	public String bai5(Model model,@ModelAttribute("item")DPGMH dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idDPGMH"));	
    	List<DPGMH> acc = mDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("idDPGMH"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<DPGMH> page = mDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formDPGMH";
	}
}