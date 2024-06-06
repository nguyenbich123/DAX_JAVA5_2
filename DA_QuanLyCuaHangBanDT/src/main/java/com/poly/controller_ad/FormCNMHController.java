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

import com.poly.entity.CNMH;
import com.poly.repository.CNMHDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/cnmh")
public class FormCNMHController {
	@Autowired
	CNMHDAO mDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getDungLuong(Model model,@ModelAttribute("item") CNMH dl) {
		List<CNMH> items = mDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formCNMH";
	}

	@RequestMapping("edit/{idCNMH}")
	public String edit(Model model, @PathVariable("idCNMH") Integer idCNMH) {
		CNMH item = mDao.findById(idCNMH).get();
		model.addAttribute("item", item);
		List<CNMH> items = mDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formCNMH";
	}

	@RequestMapping("update")
	public String update(CNMH item) throws IllegalStateException, IOException {
		mDao.save(item);
		return "redirect:/admin/cnmh/edit/"+ item.getCnmh();
	}

	@RequestMapping("delete/{idCNMH}")
	public String delete(@PathVariable("idCNMH") Integer idCNMH) {
		mDao.deleteById(idCNMH);
		return "redirect:/template/Admin/cnmh";
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
	public String bai5(Model model,@ModelAttribute("item") CNMH dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idCNMH"));	
   	List<CNMH> acc = mDao.findAll(sort);	
   	model.addAttribute("field", field.orElse("idCNMH"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<CNMH> page = mDao.findAll(pageable);
	    model.addAttribute("page", page);
	    return "/template/Admin/formCNMH";
	}
	
	
}
