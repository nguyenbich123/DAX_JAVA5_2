package com.poly.controller_ad;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.repository.AccountDAO;
import com.poly.repository.DonHangDAO;
import com.poly.repository.SanPhamDAO;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("admin/home")
public class HomeAdminController {

	@Autowired
	SanPhamDAO spDao;
	@Autowired
	DonHangDAO dhDao;
	@Autowired
	AccountDAO acDao;
	@Autowired
	ServletContext app;

	public Integer fillDH(Optional<String> BCTKDH) {
		List<Integer> dhtk;
		if (BCTKDH.isPresent()) {
			if (BCTKDH.get().equals("month")) {
				dhtk = dhDao.findDHBytmonth(new Date());
				return dhtk.get(0);
			}
			if (BCTKDH.get().equals("year")) {
				dhtk = dhDao.findDHBytyear(new Date());
				return dhtk.get(0);
			}
		}
		dhtk = dhDao.findDHBytday(new Date());
		return dhtk.get(0);

	}

	public Integer fillDT(Optional<String> BCTKDT) {
		List<Integer> dttk;
		if (BCTKDT.isPresent()) {
			if (BCTKDT.get().equals("month")) {
				dttk = dhDao.findDTBytmonth(new Date());
				return dttk.get(0);
			}
			if (BCTKDT.get().equals("year")) {
				dttk = dhDao.findDTBytyear(new Date());
				return dttk.get(0);
			}
		}
		dttk = dhDao.findDTBytday(new Date());
		return dttk.get(0);
	}

	public Integer fillKH(Optional<String> BCTKKH) {
		List<Integer> khtk;
		if (BCTKKH.isPresent()) {
			if (BCTKKH.get().equals("month")) {
				khtk = dhDao.findKHBytmonth(new Date());
				return khtk.get(0);
			}
			if (BCTKKH.get().equals("year")) {
				khtk = dhDao.findKHBytyear(new Date());
				return khtk.get(0);
			}
		}
		khtk = dhDao.findKHBytday(new Date());
		return khtk.get(0);
	}

	@GetMapping("view")
	public String getForm(Model model, @RequestParam("BCTKDH") Optional<String> BCTKDH,
			@RequestParam("BCTKDT") Optional<String> BCTKDT, @RequestParam("BCTKKH") Optional<String> BCTKKH) {

		model.addAttribute("BCTKDH", BCTKDH.orElse("today"));
		model.addAttribute("dhtk", fillDH(BCTKDH));

		model.addAttribute("BCTKDT", BCTKDT.orElse("today"));
		model.addAttribute("dttk", fillDT(BCTKDT));

		model.addAttribute("BCTKKH", BCTKKH.orElse("today"));
		model.addAttribute("khtk", fillKH(BCTKKH));

		List<Object> khttData = dhDao.findKHByngayTT(new Date());
		model.addAttribute("datakh", khttData);
		List<Object> dhttData = dhDao.findDHByngayTT(new Date());
		model.addAttribute("datadh", dhttData);
		List<Object> dtttData = dhDao.findDTByngayTT(new Date());
		model.addAttribute("datadt", dtttData);
		List<Object> timeData = dhDao.findByngayTT(new Date());

		List<String> formattedTimeData = timeData.stream().map(date -> {
			LocalDateTime localDateTime = ((Date) date).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			return "\"" + formatter.format(localDateTime) + "\"";
		}).collect(Collectors.toList());

		model.addAttribute("timedata", formattedTimeData);
		return "/template/Admin/home";
	}

}
