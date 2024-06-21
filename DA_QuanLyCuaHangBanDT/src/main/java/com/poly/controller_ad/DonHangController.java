package com.poly.controller_ad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.ChiTietDonHang;
import com.poly.entity.DonHang;
import com.poly.entity.SanPham;
import com.poly.entity.ChiTietSP;
import com.poly.entity.TTDH;
import com.poly.repository.ChiTietDonHangDAO;
import com.poly.repository.ChiTietSanPhamDAO;
import com.poly.repository.DonHangDAO;
import com.poly.repository.TTDH_DAO;
import com.poly.utils.SessionService;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/donhang")
public class DonHangController {
	@Autowired
	DonHangDAO dhDao;
	@Autowired
	TTDH_DAO ttdhDao;
	@Autowired
	ChiTietSanPhamDAO ctspDao;
	 @Autowired
	 ChiTietDonHangDAO ctdhDAO;
	 
	 
	@Autowired
	ServletContext app;
	@Autowired
	SessionService session;

	@RequestMapping("view")
	public String getdh(Model model, @ModelAttribute("item") DonHang dh) {

		return "/template/Admin/formDonHang";
	}

	@RequestMapping("index")
	public String getdh(Model model, @ModelAttribute("dh") DonHang dh, @RequestParam("field") Optional<String> field,
			@RequestParam("p") Optional<Integer> p) {
		
		Sort sort = Sort.by(Direction.DESC, field.orElse("maDH"));
		model.addAttribute("field", field.orElse("maDH"));
		Pageable pageable = PageRequest.of(p.orElse(0), 3, sort);
		Page<DonHang> page = dhDao.findAll(pageable);
		model.addAttribute("page", page);
		
		Map<Integer, List<ChiTietDonHang>> chiTietDonHangMap = new HashMap<>();
        for (DonHang donHang : page) {
            List<ChiTietDonHang> chitiet = ctdhDAO.findByMaDH(donHang);
            chiTietDonHangMap.put(donHang.getMaDH(), chitiet);
            for (ChiTietDonHang ct : chitiet) {
                SanPham sanPham = ct.getMaCTSP().getMaSP();
            }
        }
        
        model.addAttribute("chiTietDonHangMap", chiTietDonHangMap);
		return "/template/Admin/DonHang";
	}
	
	@PostMapping("xn")
	public String Xn(Model model, @ModelAttribute("dh") DonHang dh,@RequestParam("maDH") Integer maDH) {
		Optional<DonHang> dhh =dhDao.findById(maDH);
		if(dhh.get().getMaDH()==maDH) {
			dh=dhh.get();
		}
		
		if(dh.getTtdh().getTrangThai().equals("Đã hủy")) {
			return "redirect:/admin/donhang/index";
		}
		
		List<TTDH> tt = ttdhDao.findAll();
		for(TTDH x : tt) {
			if(x.getTrangThai().equalsIgnoreCase("Đã xác nhận")){
				dh.setTtdh(x);
			}
			System.out.println("-----------------------------------------------------");
		}
		
		List<ChiTietDonHang> ctdh =ctdhDAO.findByMaDH(dhh.get());	
		List<ChiTietSP> ctsp = ctspDao.findAll();
	
		int soluong =0;
		for(ChiTietSP y: ctsp) {
			for(ChiTietDonHang x : ctdh) {	
				if(x.getMaCTSP().getMaCTSP()== y.getMaCTSP()){
					soluong =y.getSoluong() -x.getSoLuong();
					//System.out.println(soluong +"=======================================================================================");
					y.setSoluong(soluong);
					ctspDao.save(y);
				}
			}	
		}
		
		dhDao.save(dh);	
		return "redirect:/admin/donhang/index";
	}
	
	@PostMapping("huy")
	public String huy(Model model, @ModelAttribute("dh") DonHang dh,@RequestParam("maDH") Integer maDH) {
		// gắn đơn hàng = đơn hàng đã chuyền từ madh
		Optional<DonHang> dhh =dhDao.findById(maDH);
		if(dhh.get().getMaDH()==maDH) {
			dh=dhh.get();
		}
		
//		if(dh.getTtdh().equals("Chờ xác nhận")) {
//			
//		}
		//System.out.println(dh.getTtdh().getTrangThai().toString() +" in trạng thái đơn hàng ");
		
		// nếu đang giao thì thu hồi sp (tăng lại số lượng sp trong đơn hàng vào kho  )
		if(dh.getTtdh().getTrangThai().toString().equals("Đã xác nhận")) {
			
			List<ChiTietDonHang> ctdh =ctdhDAO.findByMaDH(dhh.get());	
			List<ChiTietSP> ctsp = ctspDao.findAll();		
			// sét số lượng 
			int soluong =0;
			for(ChiTietSP y: ctsp) {
				for(ChiTietDonHang x : ctdh) {	
					if(x.getMaCTSP().getMaCTSP()== y.getMaCTSP()){
						soluong =y.getSoluong() +x.getSoLuong();
						System.out.println(soluong +"=======================================================================================");
						y.setSoluong(soluong);
						ctspDao.save(y);
					}
				}	
			}
		}
		
		// sét trạng thái đơn hàng 
		List<TTDH> tt = ttdhDao.findAll();
		for(TTDH x : tt) {
			if(x.getTrangThai().equalsIgnoreCase("Đã hủy")){
				dh.setTtdh(x);
			}
			System.out.println("-----------------------------------------------------");
		}
		
		dhDao.save(dh);	
		return "redirect:/admin/donhang/index";
	}

//	@RequestMapping("edit/{maDH}")
//	public String edit(Model model, @ModelAttribute("item") CameraSau cs,@PathVariable("maDH") Integer maDH) {
//		DonHang item = dhDao.findById(maDH).get();
//		model.addAttribute("item", item);
//		
//		return "/template/Admin/formDonHang";
//
//	}
	
}
