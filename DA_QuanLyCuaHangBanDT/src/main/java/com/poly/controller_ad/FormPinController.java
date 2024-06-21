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

import com.poly.entity.CNP;
import com.poly.entity.CameraSau;
import com.poly.entity.DLP;
import com.poly.entity.HTS;
import com.poly.entity.LP;
import com.poly.entity.PinSac;
import com.poly.repository.CNPDAO;
import com.poly.repository.DLPDAO;
import com.poly.repository.HTSDAO;
import com.poly.repository.LPDAO;
import com.poly.repository.PinSacDAO;
import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/ps")
public class FormPinController {
	@Autowired
	PinSacDAO psDao;
	@Autowired
	ServletContext app;
	//pinsac
		@Autowired
		CNPDAO cnpDao;
		@Autowired
		LPDAO lpDao;
		@Autowired
		HTSDAO htsDao;
		@Autowired
		DLPDAO dlpDao;
		
	@RequestMapping("view")
	public String getform(Model model,@ModelAttribute("pinsac") PinSac ps) {
		List<PinSac> items = psDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formPin";
	}

	@RequestMapping("edit/{idPin}")
	public String edit(Model model, @ModelAttribute("pinsac") PinSac mh,@PathVariable("idPin") Integer idPin,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		PinSac item = psDao.findById(idPin).get();
		model.addAttribute("pinsac", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<PinSac> page = psDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formPin";

	}
	
	@RequestMapping("update")
	public String update(Model model,@Validated @ModelAttribute("pinsac") PinSac item,BindingResult result,@RequestParam("field") Optional<String> field,@RequestParam("p") Optional<Integer> p) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			Sort sort = Sort.by(Direction.ASC, field.orElse("idPin"));
			model.addAttribute("field", field.orElse("idPin"));
			Pageable pageable = PageRequest.of(p.orElse(0),3,sort);
			Page<PinSac> page = psDao.findAll(pageable);
	        model.addAttribute("page", page);
			return "/template/Admin/formPin";
		}
		psDao.save(item);
		return "redirect:/admin/ps/index";
	}

	
	@RequestMapping("delete/{idPin}")
	public String delete(PinSac mh,@PathVariable("idPin") Integer idPin) throws IllegalStateException, IOException{		
		psDao.deleteById(idPin);
		return "redirect:/admin/ps/index";
	}	
	
	@GetMapping("index")
	public String bai5(Model model,@ModelAttribute("pinsac")PinSac psac,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idPin"));		
    	model.addAttribute("field", field.orElse("idPin"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<PinSac> page = psDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formPin";
	}
	
	@ModelAttribute("list_cnp")
	public Map<Integer, String> getps1() {
		Map<Integer, String> map = new HashMap<>();
		List<CNP> x = cnpDao.findAll();
		for (CNP c : x) {
			map.put(c.getIdcnp(), c.getCongNghePin());
		}
		return map;
	}

	@ModelAttribute("list_dlp")
	public Map<Integer, String> getps2() {
		Map<Integer, String> map = new HashMap<>();
		List<DLP> x = dlpDao.findAll();
		for (DLP c : x) {
			map.put(c.getIdDLP(), c.getDlPin());
		}
		return map;
	}
	
	@ModelAttribute("list_lp")
	public Map<Integer, String> getps3() {
		Map<Integer, String> map = new HashMap<>();
		List<LP> x = lpDao.findAll();
		for (LP c : x) {
			map.put(c.getIdlp(), c.getLoaiPin());
		}
		return map;
	}
	
	@ModelAttribute("list_hts")
	public Map<Integer, String> getps4() {
		Map<Integer, String> map = new HashMap<>();
		List<HTS> x = htsDao.findAll();
		for (HTS c : x) {
			map.put(c.getIdHTS(), c.getHoTroSac());
		}
		return map;
	}
}