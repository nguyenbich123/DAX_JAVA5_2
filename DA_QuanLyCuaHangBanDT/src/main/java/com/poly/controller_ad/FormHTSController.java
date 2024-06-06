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
@RequestMapping("admin/hts")
public class FormHTSController {
	@Autowired
	HTSDAO hDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getDungLuong(Model model,@ModelAttribute("item") HTS dl) {
		List<HTS> items = hDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formHTS";
	}

	@RequestMapping("edit/{idHTS}")
	public String edit(Model model, @PathVariable("idHTS") Integer idHTS) {
		HTS item = hDao.findById(idHTS).get();
		model.addAttribute("item", item);
		List<HTS> items = hDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formHTS";
	}

	@RequestMapping("update")
	public String update(HTS item) throws IllegalStateException, IOException {
		hDao.save(item);
		return "redirect:/admin/hts/edit/"+ item.getHoTroSac();
	}

	@RequestMapping("delete/{idHTS}")
	public String delete(@PathVariable("idHTS") Integer idHTS) {
		hDao.deleteById(idHTS);
		return "redirect:/template/Admin/hts";
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
	public String bai5(Model model,@ModelAttribute("item") HTS dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idHTS"));	
   	List<HTS> acc = hDao.findAll(sort);	
   	model.addAttribute("field", field.orElse("idHTS"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<HTS> page = hDao.findAll(pageable);
	    model.addAttribute("page", page);
	    return "/template/Admin/formHTS";
	}
	
	
}

