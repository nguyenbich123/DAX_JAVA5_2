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

import com.poly.entity.HeDieuHanh;
import com.poly.repository.HeDieuHanhDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/hedieuhanh")
public class FormHeDieuHanhController {

	@Autowired
	HeDieuHanhDAO hdhDao;
	@Autowired
	ServletContext app;

	@RequestMapping("view")
	public String getAccount(Model model, @ModelAttribute("item") HeDieuHanh hedieuhanh) {
		List<HeDieuHanh> items = hdhDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formHeDieuHanh";
	}

	@RequestMapping("edit/{maHDH}")
	public String edit(Model model, @PathVariable("maHDH") Integer maHDH) {
		HeDieuHanh item = hdhDao.findById(maHDH).get();
		model.addAttribute("item", item);
		List<HeDieuHanh> items = hdhDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formHeDieuHanh";
	}

	@RequestMapping("update")
	public String update(HeDieuHanh item) throws IllegalStateException, IOException {
		hdhDao.save(item);
		return "redirect:/admin/hedieuhanh/edit/" + item.getMaHDH();
	}

	@RequestMapping("delete/{maHDH}")
	public String delete(@PathVariable("maHDH") Integer maHDH) {
		hdhDao.deleteById(maHDH);
		return "redirect:/template/Admin/formHeDieuHanh";
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
	public String bai5(Model model, @ModelAttribute("item") HeDieuHanh hedieuhanh, @RequestParam("field") Optional<String> field,
			@RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("maHDH"));
		List<HeDieuHanh> acc = hdhDao.findAll(sort);
		model.addAttribute("field", field.orElse("maHDH"));
		Pageable pageable = PageRequest.of(p.orElse(0), 3, sort);
		System.out.println(field);
		Page<HeDieuHanh> page = hdhDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formHeDieuHanh";
	}
}
