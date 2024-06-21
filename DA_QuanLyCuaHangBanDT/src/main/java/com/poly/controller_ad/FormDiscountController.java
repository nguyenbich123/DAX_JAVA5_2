package com.poly.controller_ad;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

		// Lấy đối tượng GiamGia từ cơ sở dữ liệu
		GiamGia gg = ggDao.findById(idGiamGia).orElse(null);
		model.addAttribute("item", gg);
		return "/template/Admin/formDiscount";
	}
	
	
	@RequestMapping("update")
	public String update(Model model, @Validated @ModelAttribute("item") GiamGia item, BindingResult result,
			@RequestParam(value = "giamGia", required = false) String giamGia,
			@RequestParam("photo_file") MultipartFile img, @RequestParam("tgAp") String tgApString,
			@RequestParam("tgKt") String tgKtString, @RequestParam("field") Optional<String> field,
			@RequestParam("p") Optional<Integer> p) throws IllegalStateException, IOException {

		// Kiểm tra ngày kết thúc không được để trống
		if (item.getTgKt() == null) {
			result.rejectValue("tgKt", "error.item", "Ngày kết thúc không được để trống");
		}

		// Kiểm tra ngày bắt đầu không được để trống
		if (item.getTgAp() == null) {
			result.rejectValue("tgAp", "error.item", "Ngày bắt đầu không được để trống");
		}

		try {
			// Kiểm tra và xử lý ngày tháng tgAp nếu có giá trị
			if (tgApString != null && !tgApString.isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date tgAp = sdf.parse(tgApString);

				// Kiểm tra ngày bắt đầu phải từ ngày hiện tại chỉ khi thêm mới, không áp dụng
				// cho edit
				if (item.getIdGiamGia() == null) {
					Date currentDate = new Date();
					if (tgAp.getDate() != (currentDate.getDate())) {
						result.rejectValue("tgAp", "error.item", "Ngày bắt đầu phải từ ngày hiện tại");
					}
				}

				item.setTgAp(tgAp);
			} else {
				item.setTgAp(null);
			}

			// Kiểm tra và xử lý ngày tháng tgKt
			if (tgKtString != null && !tgKtString.isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date tgKt = sdf.parse(tgKtString);

				// Kiểm tra ngày kết thúc phải sau ngày bắt đầu ít nhất 1 ngày
				if (item.getTgAp() != null) {
					long diffInMillies = Math.abs(tgKt.getTime() - item.getTgAp().getTime());
					long diff = diffInMillies / (24 * 60 * 60 * 1000); // Chuyển đổi sang ngày

					if (diff < 1) {
						result.rejectValue("tgKt", "error.item", "Ngày kết thúc phải sau ngày bắt đầu ít nhất 1 ngày");
					}
				}

				// Kiểm tra ngày kết thúc phải sau ngày bắt đầu
				if (item.getTgAp() != null && tgKt.before(item.getTgAp())) {
					result.rejectValue("tgKt", "error.item", "Ngày kết thúc phải sau ngày bắt đầu");
				}

				item.setTgKt(tgKt);
			} else {
				item.setTgKt(null);
			}
		} catch (ParseException e) {
			result.rejectValue("tgAp", "error.item", "Ngày không hợp lệ");
			result.rejectValue("tgKt", "error.item", "Ngày không hợp lệ");
			return "/template/Admin/formDiscount";
		}

		// Kiểm tra nếu tham số giamGia không rỗng
		if (giamGia != null && !giamGia.isEmpty()) {
			// Thực hiện chuyển đổi chuỗi thành số
			item.setGiamGia(Float.parseFloat(giamGia));
		}

		List<GiamGia> lgg = ggDao.findAll();
		for (GiamGia x : lgg) {
if (x.getMaGG().equals(item.getMaGG())) {
				if (new Date().after(x.getTgKt())) {
					// Ngày hiện tại lớn hơn ngày kết thúc của mã đã tồn tại, cho phép thêm mới
				} else {
					// Mã đã tồn tại và chưa hết hạn, không cho phép thêm mới
					result.rejectValue("maGG", "error.item", "Mã giảm giá đã tồn tại và chưa hết hạn");
				}
			}
		}
		
		if (result.hasErrors()) {
			Sort sort = Sort.by(Direction.ASC, field.orElse("idGiamGia"));
			List<GiamGia> acc = ggDao.findAll(sort);
			model.addAttribute("field", field.orElse("idGiamGia"));
			Pageable pageable = PageRequest.of(p.orElse(0), 3, sort);
			Page<GiamGia> page = ggDao.findAll(pageable);
			model.addAttribute("page", page);
			return "/template/Admin/formDiscount";
		}

		// Xử lý logic lưu dữ liệu và upload ảnh
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

		ggDao.save(item);
		return "redirect:/admin/giamgia/index";
	}


	@RequestMapping("delete/{idGiamGia}")
	public String delete(@PathVariable("idGiamGia") Integer idGiamGia) throws IllegalStateException, IOException {
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
