package com.poly.controller;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poly.entity.Account;
import com.poly.entity.MailInfo;
import com.poly.entity.Role;
import com.poly.entity.TrangThaiHD;
import com.poly.repository.AccountDAO;
import com.poly.repository.RoleDAO;
import com.poly.repository.TrangThaiHoatDongDAO;
import com.poly.service.MailerService;
import com.poly.utils.SessionService;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

import javax.naming.directory.InitialDirContext;
import javax.naming.directory.DirContext;
import javax.naming.directory.Attributes;
import javax.naming.NamingException;
import java.util.Hashtable;

@Controller
@RequestMapping("account")
public class DangNhapController {

	@Autowired
	AccountDAO accountDao;

	@Autowired
	SessionService session;
	
	@Autowired
	MailerService emailService;
	
	@Autowired
	TrangThaiHoatDongDAO tthdDAO;
	
	@Autowired
	SessionService sessionService;
	
	
	@Autowired
	RoleDAO roleDAO;
	

	@GetMapping("login")
	public String showLoginForm(Model model) {
		model.addAttribute("tk", new Account());
		if(session.get("account") != null) {
			return "redirect:/home/0";
		}
		return "/template/login-form-02/login";
	}

	@PostMapping("login")
	public String login(Model model, @Validated @ModelAttribute("tk") Account tk, BindingResult result) {
		if (!result.hasErrors()) {
			return "redirect:/account/login";
		}
		
//		Optional<Account> account = accountDao.findById(tk.getTenDN());
//		if (account.get().getRole().equals("Admin")) {
//			return "redirect:/admin/home/view";
//		} else {
//			return "redirect:/home/0";
//		}

		try {
			Account account = accountDao.findById(tk.getTenDN()).orElseThrow(() -> new Exception("Account not found"));
			if (!account.getMatKhau().equals(tk.getMatKhau())) {
				result.rejectValue("matKhau", "error.tk", "Sai mật khẩu. Vui lòng nhập lại!");
			} else {
				session.set("account", account);
				if (account.getRole().getRoles().equals("Admin")) {
					return "redirect:/admin/home/view";
				} else {
					return "redirect:/home/0";
				}
			}
		} catch (Exception e) {
			model.addAttribute("message", "Login failed!");
		}

		return "/template/login-form-02/login";
	}
	
	
	

	@GetMapping("logout")
	public String logout() {
		session.remove("account");
		return "redirect:/layout/view";
	}

	// Quên mật khẩu
	@GetMapping("forgot")
	public String getForgot(@ModelAttribute("tk") Account tk) {
		return "/template/login-form-02/forgot";
	}
	
//	@PostMapping("forgot")
//	public String forgot(@Valid @ModelAttribute("tk") Account tk, BindingResult result, Model model) {
//		if(result.hasErrors()) {
//			return "/template/login-form-02/forgot";
//		}
//		
//		Optional<Account> account = accountDao.findByEmail(tk.getEmail());
//		if(account.isPresent()) {
//			// Send confirmation email
//            String subject = "Mã xác nhận đổi mật khẩu";
//            String body = "Đây là mã xác nhận của bạn, vui lòng không cung cấp mã này cho ai" + code;
//            MailInfo mailInfo = new MailInfo();
//            mailInfo.setFrom("THELIEM" + "<bichntnpc06726@fpt.edu.vn>");
//            mailInfo.setTo(tk.getEmail());
//            mailInfo.setSubject(subject);
//            mailInfo.setBody(body);
//
//            try {
//				emailService.send(mailInfo);
//				return "/template/login-form-02/verification";
//			} catch (MessagingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//		return "/template/login-form-02/forgot";
//	}
	
	// Tạo mã xác nhận
	public class VerificationCodeGenerator {
	    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    private static final int CODE_LENGTH = 6;
	    private static final Random RANDOM = new SecureRandom();

	    public static String generateVerificationCode() {
	        StringBuilder code = new StringBuilder(CODE_LENGTH);
	        for (int i = 0; i < CODE_LENGTH; i++) {
	            code.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
	        }
	        return code.toString();
	    }
	}

	@PostMapping("forgot")
	public String forgot(@Valid @ModelAttribute("tk") Account tk, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "/template/login-form-02/forgot";
        }

        String email = tk.getEmail().substring(tk.getEmail().indexOf("@") +1);
        if(checkMXRecord(email)) {
        	result.rejectValue("email", "error.tk", "Email không tồn tại!");
        	return "/template/login-form-02/forgot";
        }

	    Optional<Account> accountOpt = accountDao.findByEmail(tk.getEmail());
	    if (accountOpt.isPresent()) {
	        String verificationCode = VerificationCodeGenerator.generateVerificationCode();
	        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(1); // 60 giây

	        // Lưu mã xác nhận và thời gian hết hạn vào session
	        session.set("verificationCode", verificationCode);
	        session.set("verificationCodeExpiry", expiryTime);
	        session.set("email", tk.getEmail());
	        try {
	        // Gửi email
	        String subject = "Mã xác nhận đổi mật khẩu";
	        String body = "Đây là mã xác nhận của bạn, vui lòng không cung cấp mã này cho ai: " + verificationCode;
	        MailInfo mailInfo = new MailInfo();
	        mailInfo.setFrom("THELIEM" + "<bichntnpc06726@fpt.edu.vn>");
	        mailInfo.setTo(accountOpt.get().getEmail());
	        mailInfo.setSubject(subject);
	        mailInfo.setBody(body);

	        
	            emailService.send(mailInfo);
	            return "/template/login-form-02/verification";
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
	    return "/template/login-form-02/forgot";
	}
	
	@PostMapping("verify")
	public String verify(@RequestParam("code") String code, Model model) {
	    String sessionEmail = (String) sessionService.get("email");
	    String sessionVerificationCode = (String) session.get("verificationCode");
	    LocalDateTime sessionVerificationCodeExpiry = (LocalDateTime) session.get("verificationCodeExpiry");

	    if (sessionEmail != null && sessionVerificationCode != null && sessionVerificationCodeExpiry != null) {
	        LocalDateTime now = LocalDateTime.now();
	        
	        if (sessionVerificationCode.equals(code) && now.isBefore(sessionVerificationCodeExpiry)) {
	            // Mã xác nhận hợp lệ
	            // Thực hiện các bước tiếp theo để đổi mật khẩu
	            return "redirect:/account/resetpass";
	        } else {
	            // Mã xác nhận không hợp lệ hoặc đã hết hạn
	            model.addAttribute("error", "Mã xác nhận không hợp lệ hoặc đã hết hạn.");
	            return "/template/login-form-02/verification";
	        }
	    }

	    model.addAttribute("error", "Yêu cầu xác nhận không hợp lệ.");
	    return "/template/login-form-02/verification";
	}

	
	

	// Đăng ký
	@GetMapping("signup")
	public String getSignUp(@ModelAttribute("tk") Account tk) {
		return "/template/login-form-02/signup";
	}
	
	//Kiểm tra mail có tồn tại hay không
	public static boolean checkMXRecord(String domain) {
        try {
            Hashtable<String, String> env = new Hashtable<>();
            env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
            DirContext ictx = new InitialDirContext(env);
            Attributes attrs = ictx.getAttributes(domain, new String[]{"MX"});
            return attrs != null && attrs.size() > 0;
        } catch (NamingException e) {
            return false;
        }
    }
	
	@PostMapping("signup")
    public String signup(@Valid @ModelAttribute("tk") Account tk, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/template/login-form-02/signup";
        }

        String email = tk.getEmail().substring(tk.getEmail().indexOf("@") +1);
        if(!checkMXRecord(email)) {
        	result.rejectValue("email", "error.tk", "Email không tồn tại!");
        	return "/template/login-form-02/signup";
        }

        try {
        	Account account = new Account();
        	Role role = roleDAO.getById(3);
        	account.setHoTen(tk.getHoTen());
        	account.setTenDN(tk.getTenDN());
        	account.setMatKhau(tk.getTenDN());
        	account.setSdt(tk.getSdt());
        	account.setEmail(tk.getEmail());
        	account.setRole(role);
            accountDao.save(account);

            // Generate confirmation token (here we use email as token for simplicity)
            String confirmationToken = tk.getEmail();
            sessionService.set("confirmationToken" ,confirmationToken);

            // Send confirmation email
            String subject = "Xác nhận đăng ký tài khoản";
            String body = "Chào " + tk.getHoTen() + ",\n\n" + "Cảm ơn bạn đã đăng ký tài khoản tại trang web của chúng tôi.\n"
                    + "Vui lòng nhấn vào liên kết sau để xác nhận đăng ký của bạn:\n" + "http://localhost:8080/account/confirm/" + tk.getEmail();
            MailInfo mailInfo = new MailInfo();
            mailInfo.setFrom("THELIEM" + "<bichntnpc06726@fpt.edu.vn>");
            mailInfo.setTo(tk.getEmail());
            mailInfo.setSubject(subject);
            mailInfo.setBody(body);

            emailService.send(mailInfo);

            return "/template/confirm";
        } catch (Exception e) {
            e.printStackTrace();
            result.rejectValue("tenDN", "error.tk", "Tên đăng nhập hoặc email đã tồn tại.");
            model.addAttribute("errorMessage", "Tên đăng nhập hoặc email đã tồn tại.");
        }

        return "/template/login-form-02/signup";
    }

//	@GetMapping("/confirm")
//	public String confirmRegistration(@RequestParam("email") String email, Model model, HttpSession httpSession) {
//	    String confirmationToken = (String) httpSession.getAttribute("confirmationToken");
//
//	    if (confirmationToken != null) {
//	        // Tìm tài khoản theo email (confirmation token)
//	        Optional<Account> optionalAccount = accountDao.findByEmail(confirmationToken);
//	        if (optionalAccount.isPresent()) {
//	            Account tk = optionalAccount.get(); // Lấy đối tượng Account từ Optional
//	            // Giả định rằng ID trạng thái hoạt động là 1
//	            Optional<TrangThaiHD> optionalTrangThaiHD = tthdDAO.findById(1);
//	            if (optionalTrangThaiHD.isPresent()) {
//	                TrangThaiHD tt = optionalTrangThaiHD.get();
//	                // Cập nhật trạng thái xác nhận tài khoản
//	                tk.setTthd(tt);
//	                accountDao.save(tk);
//	                model.addAttribute("message", "Xác nhận đăng ký thành công!");
//	                session.set("account", tk);
//	                return "redirect:/home/index";
//	            } else {
//	                model.addAttribute("error", "Không tìm thấy trạng thái hoạt động.");
//	            }
//	        } else {
//	            model.addAttribute("error", "Tài khoản không tồn tại hoặc đã được xác nhận.");
//	        }
//	    } else {
//	        model.addAttribute("error", "Token xác nhận không hợp lệ.");
//	    }
//
//	    return "/template/confirm";
//	}
	
	@GetMapping("/confirm/{email}")
	public String confirmRegistration(@PathVariable("email") String email, Model model) {
	    String confirmationToken = (String) sessionService.get("confirmationToken");

	    if (confirmationToken != null && confirmationToken.equals(email)) {
	        // Xác nhận token hợp lệ
	        Optional<Account> optionalAccount = accountDao.findByEmail(email);
	        if (optionalAccount.isPresent()) {
	            Account tk = optionalAccount.get();
	            // Giả định rằng ID trạng thái hoạt động là 1
	            Optional<TrangThaiHD> optionalTrangThaiHD = tthdDAO.findById(1);
	            if (optionalTrangThaiHD.isPresent()) {
	                TrangThaiHD tt = optionalTrangThaiHD.get();
	                // Cập nhật trạng thái xác nhận tài khoản
	                tk.setTthd(tt);
	                accountDao.save(tk);
	                model.addAttribute("message", "Xác nhận đăng ký thành công!");

	                // Xóa token khỏi session sau khi xác nhận thành công
	                session.remove("confirmationToken");

	                // Đánh dấu đã đăng nhập và chuyển hướng đến trang chủ
	                session.set("account", tk);
	                if (tk.getRole().getRoles().equals("Admin")) {
	                    return "redirect:/admin/home/view";
	                } else {
	                    return "redirect:/home/index";
	                }
	            } else {
	                model.addAttribute("error", "Không tìm thấy trạng thái hoạt động.");
	            }
	        } else {
	            model.addAttribute("error", "Tài khoản không tồn tại hoặc đã được xác nhận.");
	        }
	    } else {
	        model.addAttribute("error", "Token xác nhận không hợp lệ.");
	    }

	    return "/template/confirm";
	}

	    
//		@ModelAttribute("role")
//		public Map<Integer, String> getCategory() {
//			Map<Integer, String> map = new HashMap<>();
//
//			List<Role> role = roleDAO.findAll();
//			for (Role c : role) {
//				map.put(c.getIdrole(), c.getRoles());
//			}
//			return map;
//		}

	// Đặt lại mật khẩu
	@GetMapping("resetpass")
	public String getResetPass() {
		return "/template/login-form-02/resetpass";
	}
	
	@PostMapping("resetpass")
    public String resetPassword(@RequestParam("matKhau") String password,
                                @RequestParam("reMatKhau") String confirmPassword,
                                RedirectAttributes redirectAttributes) {
        // Kiểm tra xem mật khẩu và xác nhận mật khẩu có khớp nhau không
        if (!password.equals(confirmPassword)) {
            // Nếu không khớp, chuyển hướng với thông báo lỗi
            redirectAttributes.addFlashAttribute("error", "Mật khẩu và xác nhận mật khẩu không khớp.");
            return "redirect:/account/resetpass";
        }

        // Lấy email của người dùng từ session hoặc từ cơ sở dữ liệu, tạm giả sử là "email@example.com"
        String email = sessionService.get("email");

        // Tìm tài khoản trong cơ sở dữ liệu
        Optional<Account> accountOpt = accountDao.findByEmail(email);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            // Mã hóa mật khẩu mới trước khi lưu
            account.setMatKhau(password);
            accountDao.save(account);
            // Đổi mật khẩu thành công, chuyển hướng đến trang đăng nhập
            return "redirect:/account/login?resetSuccess";
        } else {
            // Không tìm thấy tài khoản, xử lý tương ứng (ví dụ: hiển thị thông báo lỗi)
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy tài khoản.");
            return "redirect:/account/resetpass";
        }
    }

}
