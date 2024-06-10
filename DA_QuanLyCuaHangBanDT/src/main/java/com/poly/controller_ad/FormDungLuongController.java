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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.DungLuong;
import com.poly.entity.Ram;
import com.poly.repository.DungLuongDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/dungluong")
public class FormDungLuongController {


	@Autowired
	 DungLuongDAO dlDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") DungLuong dl) {
		List<DungLuong> items = dlDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formDungLuong";
	}

	@RequestMapping("edit/{maDL}")
	public String edit(Model model, @ModelAttribute("item") DungLuong dl,@PathVariable("maDL") Integer maDL,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		DungLuong item = dlDao.findById(maDL).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 3);
	    System.out.println(field);
		Page<DungLuong> page = dlDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formDungLuong";
	}
	
	@RequestMapping("update")
	public String update(@Validated @ModelAttribute("item") DungLuong item, BindingResult result) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			return "/template/Admin/formDungLuong";
		}
		dlDao.save(item);
		return "redirect:/admin/dungluong/index";
	}

	
	@RequestMapping("delete/{maDL}")
	public String delete(Ram ram,@PathVariable("maDL") Integer maDL) throws IllegalStateException, IOException{
		
		dlDao.deleteById(maDL);
		return "redirect:/admin/dungluong/index";
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
	public String bai5(Model model,@ModelAttribute("item")DungLuong dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("maDL"));	
    	List<DungLuong> acc = dlDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("maDL"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<DungLuong> page = dlDao.findAll(pageable);
        model.addAttribute("page", page);
	    return "/template/Admin/formDungLuong";
	}
}