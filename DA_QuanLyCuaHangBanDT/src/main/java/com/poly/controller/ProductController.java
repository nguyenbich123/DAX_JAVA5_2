package com.poly.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.ChiTietSP;
import com.poly.repository.ChiTietSanPhamDAO;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ChiTietSanPhamDAO ctspDAO;

    @GetMapping("view")
    public String getProduct(Model model, @RequestParam("p") Optional<Integer> p, 
                             @RequestParam("sortby") Optional<String> sortby,
                             @RequestParam("min") Optional<Double> min, 
                             @RequestParam("max") Optional<Double> max,
                             @RequestParam("keywords") Optional<String> keywords) {
        int pageNumber = p.orElse(0);
        String sortField = sortby.orElse("maCTSP");
        Sort sort = Sort.by(Sort.Direction.DESC, sortField);
        Pageable pageable = PageRequest.of(pageNumber, 12, sort);
        
        Page<ChiTietSP> page = ctspDAO.findByCriteria(
                min.orElse(null), 
                max.orElse(null), 
                keywords.orElse(null), 
                pageable
        );

        model.addAttribute("page", page);
        model.addAttribute("sortby", sortField);
        model.addAttribute("min", min.orElse(null));
        model.addAttribute("max", max.orElse(null));
        model.addAttribute("keywords", keywords.orElse(null));
        return "/template/user/product";
    }

    @RequestMapping("filter-price")
    public String search(Model model, @RequestParam("min") Optional<Double> min, @RequestParam("max") Optional<Double> max,
                         @RequestParam("p") Optional<Integer> p, @RequestParam("sortby") Optional<String> sortby,
                         @RequestParam("keywords") Optional<String> keywords) {
        return getProduct(model, p, sortby, min, max, keywords);
    }

    @RequestMapping("search-and-page/{keywords}")
    public String searchAndPage(Model model, @PathVariable("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p, @RequestParam("sortby") Optional<String> sortby,
                                @RequestParam("min") Optional<Double> min, @RequestParam("max") Optional<Double> max) {
        return getProduct(model, p, sortby, min, max, kw);
    }

    @RequestMapping("sort")
    public String get(Model model, @RequestParam("sortby") Optional<String> field, @RequestParam("p") Optional<Integer> p,
                      @RequestParam("min") Optional<Double> min, @RequestParam("max") Optional<Double> max,
                      @RequestParam("keywords") Optional<String> keywords) {
        return getProduct(model, p, field, min, max, keywords);
    }
    
    @RequestMapping("search")
    public String searchAndPage(Model model, @RequestParam("search") Optional<String> kw, @RequestParam("p") Optional<Integer> p) {
        String keywords = kw.orElse("");
        int pageNumber = p.orElse(0);
        Pageable pageable = PageRequest.of(pageNumber, 12);
        Page<ChiTietSP> page = ctspDAO.findByKeywords("%" + keywords + "%", pageable);

        model.addAttribute("page", page);
        model.addAttribute("keywords", keywords);
        model.addAttribute("min", null);  // Thêm dòng này
        model.addAttribute("max", null);  // Thêm dòng này
        return "/template/user/product";
    }
    
    @GetMapping("product-detail/{maCTSP}")
	public String getCTSP(Model model, @PathVariable("maCTSP") Integer maCTSP, @RequestParam("p") Optional<Integer> p) {
	    Optional<ChiTietSP> sanPhamOptional = ctspDAO.findById(maCTSP);
	    if (sanPhamOptional.isPresent()) {
	        ChiTietSP sanPham = sanPhamOptional.get();
	        System.out.println(sanPham);
	        model.addAttribute("sanPham", sanPham);
	        
	        Pageable pageable = PageRequest.of(p.orElse(0), 12);
	        Page<ChiTietSP> page = ctspDAO.findByKeywords("%" + sanPham.getMaSP().getTenSP() + "%", pageable);

	        model.addAttribute("page", page);
	        model.addAttribute("min", null);  // Thêm dòng này
	        model.addAttribute("max", null);  // Thêm dòng này
	        return "/template/user/product_detail";
	    } else {
	        // Xử lý trường hợp không tìm thấy sản phẩm
	        return "error-page"; // hoặc redirect đến một trang thông báo lỗi khác
	    }
	}
    
    
}
