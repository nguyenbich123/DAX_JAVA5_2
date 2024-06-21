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
import com.poly.entity.Hang;
import com.poly.entity.HeDieuHanh;
import com.poly.entity.ManHinh;
import com.poly.entity.PinSac;
import com.poly.entity.SanPham;
import com.poly.repository.CameraSauDAO;
import com.poly.repository.CameraTruocDAO;
import com.poly.repository.HangDAO;
import com.poly.repository.HeDieuHanhDAO;
import com.poly.repository.ManHinhDAO;
import com.poly.repository.PinSacDAO;
import com.poly.repository.SanPhamDAO;
import com.poly.utils.SessionService;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/sanpham")
public class SanPhamAdminController {
	@Autowired
	SanPhamDAO spDao; 
	@Autowired
	HeDieuHanhDAO hdhDao; 
	@Autowired
	CameraSauDAO csDao; 
	@Autowired
	CameraTruocDAO ctDao; 
	@Autowired
	PinSacDAO psDao; 
	@Autowired
	ManHinhDAO mhDao;
	@Autowired
	HangDAO hDao;
	@Autowired
	SessionService session;
	@Autowired
	ServletContext app;

	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") SanPham sp) {
		List<SanPham> items = spDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/sanpham";
	}
	
	@RequestMapping("add")
	public String add(Model model) {
		SanPham item =  new SanPham();
		model.addAttribute("item", item);
		List<SanPham> items = spDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formSanPham";
	}

	@RequestMapping("edit/{maSP}")
	public String edit(Model model, @PathVariable("maSP") Integer maSP) {
		SanPham item = spDao.findById(maSP).get();
		model.addAttribute("item", item);
		List<SanPham> items = spDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formSanPham";
	} 
	
	@RequestMapping("update")
	public String update(@Validated @ModelAttribute("item") SanPham item,BindingResult result) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			return "/template/Admin/formSanPham";
		}
		spDao.save(item);
		return "redirect:index";
	}

	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("maSP") Integer maSP) {
		spDao.deleteById(maSP);
		return "redirect:/index";
	}
	@GetMapping("/index")
	public String index(Model model,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {	
		Sort sort = Sort.by(Direction.ASC, field.orElse("maSP"));	
    	model.addAttribute("field", field.orElse("maSP"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 10,sort);
	    Page<SanPham> page = spDao.findAll(pageable);
	  
	    model.addAttribute("page", page);
	    return "/template/Admin/sanpham";
	}
	
	@RequestMapping("/search")
	public  String timkiem(Model model,@RequestParam("keywords") Optional<String> kw,@RequestParam("field") Optional<String> field,@RequestParam("p") Optional<Integer> p) {
		model.addAttribute("field", field.orElse("maSP"));
		String kwords = kw.orElse(session.get("keywords"));
		session.set("keywords", kwords);
		Pageable pageable = PageRequest.of(p.orElse(0), 10);
		Page<SanPham> page = spDao.findAllBykeyword("%"+kwords+"%", pageable);
		model.addAttribute("page", page);
		return "/template/Admin/sanpham";
	}
	
	@ModelAttribute("list_hdh")
	public Map<Integer, String> gethdh() {
		Map<Integer, String> map = new HashMap<>();
		List<HeDieuHanh> x = hdhDao.findAll();
		for (HeDieuHanh c : x) {
			map.put(c.getMaHDH(), c.getTenHDH());
		}
		return map;
	}
	
	@ModelAttribute("list_mh")
	public Map<Integer, String> getmh() {
		Map<Integer, String> map = new HashMap<>();
		List<ManHinh> x = mhDao.findAll();
		for (ManHinh c : x) {
			map.put(c.getIdManHinh(), c.getTenManhHinh());
		}
		return map;
	}
	
	@ModelAttribute("list_ps")
	public Map<Integer, String> getps() {
		Map<Integer, String> map = new HashMap<>();
		List<PinSac> x = psDao.findAll();
		for (PinSac c : x) {
			map.put(c.getIdPin(), c.getTenPin());
		}
		return map;
	}
	
	@ModelAttribute("list_ct")
	public Map<Integer, String> getct() {
		Map<Integer, String> map = new HashMap<>();
		List<CameraTruoc> x = ctDao.findAll();
		for (CameraTruoc c : x) {
			map.put(c.getIdCamTruoc(), c.getTenCamTruoc());		
		}
		return map;
	}
	
	@ModelAttribute("list_cs")
	public Map<Integer, String> getcs() {
		Map<Integer, String> map = new HashMap<>();
		List<CameraSau> x = csDao.findAll();
		for (CameraSau c : x) {
			map.put(c.getIdCamSau(), c.getTenCamSau());		
		}
		return map;
	}
	
	@ModelAttribute("list_h")
	public Map<Integer, String> geth() {
		Map<Integer, String> map = new HashMap<>();

		List<Hang> x = hDao.findAll();
		for (Hang c : x) {
			map.put(c.getMaHang(), c.getTenHang());
		}
		return map;
	}
	
//	public Map<Integer, String> getManHinhList(String attribute) {
//	    Map<Integer, String> map = new HashMap<>();
//
//	    List<ManHinh> x = mhDao.findAll();
//	    for (ManHinh c : x) {
//	        switch (attribute) {
//	            case "CNMH":
//	                map.put(c.getIdManHinh(), c.getCNMH().getCnmh());
//	                break;
//	            case "MHRong":
//	                map.put(c.getIdManHinh(), c.getMHR().getMhRong());
//	                break;
//	            case "DPG":
//	                map.put(c.getIdManHinh(), c.getDPG().getDpg());
//	                break;
//	        }
//	    }
//	    return map;
//	}
	
}
