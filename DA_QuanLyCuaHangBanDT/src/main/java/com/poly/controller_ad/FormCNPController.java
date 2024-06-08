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
@RequestMapping("admin/cnp")
public class FormCNPController {


	@Autowired
	 CNPDAO cDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") CNP dl) {
		List<CNP> items = cDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formCNP";
	}

	@RequestMapping("edit/{idcnp}")
	public String edit(Model model, @ModelAttribute("item") CNP dl,@PathVariable("idcnp") Integer idcnp,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		CNP item = cDao.findById(idcnp).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<CNP> page = cDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formCNP";
	}
	
	@RequestMapping("update")
	public String update( @ModelAttribute("item") CNP item) throws IllegalStateException, IOException {
		cDao.save(item);
		return "redirect:/admin/cnp/index";
	}

	
	@RequestMapping("delete/{idcnp}")
	public String delete(DLP dlp,@PathVariable("idcnp") Integer idcnp) throws IllegalStateException, IOException{
		
		cDao.deleteById(idcnp);
		return "redirect:/admin/cnp/index";
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
	public String bai5(Model model,@ModelAttribute("item")CNP dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idcnp"));	
    	List<CNP> acc = cDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("idcnp"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<CNP> page = cDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formCNP";
	}
}