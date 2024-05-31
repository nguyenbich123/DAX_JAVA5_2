package com.poly.controller_ad;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("create")
	public String create(Account item, @RequestParam("photo_file") MultipartFile img)
			throws IllegalStateException, IOException {
		String filename = img.getOriginalFilename();
		// Kiểm tra và tạo thư mục images nếu nó không tồn tại
		File uploadFolder = new File(app.getRealPath("/images/"));
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}

		// Tạo file trong thư mục images
		File destFile = new File(uploadFolder, filename);

		// Lưu trữ file vào thư mục đã xác định
		img.transferTo(destFile);
		item.setImg(filename);
		accDao.save(item);
		return "redirect:/account/index";
	}

	@RequestMapping("update")
	public String update(Account item, @RequestParam("photo_file") MultipartFile img)
			throws IllegalStateException, IOException {
		String filename = img.getOriginalFilename();
		// Kiểm tra và tạo thư mục images nếu nó không tồn tại
		File uploadFolder = new File(app.getRealPath("/images/"));
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}

		// Tạo file trong thư mục images
		File destFile = new File(uploadFolder, filename);

		// Lưu trữ file vào thư mục đã xác định
		img.transferTo(destFile);
		item.setImg(filename);
		accDao.save(item);
		return "redirect:/account/edit/" + item.getTenDN();
	}

	@RequestMapping("delete/{username}")
	public String delete(@PathVariable("username") String username) {
		accDao.deleteById(username);
		return "redirect:/account/index";
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
			map.put(c.getId_THHD(), c.getTrangThai());
		}
		return map;
	}
}
