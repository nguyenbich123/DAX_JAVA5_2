package com.poly.controller_ad;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.eclipse.angus.mail.auth.MD4;
import org.eclipse.tags.shaded.org.apache.xalan.transformer.MsgMgr;
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
import com.poly.utils.SessionService;

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
	@Autowired
	SessionService session;

	@GetMapping("view")
	public String getuser(Model model, @ModelAttribute("item") Account ac, @ModelAttribute("diachi") DiaChi dc) {
		Account account = session.get("account");
		if (account == null) {
			return "redirect:/account/login";
		}
		Account item = accDao.findById(account.getTenDN()).get();
		model.addAttribute("item", item);

		Pass pass = new Pass();
		model.addAttribute("pass", pass);

		List<DiaChi> diachi = item.getDiachi();
		model.addAttribute("items", diachi);
		return "/template/Admin/user";
	}

	@GetMapping("viewdc")
	public String getdc(Model model, @ModelAttribute("item") Account ac, @ModelAttribute("diachi") DiaChi dc,
			@RequestParam("id_diaChi") Integer id_diaChi) {
		Account account = session.get("account");
		if (account == null) {
			return "redirect:/account/login";
		}
		Account item = accDao.findById(account.getTenDN()).get();
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
	public String update(Account item, @RequestParam("photo_file") MultipartFile img)
			throws IllegalStateException, IOException {
		if (!img.isEmpty()) {
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
		return "redirect:view";
	}

	@PostMapping("updatemk")
	public String submitForm(Model model, @ModelAttribute("item") Account ac, @ModelAttribute("diachi") DiaChi dc,
			@ModelAttribute("pass") Pass pass) throws IllegalStateException, IOException {
		Account account = session.get("account");
		if (account == null) {
			return "redirect:/account/login";
		}
		Account item = accDao.findById(account.getTenDN()).get();
		model.addAttribute("item", item);
		System.out.println("mật khẩu củ trong db " + item.getMatKhau());
		System.out.println("mật khẩu củ nhập vào " + pass.getOpass());

		String mkc = item.getMatKhau();
		String mkm = pass.getNpass();

		List<DiaChi> diachi = item.getDiachi();
		model.addAttribute("items", diachi);

		if (!pass.getOpass().equals(mkc)) {
			model.addAttribute("err", "Sai mật khẩu củ !");
			return "/template/Admin/user";
		}

		if (!pass.getNpass().equals(pass.getCfpass())) {
			// System.out.println("mật khẩu không khớp");
			model.addAttribute("err", "Mật khẩu mới và xác nhận mật khẩu không khớp !");
			return "/template/Admin/user";
		}

		item.setMatKhau(mkm);
		accDao.save(item);
		return "redirect:/admin/user/view";
	}

	@PostMapping("updatedc")
	public String update(Model md, @ModelAttribute("diachi") DiaChi diachi) throws IllegalStateException, IOException {
		Account account = session.get("account");
		Account item = accDao.findById(account.getTenDN()).get();

		List<DiaChi> dcds = dcDao.findByTenDN(item);

		if (account == null) {
			return "redirect:/account/login";
		}

		for (DiaChi x : dcds) {
			if (diachi.getXa_Phuong_Thitran().equals(x.getXa_Phuong_Thitran())
					&& diachi.getQuan_Huyen().equals(x.getQuan_Huyen())
					&& diachi.getTinh_ThanhPho().equals(x.getTinh_ThanhPho())) {
				md.addAttribute("dctt", "Địa chỉ này đã tồn tại!");
				System.out.println("Địa chỉ này đã tồn tại!");
				return "redirect:/admin/user/view";
			}
		}
		diachi.setTenDN(item);
		dcDao.save(diachi);
		return "redirect:/admin/user/view";
	}

	@RequestMapping("deletedc")
	public String delete(@RequestParam("id_diaChi") Integer id_diaChi) throws IllegalStateException, IOException {
		dcDao.deleteById(id_diaChi);
		return "redirect:/admin/user/view";
	}

}
