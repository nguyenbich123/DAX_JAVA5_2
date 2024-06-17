package com.poly.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

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
import com.poly.entity.Pass;
import com.poly.entity.Role;
import com.poly.entity.TrangThaiHD;
import com.poly.repository.AccountDAO;
import com.poly.repository.RoleDAO;
import com.poly.repository.TrangThaiHoatDongDAO;
import com.poly.service.EmailVerifier;
import com.poly.service.MailerService;
import com.poly.utils.SessionService;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

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

	int sldn = 0;

	@GetMapping("login")
	public String showLoginForm(Model model) {
		model.addAttribute("tk", new Account());
		if(session.get("account") != null) {
			return "redirect:/home/0";
		}
		return "/template/login-form-02/login";
	}

//	@PostMapping("login")
//	public String login(Model model, @Validated @ModelAttribute("tk") Account tk, BindingResult result) {
//		if (result.hasErrors()) {
//			return "/template/login-form-02/login";
//		}
//
//		try {
//			Account account = accountDao.findById(tk.getTenDN()).orElseThrow(() -> new Exception("Account not found"));
//			if (!account.getMatKhau().equals(tk.getMatKhau())) {
//				result.rejectValue("matKhau", "error.tk", "Sai mật khẩu. Vui lòng nhập lại!");
//				return "/template/login-form-02/login";
//			} else {
//				session.set("account", account);
//				if (account.getRole().getRoles().equals("Admin")) {
//					return "redirect:/admin/home/view";
//				} else {
//					return "redirect:/home/0";
//				}
//			}
//		} catch (Exception e) {
//			model.addAttribute("message", "Login failed!");
//		}
//
//		return "/template/login-form-02/login";
//	}
	
//	@PostMapping("login")
//	public String login(Model model, @Validated @ModelAttribute("tk") Account tk, BindingResult result) {
//	    if (result.hasErrors()) {
//	        System.out.println("Validation errors present.");
//	        return "/template/login-form-02/login";
//	    }
//
//	    System.out.println("Username: " + tk.getTenDN());
//	    System.out.println("Password: " + tk.getMatKhau());
//
//	    try {
//	        Optional<Account> optionalAccount = accountDao.findById(tk.getTenDN());
//	        if (!optionalAccount.isPresent()) {
//	            System.out.println("Account not found.");
//	            result.rejectValue("tenDN", "error.tk", "Tên đăng nhập không tồn tại!!");
//	            return "/template/login-form-02/login";
//	        }
//
//	        Account account = optionalAccount.get();
//	        if (!account.getMatKhau().equals(tk.getMatKhau())) {
//	            System.out.println("Incorrect password.");
//	            result.rejectValue("matKhau", "error.tk", "Sai mật khẩu. Vui lòng nhập lại!");
//	            return "/template/login-form-02/login";
//	        } else {
//	            System.out.println("Login successful. Setting session attribute and redirecting...");
//	            session.set("account", account);
//	            if ("Admin".equals(account.getRole().getRoles())) {
//	                return "redirect:/admin/home/view";
//	            } else {
//	                return "redirect:/home/0";
//	            }
//	        }
//	    } catch (Exception e) {
//	        System.out.println("Exception: " + e.getMessage());
//	        model.addAttribute("message", "Login failed! " + e.getMessage());
//	    }
//
//	    return "/template/login-form-02/login";
//	}


	
	@PostMapping("login")
	public String login(Model model, @Validated @ModelAttribute("tk") Account tk, BindingResult result) {
	    if (result.hasErrors()) {
	        System.out.println("Validation errors present.");
	        return "/template/login-form-02/login";
	    }
	    
	    System.out.println("Username: " + tk.getTenDN());
	    System.out.println("Password: " + tk.getMatKhau());

	    try {
	        Optional<Account> optionalAccount = accountDao.findById(tk.getTenDN());
	        if (!optionalAccount.isPresent()) {
	            System.out.println("Account not found.");
	            result.rejectValue("tenDN", "error.tk", "Tên đăng nhập không tồn tại!!");
	            return "/template/login-form-02/login";
	        }

	        Account account = optionalAccount.get();
	        
	        // Check if account is locked
	        
	        if (account.getTthd() == null) {
	            System.out.println("Account is locked.");
	            result.rejectValue("tenDN", "error.tk", "Tài khoản chưa được kích hoạt!");
	            return "/template/login-form-02/login";
	        }
	        if (account.getTthd().getIdtthd() == 2) {
	            System.out.println("Account is locked.");
	            result.rejectValue("tenDN", "error.tk", "Tài khoản đã bị khóa!");
	            return "/template/login-form-02/login";
	        }

	        Optional<TrangThaiHD> tthd = tthdDAO.findById(2);
	        
	        if (!account.getMatKhau().equals(tk.getMatKhau())) {
	            System.out.println("Incorrect password.");
	            sldn = sldn + 1;
	            if (sldn >= 5) {
	                account.setTthd(tthd.get());;
	                System.out.println("Account has been locked due to too many failed login attempts.");
	                result.rejectValue("tenDN", "error.tk", "Tài khoản đã bị khóa do đăng nhập thất bại quá 5 lần.");
	            } else {
	                result.rejectValue("matKhau", "error.tk", "Sai mật khẩu. Vui lòng nhập lại!");
	            }
	            accountDao.save(account);
	            return "/template/login-form-02/login";
	        } else {
	            // Reset failed login attempts on successful login
	            sldn = 0;
	            accountDao.save(account);
	            
	            System.out.println("Login successful. Setting session attribute and redirecting...");
	            session.set("account", account);
	            if ("Admin".equals(account.getRole().getRoles())) {
	                return "redirect:/admin/home/view";
	            } else {
	                return "redirect:/home/0";
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Exception: " + e.getMessage());
	        model.addAttribute("message", "Login failed! " + e.getMessage());
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
        if(!EmailVerifier.verifyEmail(tk.getEmail())) {
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
	
//	@PostMapping("signup")
//    public String signup(@Valid @ModelAttribute("tk") Account tk, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "/template/login-form-02/signup";
//        }
//
//        Optional<Account> chkTendn = accountDao.findByTenDN(tk.getTenDN());
//        if (chkTendn.isPresent()) {
//            result.rejectValue("tenDN", "error.tk", "Tên đăng nhập đã tồn tại");
//            return "/template/login-form-02/signup";
//        }
//
//        Optional<Account> chkEmail = accountDao.findByEmail(tk.getEmail());
//        if (chkEmail.isPresent()) {
//            result.rejectValue("email", "error.tk", "Email đã được đăng ký");
//            return "/template/login-form-02/signup";
//        }
//
//        if (!EmailVerifier.verifyEmail(tk.getEmail())) {
//            result.rejectValue("email", "error.tk", "Email không tồn tại!");
//            return "/template/login-form-02/signup";
//        }
//
//        try {
//            Account account = new Account();
//            Optional<Role> role = roleDAO.findByIdrole(2);
//            if (role.isPresent()) {
//                account.setHoTen(tk.getHoTen());
//                account.setTenDN(tk.getTenDN());
//                account.setMatKhau(tk.getMatKhau());
//                account.setSdt(tk.getSdt());
//                account.setEmail(tk.getEmail());
//                account.setRole(role.get());
//                accountDao.save(account);
//            }
//
//            // Generate confirmation token
//            String confirmationToken = tk.getEmail(); // Đây chỉ là một ví dụ, bạn có thể tạo token bảo mật hơn
//            sessionService.set("confirmationToken", confirmationToken);
//
//            // Send confirmation email
//            String subject = "Xác nhận đăng ký tài khoản";
//            String body = "Chào " + tk.getHoTen() + ",\n\n" +
//                    "Cảm ơn bạn đã đăng ký tài khoản tại trang web của chúng tôi.\n" +
//                    "Vui lòng nhấn vào liên kết sau để xác nhận đăng ký của bạn:\n" +
//                    "http://localhost:8080/account/confirm?token=" + confirmationToken;
//            MailInfo mailInfo = new MailInfo();
//            mailInfo.setFrom("THELIEM" + "<bichntnpc06726@fpt.edu.vn>");
//            mailInfo.setTo(tk.getEmail());
//            mailInfo.setSubject(subject);
//            mailInfo.setBody(body);
//
//            emailService.send(mailInfo);
//
//            return "/template/confirm";
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.rejectValue("tenDN", "error.tk", "Có lỗi xảy ra. Vui lòng thử lại.");
//            model.addAttribute("errorMessage", "Tên đăng nhập hoặc email đã tồn tại.");
//        }
//
//        return "/template/login-form-02/signup";
//    }

	
	@PostMapping("signup")
	public String signup(@Valid @ModelAttribute("tk") Account tk, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        return "/template/login-form-02/signup";
	    }
	    
	    Optional<Account> chkTendn = accountDao.findByTenDN(tk.getTenDN());
	    if (chkTendn.isPresent()) {
	        result.rejectValue("tenDN", "error.tk", "Tên đăng nhập đã tồn tại");
	        return "/template/login-form-02/signup";
	    }
	    
	    Optional<Account> chkEmail = accountDao.findByEmail(tk.getEmail());
	    if (chkEmail.isPresent()) {
	        result.rejectValue("email", "error.tk", "Email đã được đăng ký");
	        return "/template/login-form-02/signup";
	    } else if (!verifyEmail(tk.getEmail())) {
	        result.rejectValue("email", "error.tk", "Email không tồn tại!");
	        return "/template/login-form-02/signup";
	    }

	    try {
	        Account account = new Account();
	        Optional<Role> role = roleDAO.findByIdrole(2);
	        if (role.isPresent()) {
	            account.setHoTen(tk.getHoTen());
	            account.setTenDN(tk.getTenDN());
	            account.setMatKhau(tk.getMatKhau());
	            account.setSdt(tk.getSdt());
	            account.setEmail(tk.getEmail());
	            account.setRole(role.get());
	            accountDao.save(account);
	        }
	        
	        // Generate confirmation token (here we use email as token for simplicity)
	        String confirmationToken = tk.getEmail();
	        sessionService.set("confirmationToken", confirmationToken);

	        // Send confirmation email
	        String subject = "Xác nhận đăng ký tài khoản";
	        String body = "Chào " + tk.getHoTen() + ",\n\n" + 
	                      "Cảm ơn bạn đã đăng ký tài khoản tại trang web của chúng tôi.\n" + 
	                      "Vui lòng nhấn vào liên kết sau để xác nhận đăng ký của bạn:\n" + 
	                      "http://localhost:8080/account/confirm/" + tk.getEmail();
	        MailInfo mailInfo = new MailInfo();
	        mailInfo.setFrom("THELIEM <bichntnpc06726@fpt.edu.vn>");
	        mailInfo.setTo(tk.getEmail());
	        mailInfo.setSubject(subject);
	        mailInfo.setBody(body);

	        emailService.send(mailInfo);

	        return "redirect:/account/login";
	    } catch (Exception e) {
	        e.printStackTrace();
	        result.rejectValue("tenDN", "error.tk", "Tên đăng nhập đã tồn tại.");
	        model.addAttribute("errorMessage", "Tên đăng nhập hoặc email đã tồn tại.");
	    }

	    return "/template/login-form-02/signup";
	}
	
	
	public static boolean verifyEmail(String email) {
	    HttpClient client = HttpClient.newHttpClient();
	    String url = "https://api.emaillistverify.com/api/verifyEmail?secret=HEzzdkhVn2gX1RYyDlooY&email=" + email;
	    System.out.println(url);
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create(url))
	            .GET()
	            .build();

	    try {
	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	        String responseBody = response.body();
	        System.out.println("Response body: " + responseBody);
	        // Assuming the API returns plain text 'ok' for valid email
	        return "ok".equalsIgnoreCase(responseBody.trim());
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	


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
	                    return "redirect:/home/0";
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
	
	// Đỗi mật khẩu
		@GetMapping("changepass")
		public String getchangepass(Model model,@ModelAttribute("pass") Pass pass) {
			return "/template/login-form-02/changepass";
		}
		
		@PostMapping("changepass")
		public String changePass(Model model,@ModelAttribute("pass") Pass pass) throws IllegalStateException, IOException{
			Account account = session.get("account");
			if(account == null) {
				return "/template/login-form-02/changepass";
			}
			Account item = accountDao.findById(account.getTenDN()).get();
			System.out.println("mật khẩu củ trong db "+item.getMatKhau());
			System.out.println("mật khẩu củ nhập vào "+ pass.getOpass());
			
			String mkc = item.getMatKhau();
			String mkm = pass.getNpass();
					
			if(!pass.getOpass().equals(mkc)) {
				System.out.println("sai mật khẩu");	
				model.addAttribute("error", "Sai mật khẩu.");		
				return "/template/login-form-02/changepass";
			}
			
			
			if(!pass.getNpass().equals(pass.getCfpass())) {
				System.out.println("mật khẩu không khớp");
				model.addAttribute("error", "Mật khẩu và xác nhận mật khẩu không khớp.");			
				return "/template/login-form-02/changepass";
			}
			
			item.setMatKhau(mkm);
			accountDao.save(item);
			return "redirect:/account/logout";
		}
}
