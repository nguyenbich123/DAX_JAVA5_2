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

import com.poly.entity.CNP;
import com.poly.repository.*;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/cnp")
public class FormCNPController {
	@Autowired
	CNPDAO pDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getDungLuong(Model model,@ModelAttribute("item") CNP dl) {
		List<CNP> items = pDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formCNP";
	}

	@RequestMapping("edit/{idcnp}")
	public String edit(Model model, @PathVariable("idcnp") Integer idcnp) {
		CNP item = pDao.findById(idcnp).get();
		model.addAttribute("item", item);
		List<CNP> items = pDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formCNP";
	}

	@RequestMapping("update")
	public String update(CNP item) throws IllegalStateException, IOException {
		pDao.save(item);
		return "redirect:/admin/cnp/edit/"+ item.getCongNghePin();
	}

	@RequestMapping("delete/{idcnp}")
	public String delete(@PathVariable("idcnp") Integer idcnp) {
		pDao.deleteById(idcnp);
		return "redirect:/template/Admin/cnp";
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
	public String bai5(Model model,@ModelAttribute("item") CNP dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idcnp"));	
   	List<CNP> acc = pDao.findAll(sort);	
   	model.addAttribute("field", field.orElse("idcnp"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<CNP> page = pDao.findAll(pageable);
	    model.addAttribute("page", page);
	    return "/template/Admin/formCNP";
	}
	
	
}
