package com.poly.controller_ad;

import java.io.File;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.entity.GiamGia;
import com.poly.repository.GiamGiaDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/giamgia")
public class FormDiscountController {

	@Autowired
	GiamGiaDAO ggDao;
	@Autowired
	ServletContext app;

	@RequestMapping("view")
	public String getAccount(Model model, @ModelAttribute("item") GiamGia giamgia) {
		List<GiamGia> items = ggDao.findAll();
		model.addAttribute("items", items);
		return "/template/Admin/formDiscount";
	}

	@GetMapping("edit/{idGiamGia}")
	public String edit(Model model, @ModelAttribute("item") GiamGia giamgia,
			@PathVariable("idGiamGia") Integer idGiamGia, @RequestParam("field") Optional<String> field,
			@RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idGiamGia"));
		List<GiamGia> acc = ggDao.findAll(sort);
		model.addAttribute("field", field.orElse("idGiamGia"));
		Pageable pageable = PageRequest.of(p.orElse(0), 3, sort);

		Page<GiamGia> page = ggDao.findAll(pageable);
		model.addAttribute("page", page);

		GiamGia gg = ggDao.findById(idGiamGia).get();
		model.addAttribute("item", gg);
		return "/template/Admin/formDiscount";
	}

	@RequestMapping("update")
	public String update(@Validated @ModelAttribute("item") GiamGia item, BindingResult result,
	                     @RequestParam(value = "giamGia", required = false) String giamGia, // Thêm required = false để cho phép tham số là rỗng
	                     @RequestParam("photo_file") MultipartFile img)
	                     throws IllegalStateException, IOException {
	    // Kiểm tra nếu tham số giamGia không rỗng
	    if (giamGia != null && !giamGia.isEmpty()) {
	        // Thực hiện chuyển đổi chuỗi thành số
	        item.setGiamGia(Float.parseFloat(giamGia));
	    }
	    if (result.hasErrors()) {
	        return "/template/Admin/formDiscount";
	    }
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
	    ggDao.save(item);
	    return "redirect:/admin/giamgia/index";
	}
	@RequestMapping("delete/{idGiamGia}")
	public String delete(GiamGia giamGia, @PathVariable("idGiamGia") Integer idGiamGia)
			throws IllegalStateException, IOException {
		ggDao.deleteById(idGiamGia);
		return "redirect:/admin/giamgia/index";
	}

	@GetMapping("index")
	public String bai5(Model model, @ModelAttribute("item") GiamGia giamgia,
			@RequestParam("field") Optional<String> field, @RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by(Direction.ASC, field.orElse("idGiamGia"));
		List<GiamGia> acc = ggDao.findAll(sort);
		model.addAttribute("field", field.orElse("idGiamGia"));
		Pageable pageable = PageRequest.of(p.orElse(0), 3, sort);
		System.out.println(field);
		Page<GiamGia> page = ggDao.findAll(pageable);
		model.addAttribute("page", page);
		return "/template/Admin/formDiscount";
	}
}
