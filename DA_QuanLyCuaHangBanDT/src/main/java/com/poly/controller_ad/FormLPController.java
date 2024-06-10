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
@RequestMapping("admin/lp")
public class FormLPController {


	@Autowired
	 LPDAO lDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") LP dl) {
		List<LP> items = lDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formLP";
	}

	@RequestMapping("edit/{idlp}")
	public String edit(Model model, @ModelAttribute("item") LP dl,@PathVariable("idlp") Integer idlp,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		LP item = lDao.findById(idlp).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<LP> page = lDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formLP";
	}
	
	@RequestMapping("update")
	public String update(@Validated @ModelAttribute("item") LP item, BindingResult result) throws IllegalStateException, IOException {
		if(result.hasErrors() ) {
			return "/template/Admin/formLP";
		}
		lDao.save(item);
		return "redirect:/admin/lp/index";
	}

	
	@RequestMapping("delete/{idlp}")
	public String delete(LP dp,@PathVariable("idlp") Integer idlp) throws IllegalStateException, IOException{
		
		lDao.deleteById(idlp);
		return "redirect:/admin/lp/index";
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
	public String bai5(Model model,@ModelAttribute("item")LP dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idlp"));	
    	List<LP> acc = lDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("idlp"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<LP> page = lDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formLP";
	}
}