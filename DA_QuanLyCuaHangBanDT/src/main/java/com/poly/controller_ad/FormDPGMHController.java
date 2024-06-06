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
import com.poly.entity.DPGMH;
import com.poly.repository.CNMHDAO;
import com.poly.repository.DPGMHDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/dpgmh")
public class FormDPGMHController {
	@Autowired
	DPGMHDAO dDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("view")
	public String getDungLuong(Model model,@ModelAttribute("item") DPGMH dl) {
		List<DPGMH> items = dDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formDPGMH";
	}

	@RequestMapping("edit/{idDPGMH}")
	public String edit(Model model, @PathVariable("idDPGMH") Integer idDPGMH) {
		DPGMH item = dDao.findById(idDPGMH).get();
		model.addAttribute("item", item);
		List<DPGMH> items = dDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formDPGMH";
	}

	@RequestMapping("update")
	public String update(DPGMH item) throws IllegalStateException, IOException {
		dDao.save(item);
		return "redirect:/admin/dpgmh/edit/"+ item.getDpg();
	}

	@RequestMapping("delete/{idDPGMH}")
	public String delete(@PathVariable("idDPGMH") Integer idDPGMH) {
		dDao.deleteById(idDPGMH);
		return "redirect:/template/Admin/dpgmh";
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
	public String bai5(Model model,@ModelAttribute("item") DPGMH dl,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idDPGMH"));	
   	List<DPGMH> acc = dDao.findAll(sort);	
   	model.addAttribute("field", field.orElse("idDPGMH"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 3,sort);
	    System.out.println(field);
	    Page<DPGMH> page = dDao.findAll(pageable);
	    model.addAttribute("page", page);
	    return "/template/Admin/formDPGMH";
	}
	
	
}
