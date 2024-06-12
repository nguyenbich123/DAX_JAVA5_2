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

import com.poly.entity.CNMH;
import com.poly.entity.DPGMH;
import com.poly.entity.MHR;
import com.poly.entity.ManHinh;
import com.poly.repository.CNMHDAO;
import com.poly.repository.DPGMHDAO;
import com.poly.repository.MHRDAO;
import com.poly.repository.ManHinhDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/mh")
public class ManHinhController {
	@Autowired
	ManHinhDAO mhDao;
	@Autowired
	ServletContext app;
	// màn hình 
		@Autowired
		CNMHDAO cnmhDao;
		@Autowired
		DPGMHDAO dpgDao;
		@Autowired
		MHRDAO mhrDao;
		
	@RequestMapping("view")
	public String getform(Model model,@ModelAttribute("mhc") ManHinh mh) {
		List<ManHinh> items = mhDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formManHinh";
	}

	@RequestMapping("edit/{idManHinh}")
	public String edit(Model model, @ModelAttribute("mhc") ManHinh mh,@PathVariable("idManHinh") Integer idManHinh,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		ManHinh item = mhDao.findById(idManHinh).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<ManHinh> page = mhDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formManHinh";
	}
	
	@RequestMapping("update")
	public String update(@Validated @ModelAttribute("mhc") ManHinh item,BindingResult result) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			return "/template/Admin/formManHinh";
		}
		mhDao.save(item);
		return "redirect:/admin/mh/index";
	}

	
	@RequestMapping("delete/{idManHinh}")
	public String delete(ManHinh mh,@PathVariable("idManHinh") Integer idManHinh) throws IllegalStateException, IOException{		
		mhDao.deleteById(idManHinh);
		return "redirect:/admin/mh/index";
	}	
	
	@GetMapping("index")
	public String bai5(Model model,@ModelAttribute("mhc")ManHinh mhinh,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idManHinh"));	
    	List<ManHinh> mh = mhDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("idManHinh"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<ManHinh> page = mhDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formManHinh";
	}
	
	@ModelAttribute("list_cnmh")
	public Map<Integer, String> getmh1() {
		Map<Integer, String> map = new HashMap<>();
		List<CNMH> x = cnmhDao.findAll();
		for (CNMH c : x) {
			map.put(c.getIdCNMH(), c.getCnmh());
		}
		return map;
	}

	@ModelAttribute("list_mhr")
	public Map<Integer, String> getmh2() {
		Map<Integer, String> map = new HashMap<>();
		List<MHR> x = mhrDao.findAll();
		for (MHR c : x) {
			map.put(c.getIdMHR(), c.getMhRong());
		}
		return map;
	}

	@ModelAttribute("list_dpg")
	public Map<Integer, String> getmh3() {
		Map<Integer, String> map = new HashMap<>();
		List<DPGMH> x = dpgDao.findAll();
		for (DPGMH c : x) {
			map.put(c.getIdDPGMH(), c.getDpg());
		}
		return map;
	}
}