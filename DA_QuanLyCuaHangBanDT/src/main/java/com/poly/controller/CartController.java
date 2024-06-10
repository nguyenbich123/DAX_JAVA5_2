package com.poly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.entity.Account;
import com.poly.entity.CartItem;
import com.poly.entity.ChiTietGioHang;
import com.poly.entity.DiaChi;
import com.poly.entity.GioHang;
import com.poly.repository.AccountDAO;
import com.poly.repository.ChiTietGioHangDAO;
import com.poly.repository.ChiTietSanPhamDAO;
import com.poly.repository.DiaChiDAO;
import com.poly.repository.GioHangDAO;
import com.poly.service.CartService;
import com.poly.utils.SessionService;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	private ChiTietGioHangDAO ctghDAO;

	@Autowired
	private GioHangDAO ghDAO;

	@Autowired
	private SessionService session;
	
	@Autowired
	private DiaChiDAO diaChiDAO;

	@Autowired
	private CartService cartService;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	ChiTietSanPhamDAO ctspDAO;

	@GetMapping("/view")
	public String getViewCart(Model model) {
		// Kiểm tra đăng nhập
		if (session.get("account") == null) {
			return "redirect:/account/login";
		}

		// Lấy thông tin tài khoản người dùng
		Account currentAccount = (Account) session.get("account");

		// Lấy giỏ hàng của người dùng
		Optional<GioHang> gioHangOptional = ghDAO.findBymaKH(currentAccount);
		if (gioHangOptional.isPresent()) {
			GioHang gioHang = gioHangOptional.get();

			// Lấy danh sách chi tiết giỏ hàng
			List<ChiTietGioHang> chiTietGioHangList = ctghDAO.findByMaGH(gioHang);

			// Đổ dữ liệu giỏ hàng vào model
			model.addAttribute("gioHang", gioHang);
			model.addAttribute("sp", chiTietGioHangList);

			// Trả về tên view
			return "/template/user/cart";
		} else {
			// Xử lý trường hợp không tìm thấy giỏ hàng
			model.addAttribute("error", "Giỏ hàng không tồn tại");
			return "error";
		}
	}

	@RequestMapping("remove/{maCTSP}")
	public String remove(@PathVariable("maCTSP") Integer maCTSP) {
		ctghDAO.deleteByMaCTSP(maCTSP);
		return "redirect:/cart/view";
	}

	@RequestMapping("update/{id_CTGH}")
	public String update(@PathVariable("id_CTGH") Integer id, @RequestParam("action") String action,
			RedirectAttributes redirectAttributes) {
		Optional<ChiTietGioHang> spOptional = ctghDAO.findById(id);
		if (spOptional.isPresent()) {
			ChiTietGioHang sp = spOptional.get();
			if ("increase".equals(action)) {
				sp.setSoLuong(sp.getSoLuong() + 1);
			} else if ("decrease".equals(action)) {
				if (sp.getSoLuong() > 1) {
					sp.setSoLuong(sp.getSoLuong() - 1);
				} else {
					// Xử lý khi số lượng sản phẩm là 1
					redirectAttributes.addFlashAttribute("error", "Số lượng không thể giảm thêm.");
				}
			}
			// Lưu thay đổi vào cơ sở dữ liệu
			ctghDAO.save(sp);
		}
		return "redirect:/cart/view";
	}


	
	@RequestMapping("checkout")
    public String checkout(@RequestParam("selectedItems") String selectedItems, Model model) {
        // Kiểm tra đăng nhập
        Account currentAccount = (Account) session.get("account");
        if (currentAccount == null) {
            return "redirect:/account/login";
        }

        // Tải lại tài khoản với thuộc tính Lazy được khởi tạo
        Optional<Account> accountOpt = accountDAO.findByTenDN(currentAccount.getTenDN());
        if (!accountOpt.isPresent()) {
            return "redirect:/account/login";
        }

        Account account = accountOpt.get();
        Hibernate.initialize(account.getDiachi());
        List<DiaChi> diachi = account.getDiachi();

        Map<Integer, ChiTietGioHang> selectedItemsMap = new HashMap<>();
        double totalAmount = 0;
        List<CartItem> ctsp = new ArrayList<>();
        
        for (String itemId : selectedItems.split(",")) {
            Integer id = Integer.parseInt(itemId);
            Optional<ChiTietGioHang> spOptional = ctghDAO.findById(id);
            if (spOptional.isPresent()) {
                ChiTietGioHang sp = spOptional.get();
                selectedItemsMap.put(id, sp);
                totalAmount += sp.getSoLuong() * sp.getMaCTSP().getGia();
                
                ctsp.add(new CartItem(sp.getMaCTSP().getMaCTSP(),sp.getSoLuong(),sp.getMaCTSP().getGia()));
                
                System.out.println(ctsp + "---------------------------------------");
            }
            
        }
        
        
        session.set("dssp", ctsp);
        model.addAttribute("diachi", diachi);
        model.addAttribute("selectedItemsMap", selectedItemsMap);
        model.addAttribute("totalAmount", totalAmount);
        return "/template/user/payment";
    }
	


}
