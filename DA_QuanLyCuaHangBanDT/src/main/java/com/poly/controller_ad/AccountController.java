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
import com.poly.repository.AccountDAO;
import com.poly.repository.RoleDAO;
import com.poly.repository.TrangThaiHoatDongDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/account")
public class AccountController {
	@Autowired
	AccountDAO accDao; 
	@Autowired
	RoleDAO roleDao; 
	@Autowired
	TrangThaiHoatDongDAO ttDao;
	@Autowired
	ServletContext app;

	@RequestMapping("view")
	public String getAccount(Model model,@ModelAttribute("item") Account ac) {
		List<Account> items = accDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/account";
	}

	@RequestMapping("edit/{tenDN}")
	public String edit(Model model, @PathVariable("tenDN") String tenDN) {
		Account item = accDao.findById(tenDN).get();
		model.addAttribute("item", item);
		List<Account> items = accDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/account";
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

//	@ModelAttribute("list_category")
//	public Map<String, String> getCategory() {
//		Map<String, String> map = new HashMap<>();
//
//		List<Category> categorys = categoryDao.findAll();
//		for (Category c : categorys) {
//			map.put(c.getId(), c.getName());
//		}
//		return map;
//	}
}
