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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.CameraSau;
import com.poly.entity.CameraTruoc;
import com.poly.entity.DPGCT;
import com.poly.entity.TNCT;
import com.poly.repository.CameraTruocDAO;
import com.poly.repository.DPGCTDAO;
import com.poly.repository.TNCTDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/camtruoc")
public class FormCamTruocController {

	@Autowired
	CameraTruocDAO ctDao;
	@Autowired
	ServletContext app;

		@Autowired
		DPGCTDAO dpgctDao;
		@Autowired
		TNCTDAO tnctDao;
		
		
	@RequestMapping("view")
	public String getform(Model model,@ModelAttribute("ct") CameraTruoc ct) {
		List<CameraTruoc> items = ctDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formCamTruoc";
	}

	@RequestMapping("edit/{idCamTruoc}")
	public String edit(Model model, @ModelAttribute("ct") CameraTruoc ct,@PathVariable("idCamTruoc") Integer idCamTruoc,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		CameraTruoc item = ctDao.findById(idCamTruoc).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<CameraTruoc> page = ctDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formCamTruoc";

	}
	
	@RequestMapping("update")
	public String update(@Validated @ModelAttribute("ct") CameraTruoc item, BindingResult result) throws IllegalStateException, IOException {
		if(result.hasErrors() ) {
			return "/template/Admin/formCamTruoc";
		}
		ctDao.save(item);
		return "redirect:/admin/camtruoc/index";
	}

	
	@RequestMapping("delete/{idCamTruoc}")
	public String delete(CameraTruoc ct,@PathVariable("idCamTruoc") Integer idCamTruoc) throws IllegalStateException, IOException{		
		ctDao.deleteById(idCamTruoc);
		return "redirect:/admin/camtruoc/index";
	}	
	
	@GetMapping("index")
	public String index(Model model,@ModelAttribute("ct") CameraTruoc ct,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idCamTruoc"));		
    	model.addAttribute("field", field.orElse("idCamTruoc"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<CameraTruoc> page = ctDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formCamTruoc";
	}
	
	@ModelAttribute("list_dpgct")
	public Map<Integer, String> getps1() {
		Map<Integer, String> map = new HashMap<>();
		List<DPGCT> x = dpgctDao.findAll();
		for (DPGCT c : x) {
			map.put(c.getIdDPGCT(), c.getDpg());
		}
		return map;
	}

	@ModelAttribute("list_tnct")
	public Map<Integer, String> getps2() {
		Map<Integer, String> map = new HashMap<>();
		List<TNCT> x = tnctDao.findAll();
		for (TNCT c : x) {
			map.put(c.getIdTNCT(), c.getTinhNang());
		}
		return map;
	}
	
}
