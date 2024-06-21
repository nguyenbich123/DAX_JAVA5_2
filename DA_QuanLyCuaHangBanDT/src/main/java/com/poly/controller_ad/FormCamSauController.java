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
import com.poly.entity.DPGCS;
import com.poly.entity.ManHinh;
import com.poly.entity.TNCS;
import com.poly.repository.CameraSauDAO;
import com.poly.repository.DPGCSDAO;
import com.poly.repository.TNCSDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/camsau")
public class FormCamSauController {

	@Autowired
	CameraSauDAO csDao;
	@Autowired
	ServletContext app;

		@Autowired
		DPGCSDAO dpgcsDao;
		@Autowired
		TNCSDAO tncsDao;
		
		
	@RequestMapping("view")
	public String getform(Model model,@ModelAttribute("cs") CameraSau cs) {
		List<CameraSau> items = csDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formCamSau";
	}

	@RequestMapping("edit/{idCamSau}")
	public String edit(Model model, @ModelAttribute("cs") CameraSau cs,@PathVariable("idCamSau") Integer idCamSau,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		CameraSau item = csDao.findById(idCamSau).get();
		model.addAttribute("cs", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<CameraSau> page = csDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formCamSau";

	}
	
	@RequestMapping("update")
	public String update(Model model,@Validated @ModelAttribute("cs") CameraSau item, BindingResult result,@RequestParam("field") Optional<String> field,@RequestParam("p") Optional<Integer> p) throws IllegalStateException, IOException {
		if(result.hasErrors() ) {
			Sort sort = Sort.by(Direction.ASC, field.orElse("idCamSau"));
			model.addAttribute("field", field.orElse("idCamSau"));
			Pageable pageable = PageRequest.of(p.orElse(0),3,sort);
			Page<CameraSau> page = csDao.findAll(pageable);
	        model.addAttribute("page", page);
			return "/template/Admin/formCamSau";
		}
		
		csDao.save(item);
		return "redirect:/admin/camsau/index";
	}

	
	@RequestMapping("delete/{idCamSau}")
	public String delete(CameraSau ct,@PathVariable("idCamSau") Integer idCamSau) throws IllegalStateException, IOException{		
		csDao.deleteById(idCamSau);
		return "redirect:/admin/camsau/index";
	}	
	
	@GetMapping("index")
	public String index(Model model,@ModelAttribute("cs") CameraSau cs,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idCamSau"));		
    	model.addAttribute("field", field.orElse("idCamSau"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<CameraSau> page = csDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formCamSau";
	}
	
	@ModelAttribute("list_dpgcs")
	public Map<Integer, String> getps1() {
		Map<Integer, String> map = new HashMap<>();
		List<DPGCS> x = dpgcsDao.findAll();
		for (DPGCS c : x) {
			map.put(c.getIdDPGCS(), c.getDpg());
		}
		return map;
	}

	@ModelAttribute("list_tncs")
	public Map<Integer, String> getps2() {
		Map<Integer, String> map = new HashMap<>();
		List<TNCS> x = tncsDao.findAll();
		for (TNCS c : x) {
			map.put(c.getIdTNCS(), c.getTinhNang());
		}
		return map;
	}
	
}
