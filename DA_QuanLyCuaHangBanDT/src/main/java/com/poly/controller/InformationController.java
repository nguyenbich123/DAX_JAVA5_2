package com.poly.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.poly.entity.*;
import com.poly.repository.AccountDAO;
import com.poly.repository.DiaChiDAO;
import com.poly.utils.SessionService;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("user")
public class InformationController {
	@Autowired
	AccountDAO accDao; 
	@Autowired
	DiaChiDAO dcDao;
	@Autowired
	ServletContext app;
	
	@Autowired
	SessionService session;
	
	@GetMapping("view")
	public String getuser(Model model,@ModelAttribute("item") Account ac,@ModelAttribute("diachi") DiaChi dc) {
		Account account = session.get("account");
		if(account == null) {
			return  "redirect:/account/login";
		}
		Account item = accDao.findById(account.getTenDN()).get();
		model.addAttribute("item", item);	
		return "/template/user/information";
	}
	
	@PostMapping("viewdc")
	public String getuser1(Model model,@ModelAttribute("item") Account ac,@ModelAttribute("diachi") DiaChi dc) {
		Account account = session.get("account");
		if(account == null) {
			return  "redirect:/account/login";
		}
		Account item = accDao.findById(account.getTenDN()).get();
		model.addAttribute("item", item);	
		
		List<DiaChi> diachi = item.getDiachi();
		model.addAttribute("items", diachi);
		return "/template/user/diachi";
	}
	
	@GetMapping("editdc")
	public String getdc(Model model,@ModelAttribute("item") Account ac,@ModelAttribute("diachi") DiaChi dc,@RequestParam("id_diaChi") Integer id_diaChi ) {
		Account account = session.get("account");
		if(account == null) {
			return  "redirect:/account/login";
		}
		Account item = accDao.findById(account.getTenDN()).get();
		model.addAttribute("item", item);	
		
		DiaChi dchi = dcDao.findById(id_diaChi).get();
		model.addAttribute("diachi", dchi);

		List<DiaChi> diachi = item.getDiachi();
		model.addAttribute("items", diachi);
		
		return "/template/user/diachi";
	}

	
	@RequestMapping("update")
	public String update(Account items,@RequestParam("photo_file") MultipartFile img,@Validated @ModelAttribute("item") Account item,BindingResult result) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			if(!img.isEmpty()) {
				String filename = img.getOriginalFilename();
				File uploadFolder = new File(app.getRealPath("/images/"));
				if (!uploadFolder.exists()) {
					uploadFolder.mkdirs();
				}
				File destFile = new File(uploadFolder, filename);
				img.transferTo(destFile);
				items.setImg(filename);
				System.out.println(uploadFolder);
				System.out.println(destFile);
			}
			return "/template/user/information";
		}


		accDao.save(item);
		return "redirect:/user/view";
	}
	
	@PostMapping("updatedc")
	public String update(@ModelAttribute("diachi") DiaChi diachi) throws IllegalStateException, IOException{
		dcDao.save(diachi);	
		return "redirect:/user/view";
	}
	@RequestMapping("deletedc")
	public String delete(@RequestParam("id_diaChi") Integer id_diaChi ) throws IllegalStateException, IOException{
		dcDao.deleteById(id_diaChi);	
		return "redirect:/user/view";
	}
}
