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
@RequestMapping("admin/mhr")
public class FormMHRController {


	@Autowired
	 MHRDAO rDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") MHR dl) {
		List<MHR> items = rDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formMHR";
	}

	@RequestMapping("edit/{idMHR}")
	public String edit(Model model, @ModelAttribute("item") MHR dl,@PathVariable("idMHR") Integer idMHR,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		MHR item = rDao.findById(idMHR).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<MHR> page = rDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formMHR";
	}
	
	@RequestMapping("update")
	public String update(Model model,@Validated @ModelAttribute("item") MHR item, BindingResult result,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) throws IllegalStateException, IOException {
		List<MHR> dl= rDao.findAll();
		
		for(MHR x: dl) {
			if(item.getMhRong().equalsIgnoreCase(x.getMhRong())) {
				model.addAttribute("err", "Lỗi màn hình rộng này đã tồn tại !");
				Sort sort = Sort.by(Direction.ASC, field.orElse("idMHR"));	
		    	model.addAttribute("field", field.orElse("idMHR"));
			    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
			    System.out.println(field);
			    Page<MHR> page = rDao.findAll(pageable);
		        model.addAttribute("page", page);
			    return "/template/Admin/formMHR";
			}
		}
		
		if(result.hasErrors()) {
			Sort sort = Sort.by(Direction.ASC, field.orElse("idMHR"));
			model.addAttribute("field", field.orElse("idMHR"));
			Pageable pageable = PageRequest.of(p.orElse(0),3,sort);
			Page<MHR> page = rDao.findAll(pageable);
	        model.addAttribute("page", page);
	        return "/template/Admin/formMHR";
		}
		rDao.save(item);
		return "redirect:/admin/mhr/index";
	}

	
	@RequestMapping("delete/{idMHR}")
	public String delete(MHR dp,@PathVariable("idMHR") Integer idMHR) throws IllegalStateException, IOException{
		
		rDao.deleteById(idMHR);
		return "redirect:/admin/mhr/index";
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
	public String bai5(Model model,@ModelAttribute("item")MHR dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
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