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
import com.poly.entity.Role;
import com.poly.entity.TrangThaiHD;
import com.poly.repository.AccountDAO;
import com.poly.repository.RoleDAO;
import com.poly.repository.TrangThaiHoatDongDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin")
public class AccountController {
	@Autowired
	AccountDAO accDao; 
	@Autowired
	RoleDAO roleDao; 
	@Autowired
	TrangThaiHoatDongDAO ttDao;
	@Autowired
	ServletContext app;

	@RequestMapping("account/view")
	public String getAccount(Model model,@ModelAttribute("item") Account ac) {
		List<Account> items = accDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/account";
	}

	@RequestMapping("account/edit/{tenDN}")
	public String edit(Model model, @PathVariable("tenDN") String tenDN) {
		Account item = accDao.findById(tenDN).get();
		model.addAttribute("item", item);
		List<Account> items = accDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formAccount";
	}

	@RequestMapping("account/update")
	public String update(Account item) throws IllegalStateException, IOException {
		accDao.save(item);
		return "redirect:/admin/account/edit/"+ item.getTenDN();
	}

	@RequestMapping("account/delete/{tenDN}")
	public String delete(@PathVariable("tenDN") String tenDN) {
		accDao.deleteById(tenDN);
		return "redirect:/template/Admin/account";
	}

	@ModelAttribute("list_role")
	public Map<Integer, String> getRoles() {
		Map<Integer, String> map = new HashMap<>();

		List<Role> roles = roleDao.findAll();
		for (Role c : roles) {
			map.put(c.getIdrole(), c.getRoles());
		}
		return map;
	}
	
	@ModelAttribute("list_tthd")
	public Map<Integer, String> gettthd() {
		Map<Integer, String> map = new HashMap<>();

		List<TrangThaiHD> tthds = ttDao.findAll();
		for (TrangThaiHD c : tthds) {
			map.put(c.getIdtthd(), c.getTrangThai());
		}
		return map;
	}
	
	@GetMapping("account/index")
	public String bai5(Model model,@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.DESC, field.orElse("tenDN"));	
    	List<Account> acc = accDao.findAll(sort);	
    	model.addAttribute("field", field.orElse("tenDN"));
	    Pageable pageable = PageRequest.of(p.orElse(0), 10,sort);
	    System.out.println(field);
	    Page<Account> page = accDao.findAll(pageable);
	    model.addAttribute("page", page);
	    return "/template/Admin/account";
	}
}
