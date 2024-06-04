package com.poly.controller_ad;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.poly.entity.Role;
import com.poly.repository.RamDAO;

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
	public String edit(Model model, @PathVariable("maRam") Integer maRam) {
		Ram item = rDao.findById(maRam).get();
		model.addAttribute("item", item);
		List<Ram> items = rDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formRAM";
	}

	@RequestMapping("update")
	public String update(Ram item) throws IllegalStateException, IOException {
		rDao.save(item);
		return "redirect:/admin/ram/edit/"+ item.getMaRam();
	}

	@RequestMapping("delete/{maRam}")
	public String delete(@PathVariable("maRam") Integer maRam) {
		rDao.deleteById(maRam);
		return "redirect:/template/Admin/formRAM";
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
