package com.poly.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.entity.Account;
import com.poly.entity.DiaChi;
import com.poly.entity.Role;
import com.poly.entity.TrangThaiHD;
import com.poly.repository.AccountDAO;
import com.poly.repository.DiaChiDAO;
import com.poly.repository.RoleDAO;
import com.poly.repository.TrangThaiHoatDongDAO;
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
	TrangThaiHoatDongDAO tthdDAO;
	
	@Autowired
	RoleDAO roleDAO;
	
	
	
	
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
	
	@RequestMapping("viewdc")
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
	public String getdc(Model model,@ModelAttribute("diachi") DiaChi dc,@RequestParam("id_diaChi") Integer id_diaChi ) {
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

	
//	@RequestMapping("update")
//	public String update(Account item,@RequestParam("photo_file") MultipartFile img) throws IllegalStateException, IOException {
//		if(!img.isEmpty()) {
//			String filename = img.getOriginalFilename();
//			File uploadFolder = new File(app.getRealPath("/images/"));
//			if (!uploadFolder.exists()) {
//				uploadFolder.mkdirs();
//			}
//			File destFile = new File(uploadFolder, filename);
//			img.transferTo(destFile);
//			item.setImg(filename);
//		}
//		accDao.save(item);
//		return "redirect:/user/view";
//	}
	
	@RequestMapping("update")
	public String update(@ModelAttribute("item") Account item, @RequestParam("photo_file") MultipartFile img) throws IllegalStateException, IOException {
	    // Xử lý file ảnh nếu không rỗng
	    if (!img.isEmpty()) {
	        String filename = img.getOriginalFilename();
	        File uploadFolder = new File(app.getRealPath("/images/"));
	        if (!uploadFolder.exists()) {
	            uploadFolder.mkdirs();
	        }
	        File destFile = new File(uploadFolder, filename);
	        img.transferTo(destFile);
	        item.setImg(filename);
	    }

	    // Kiểm tra và lưu đối tượng TrangThaiHD
	    if (item.getTthd() != null) {
	        TrangThaiHD trangThaiHD = item.getTthd();
	        Optional<TrangThaiHD> existingTrangThaiHD = tthdDAO.findById(trangThaiHD.getIdtthd());

	        if (existingTrangThaiHD.isEmpty()) {
	            tthdDAO.save(trangThaiHD);
	        } else {
	            item.setTthd(existingTrangThaiHD.get());
	        }
	    }

	    // Kiểm tra và lưu đối tượng Role
	    if (item.getRole() != null) {
	        Role role = item.getRole();
	        Optional<Role> existingRole = roleDAO.findById(role.getIdrole());

	        if (existingRole.isEmpty()) {
	            roleDAO.save(role);
	        } else {
	            item.setRole(existingRole.get());
	        }
	    }

	    accDao.save(item);
	    return "redirect:/user/view";
	}
	
//	@PostMapping("updatedc")
//	public String update(@ModelAttribute("diachi") DiaChi diachi) throws IllegalStateException, IOException{
//		dcDao.save(diachi);	
//		return "redirect:/user/view";
//	}
	
	@PostMapping("updatedc")
	public String update(@ModelAttribute("diachi") DiaChi diachi) throws IllegalStateException, IOException {
	    // Lấy đối tượng Account từ cơ sở dữ liệu
	    Account account = session.get("account");

	    if (account == null) {
	        // Xử lý khi không tìm thấy Account
	        throw new RuntimeException("Không tìm thấy Account để cập nhật DiaChi.");
	    }

	    // Thiết lập lại Account cho DiaChi (nếu cần thiết)
	    diachi.setTenDN(account);

	    // Lưu DiaChi vào cơ sở dữ liệu
	    dcDao.save(diachi);

	    return "redirect:/user/view";
	}
	
	@RequestMapping("deletedc")
	public String delete(@RequestParam("id_diaChi") Integer id_diaChi ) throws IllegalStateException, IOException{
		dcDao.deleteById(id_diaChi);	
		return "redirect:/user/view";
	}
}
