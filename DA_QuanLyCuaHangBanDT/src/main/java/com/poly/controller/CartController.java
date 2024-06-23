package com.poly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Account;
import com.poly.entity.CartItem;
import com.poly.entity.ChiTietGioHang;
import com.poly.entity.DiaChi;
import com.poly.entity.GiamGia;
import com.poly.entity.GioHang;
import com.poly.entity.PTTT;
import com.poly.repository.AccountDAO;
import com.poly.repository.ChiTietGioHangDAO;
import com.poly.repository.ChiTietSanPhamDAO;
import com.poly.repository.DiaChiDAO;
import com.poly.repository.GiamGiaDAO;
import com.poly.repository.GioHangDAO;
import com.poly.repository.PTTT_DAO;
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
	
	@Autowired
	GiamGiaDAO giamGiaDAO;
	
	@Autowired
	PTTT_DAO ptttDAO;

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

		} else {
			// Xử lý trường hợp không tìm thấy giỏ hàng
			model.addAttribute("error", "Giỏ hàng không tồn tại");
		}
		// Trả về tên view
		return "/template/user/cart";
	}

	@RequestMapping("remove/{maCTSP}")
	public String remove(@PathVariable("maCTSP") Integer maCTSP) {
		ctghDAO.deleteByMaCTSP(maCTSP);
		return "redirect:/cart/view";
	}


	
	
//	@PostMapping("update")
//    @ResponseBody
//    public Map<String, Object> update(@RequestParam("id_CTGH") Integer id, @RequestParam("action") String action) {
//        Map<String, Object> response = new HashMap<>();
//        Optional<ChiTietGioHang> spOptional = ctghDAO.findById(id);
//        if (spOptional.isPresent()) {
//            ChiTietGioHang sp = spOptional.get();
//            if ("increase".equals(action)) {
//                if (sp.getSoLuong() < sp.getMaCTSP().getSoluong()) {
//                    sp.setSoLuong(sp.getSoLuong() + 1);
//                }
//            } else if ("decrease".equals(action)) {
//                if (sp.getSoLuong() > 1) {
//                    sp.setSoLuong(sp.getSoLuong() - 1);
//                }
//            }
//            ctghDAO.save(sp);
//            response.put("status", "success");
//            response.put("newQuantity", sp.getSoLuong());
//            response.put("totalPrice", sp.getSoLuong() * sp.getMaCTSP().getGia());
//        } else {
//            response.put("status", "error");
//        }
//        return response;
//    }
	
	@PostMapping("/update")
	public ResponseEntity<Map<String, Object>> update(@RequestParam("id_CTGH") Integer id,
	                                                  @RequestParam("action") String action) {
	    Map<String, Object> response = new HashMap<>();
	    Optional<ChiTietGioHang> spOptional = ctghDAO.findById(id);
	    if (spOptional.isPresent()) {
	        ChiTietGioHang sp = spOptional.get();
	        int maxQuantity = sp.getMaCTSP().getSoluong();
	        if ("increase".equals(action)) {
	            if (sp.getSoLuong() < maxQuantity) {
	                sp.setSoLuong(sp.getSoLuong() + 1);
	                ctghDAO.save(sp);
	            } else {
	                response.put("status", "error");
	                //response.put("message", "Reached max quantity");
	                response.put("maxQuantity", maxQuantity);
	                return new ResponseEntity<>(response, HttpStatus.OK);
	            }
	        } else if ("decrease".equals(action)) {
	            if (sp.getSoLuong() > 1) {
	                sp.setSoLuong(sp.getSoLuong() - 1);
	                ctghDAO.save(sp);
	            } else {
	                response.put("status", "error");
	                //response.put("message", "Quantity cannot be decreased further");
	                return new ResponseEntity<>(response, HttpStatus.OK);
	            }
	        }
	        response.put("status", "success");
	        response.put("newQuantity", sp.getSoLuong());
	        response.put("totalPrice", sp.getSoLuong() * sp.getMaCTSP().getGia());
	        response.put("maxQuantity", maxQuantity);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        response.put("status", "error");
	        response.put("message", "Item not found");
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	    }
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

				ctsp.add(new CartItem(sp.getMaCTSP().getMaCTSP(), sp.getSoLuong(), sp.getMaCTSP().getGia()));

				System.out.println(ctsp + "---------------------------------------");
			}

		}
		
		List<PTTT> listPTTT = ptttDAO.findAll();
        model.addAttribute("listPT", listPTTT);
        
        List<GiamGia> listGG = giamGiaDAO.findAll();
        model.addAttribute("listGG", listGG);
        System.out.println(listGG);

		session.set("dssp", ctsp);
		model.addAttribute("diachi", diachi);
		model.addAttribute("selectedItemsMap", selectedItemsMap);
		model.addAttribute("totalAmount", totalAmount);
		return "/template/user/payment";
	}
	


}
