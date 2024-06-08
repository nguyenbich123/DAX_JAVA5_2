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
@RequestMapping("admin/dlp")
public class FormDLPController {


	@Autowired
	 DLPDAO dDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") DLP dl) {
		List<DLP> items = dDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formDLP";
	}

	@RequestMapping("edit/{idDLP}")
	public String edit(Model model, @ModelAttribute("item") DLP dl,@PathVariable("idDLP") Integer idDLP,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		DLP item = dDao.findById(idDLP).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<DLP> page = dDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formDLP";
	}
	
	@RequestMapping("update")
	public String update( @ModelAttribute("item") DLP item) throws IllegalStateException, IOException {
		dDao.save(item);
		return "redirect:/admin/dlp/index";
	}

	
	@RequestMapping("delete/{idDLP}")
	public String delete(DLP dlp,@PathVariable("idDLP") Integer idDLP) throws IllegalStateException, IOException{
		
		dDao.deleteById(idDLP);
		return "redirect:/admin/dlp/index";
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
	public String bai5(Model model,@ModelAttribute("item")DLP dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idDLP"));	
    	List<DLP> acc = dDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("idDLP"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<DLP> page = dDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formDLP";
	}
}