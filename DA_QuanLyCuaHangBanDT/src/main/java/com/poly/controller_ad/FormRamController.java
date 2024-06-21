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
@RequestMapping("admin/ram")
public class FormRamController {


	@Autowired
	 RamDAO rDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") Ram ram) {
		List<Ram> items = rDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formRAM";
	}

	@RequestMapping("edit/{maRam}")
	public String edit(Model model, @ModelAttribute("item") Ram ram,@PathVariable("maRam") Integer maRam,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Ram item = rDao.findById(maRam).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<Ram> page = rDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formRAM";
	}
	
	@RequestMapping("update")
	public String update(Model model,@Validated @ModelAttribute("item") Ram item,BindingResult result,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) throws IllegalStateException, IOException {
		
		List<Ram> r= rDao.findAll();
		
		for(Ram x: r) {
			if(item.getRam().equalsIgnoreCase(x.getRam())) {
				model.addAttribute("err", "Lỗi ram đã tồn tại !");
				Sort sort = Sort.by(Direction.ASC, field.orElse("maRam"));	
		    	List<Ram> acc = rDao.findAll(sort);	
		    	model.addAttribute("field", field.orElse("maRam"));
			    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
			    System.out.println(field);
			    Page<Ram> page = rDao.findAll(pageable);
		        model.addAttribute("page", page);
			    return "/template/Admin/formRAM";
			}
		}
		
		if(result.hasErrors()) {
			Sort sort = Sort.by(Direction.ASC, field.orElse("maRam"));
			model.addAttribute("field", field.orElse("maRam"));
			Pageable pageable = PageRequest.of(p.orElse(0),3,sort);
			Page<Ram> page = rDao.findAll(pageable);
	        model.addAttribute("page", page);
	        return "/template/Admin/formRAM";
		}
		rDao.save(item);
		return "redirect:/admin/ram/index";
	}

	
	@RequestMapping("delete/{maRam}")
	public String delete(Ram ram,@PathVariable("maRam") Integer maRam) throws IllegalStateException, IOException{
		rDao.deleteById(maRam);
		return "redirect:/admin/ram/index";
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
	public String bai5(Model model,@ModelAttribute("item") Ram ram,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("maRam"));	
    	List<Ram> acc = rDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("maRam"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<Ram> page = rDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formRAM";
	}
}