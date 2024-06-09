package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.serviceImpl.MailerServiceImpl;

@Controller
@RequestMapping("feedback")
public class FeedbackController {

    @Autowired
    MailerServiceImpl mailer;
    
    @GetMapping("view")
	public String getFeedback() {
		return "/template/user/feedback";
	}
    	
    @PostMapping("send")
    public String sendMail(@RequestParam String email, @RequestParam String feedback, Model model) {
        String subject = "Cảm Ơn Thư Góp Ý";
        String body = "Chúng Tôi Đã Ghi Nhận Thông Tin Góp Ý Của Bạn!!";

        mailer.send(email, subject, body);

        model.addAttribute("message", "Cảm ơn bạn đã gửi phản hồi!");

        return "/template/user/feedback"; 
    }
}
