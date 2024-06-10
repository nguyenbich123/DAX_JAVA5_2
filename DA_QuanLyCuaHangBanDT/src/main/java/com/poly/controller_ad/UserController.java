package com.poly.controller_ad;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.entity.Account;
import com.poly.entity.DiaChi;
import com.poly.entity.ManHinh;
import com.poly.entity.Pass;
import com.poly.repository.AccountDAO;
import com.poly.repository.DiaChiDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/user")
public class UserController {

	@Autowired
	AccountDAO accDao; 
	@Autowired
	DiaChiDAO dcDao;
	@Autowired
	ServletContext app;
	
	@GetMapping("view/{tenDN}")
	public String getuser(Model model,@ModelAttribute("item") Account ac,@ModelAttribute("diachi") DiaChi dc,@PathVariable("tenDN") String tenDN) {
		Account item = accDao.findById(tenDN).get();
		model.addAttribute("item", item);
		
		Pass pass = new Pass();
		model.addAttribute("pass", pass);
		
		List<DiaChi> diachi = item.getDiachi();
		model.addAttribute("items", diachi);
		return "/template/Admin/user";
	}
	
	@GetMapping("viewdc/{tenDN}")
	public String getdc(Model model,@ModelAttribute("item") Account ac,
			@ModelAttribute("diachi") DiaChi dc,@PathVariable("tenDN") String tenDN,
			@RequestParam("id_diaChi") Integer id_diaChi ) {
		Account item = accDao.findById(tenDN).get();
		model.addAttribute("item", item);
		
		Pass pass = new Pass();
		model.addAttribute("pass", pass);
		
		DiaChi dchi = dcDao.findById(id_diaChi).get();
		model.addAttribute("diachi", dchi);
		List<DiaChi> diachi = item.getDiachi();
		model.addAttribute("items", diachi);
		
		return "/template/Admin/user";
	}

	
	@RequestMapping("update")
	public String update(Account item,@RequestParam("photo_file") MultipartFile img) throws IllegalStateException, IOException {
		if(!img.isEmpty()) {
			String filename = img.getOriginalFilename();
			File uploadFolder = new File(app.getRealPath("/images/"));
			if (!uploadFolder.exists()) {
				uploadFolder.mkdirs();
			}
			File destFile = new File(uploadFolder, filename);
			img.transferTo(destFile);
			item.setImg(filename);
			System.out.println(uploadFolder);
			System.out.println(destFile);
		}
		
		accDao.save(item);
		return "redirect:view/"+ item.getTenDN();
	}
	
	@PostMapping("updatemk/{tenDN}")
	public String submitForm(Model model,@ModelAttribute("pass") Pass pass,@PathVariable("tenDN") String tenDN) throws IllegalStateException, IOException{
		
		Account item = accDao.findById(tenDN).get();
		System.out.println("mật khẩu củ trong db "+item.getMatKhau());
		System.out.println("mật khẩu củ nhập vào "+ pass.getOpass());
		
		String mkc = item.getMatKhau();
		String mkm = pass.getNpass();
				
		if(!pass.getOpass().equals(mkc)) {
			System.out.println("sai mật khẩu");	
			return "redirect:/admin/user/view/"+tenDN;
		}
		
		
		if(!pass.getNpass().equals(pass.getCfpass())) {
			System.out.println("mật khẩu không khớp");
			return "redirect:/admin/user/view/"+tenDN;
		}
		
		item.setMatKhau(mkm);
		accDao.save(item);
		return "redirect:/admin/user/view/"+tenDN;
	}
	
	@PostMapping("updatedc/{tenDN}")
	public String update(@ModelAttribute("diachi") DiaChi diachi,@PathVariable("tenDN") String tenDN) throws IllegalStateException, IOException{
		dcDao.save(diachi);	
		return "redirect:/admin/user/view/"+tenDN;
	}
	
	@RequestMapping("deletedc/{tenDN}")
	public String delete(@RequestParam("id_diaChi") Integer id_diaChi ,@PathVariable("tenDN") String tenDN) throws IllegalStateException, IOException{
		dcDao.deleteById(id_diaChi);	
		return "redirect:/admin/user/view/"+tenDN;
	}
	
}
