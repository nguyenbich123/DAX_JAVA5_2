package com.poly.controller_ad;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;

import com.poly.entity.Account;
import com.poly.entity.CameraSau;
import com.poly.entity.CameraTruoc;
import com.poly.entity.Hang;
import com.poly.entity.HeDieuHanh;
import com.poly.entity.ManHinh;
import com.poly.entity.PinSac;
import com.poly.entity.SanPham;
import com.poly.entity.TrangThaiHD;
import com.poly.repository.CameraSauDAO;
import com.poly.repository.CameraTruocDAO;
import com.poly.repository.HangDAO;
import com.poly.repository.HeDieuHanhDAO;
import com.poly.repository.ManHinhDAO;
import com.poly.repository.PinSacDAO;
import com.poly.repository.SanPhamDAO;

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
	ServletContext app;

	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") SanPham sp) {
		List<SanPham> items = spDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/sanpham";
	}

	@RequestMapping("edit/{MaSP}")
	public String edit(Model model, @PathVariable("MaSP") Integer MaSP) {
		SanPham item = spDao.findById(MaSP).get();
		model.addAttribute("item", item);
		List<SanPham> items = spDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formSanPham";
	}
	
	@RequestMapping("create")
	public String create(SanPham item) throws IllegalStateException, IOException {
		spDao.save(item);
		return "redirect:index";
	}
	
	@RequestMapping("update")
	public String update(SanPham item) throws IllegalStateException, IOException {
		spDao.save(item);
		return "redirect:edit/"+ item.getMaSP();
	}

	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("MaSP") Integer MaSP) {
		spDao.deleteById(MaSP);
		return "redirect:/index";
	}
	@GetMapping("/index")
	public String bai5(Model model,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.DESC, field.orElse("maSP"));	
    	List<SanPham> sp = spDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("maSP"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 10,sort);
	    Page<SanPham> page = spDao.findAll(pageable);
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
	
	@ModelAttribute("list_h")
	public Map<Integer, String> geth() {
		Map<Integer, String> map = new HashMap<>();

		List<Hang> x = hDao.findAll();
		for (Hang c : x) {
			map.put(c.getMaHang(), c.getTenHang());
		}
		return map;
	}
	
	public Map<Integer, String> getManHinhList(String attribute) {
	    Map<Integer, String> map = new HashMap<>();

	    List<ManHinh> x = mhDao.findAll();
	    for (ManHinh c : x) {
	        switch (attribute) {
	            case "CNMH":
	                map.put(c.getIdManHinh(), c.getCNMH());
	                break;
	            case "MHRong":
	                map.put(c.getIdManHinh(), c.getMHRong());
	                break;
	            case "DPG":
	                map.put(c.getIdManHinh(), c.getDPG());
	                break;
	        }
	    }
	    return map;
	}
	
	@ModelAttribute("list_cnmh")
	public Map<Integer, String> getmh1() {
	    return getManHinhList("CNMH");
	}

	@ModelAttribute("list_mhr")
	public Map<Integer, String> getmh2() {
	    return getManHinhList("MHRong");
	}

	@ModelAttribute("list_dpg")
	public Map<Integer, String> getmh3() {
	    return getManHinhList("DPG");
	}
	
	
	public Map<Integer, String> getCamSau(String attribute) {
	    Map<Integer, String> map = new HashMap<>();

	    List<CameraSau> x = csDao.findAll();
	    for (CameraSau c : x) {
	        switch (attribute) {
	            case "DPG":
	                map.put(c.getIdCamSau(), c.getDPG());
	                break;
	            case "TN":
	                map.put(c.getIdCamSau(), c.getTinhNang());
	                break;
	        }
	    }
	    return map;
	}
	
	@ModelAttribute("list_cs_1")
	public Map<Integer, String> getcs1() {
	    return getCamSau("DPG");
	}

	@ModelAttribute("list_cs_2")
	public Map<Integer, String> getcs2() {
	    return getCamSau("TN");
	}
	
	@ModelAttribute("list_yesno")
	public Map<Boolean, String> getYesno() {
		Map<Boolean, String> map = new HashMap<>();
		map.put(false, "");
		map.put(true, "");
		return map;
	}
	
	
	public Map<Integer, String> getCamTruoc(String attribute) {
	    Map<Integer, String> map = new HashMap<>();

	    List<CameraTruoc> x = ctDao.findAll();
	    for (CameraTruoc c : x) {
	        switch (attribute) {
	            case "DPG":
	                map.put(c.getIdCamTruoc(), c.getDPG());
	                break;
	            case "TN":
	                map.put(c.getIdCamTruoc(), c.getTinhNang());
	                break;
	        }
	    }
	    return map;
	}
	
	@ModelAttribute("list_ct_1")
	public Map<Integer, String> getct1() {
	    return getCamTruoc("DPG");
	}

	@ModelAttribute("list_ct_2")
	public Map<Integer, String> getct2() {
	    return getCamTruoc("TN");
	}
	
	public Map<Integer, String> getPinSac(String attribute) {
	    Map<Integer, String> map = new HashMap<>();

	    List<PinSac> x = psDao.findAll();
	    for (PinSac c : x) {
	        switch (attribute) {
	            case "CNP":
	                map.put(c.getIdPin(), c.getCNP());
	                break;
	            case "DLP":
	            	map.put(c.getIdPin(), c.getDLPin());
	                break;
	            case "LP":
	            	map.put(c.getIdPin(), c.getLoaiPin());
	                break;
	            case "HTS":
	            	map.put(c.getIdPin(), c.getHoTroSac());
	                break;
	        }
	    }
	    return map;
	}
	
	@ModelAttribute("list_cnp")
	public Map<Integer, String> getps1() {
	    return getPinSac("CNP");
	}

	@ModelAttribute("list_dlp")
	public Map<Integer, String> getps2() {
	    return getPinSac("DLP");
	}
	
	@ModelAttribute("list_lp")
	public Map<Integer, String> getps3() {
	    return getPinSac("LP");
	}
	
	@ModelAttribute("list_hts")
	public Map<Integer, String> getps4() {
	    return getPinSac("HTS");
	}
}
