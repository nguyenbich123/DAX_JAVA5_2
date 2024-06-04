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

import com.poly.entity.DungLuong;
import com.poly.entity.Mau;
import com.poly.repository.MauDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/mau")
public class FormMauController {

	@Autowired
	 MauDAO mauDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getDungLuong(Model model,@ModelAttribute("item") Mau mau) {
		List<Mau> items = mauDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/fromMau";
	}

	@RequestMapping("edit/{maMau}")
	public String edit(Model model, @PathVariable("maMau") Integer maMau) {
		Mau item = mauDao.findById(maMau).get();
		model.addAttribute("item", item);
		List<Mau> items = mauDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formMau";
	}

	@RequestMapping("update")
	public String update(Mau item) throws IllegalStateException, IOException {
		mauDao.save(item);
		return "redirect:/admin/mau/edit/"+ item.getMaMau();
	}

	@RequestMapping("delete/{maMau}")
	public String delete(@PathVariable("maMau") Integer maMau) {
		mauDao.deleteById(maMau);
		return "redirect:/template/Admin/formMau";
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
	public String bai5(Model model,@ModelAttribute("item") Mau mau,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("maMau"));	
  	List<Mau> acc = mauDao.findAll(sort);	
  	model.addAttribute("field", field.orElse("maMau"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<Mau> page = mauDao.findAll(pageable);
	    model.addAttribute("page", page);
	    return "/template/Admin/formMau";
	}
}
