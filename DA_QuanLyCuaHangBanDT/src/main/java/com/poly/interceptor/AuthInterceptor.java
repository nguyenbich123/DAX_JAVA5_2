package com.poly.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.poly.entity.Account;
import com.poly.utils.SessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthInterceptor implements HandlerInterceptor {
	@Autowired
	SessionService session;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		Account account = session.get("account"); // lấy từ session
		String error = "";
		if (account == null) { // chưa đăng nhập
			error = "Please login!";
		}
		// không đúng vai trò
		else if (!account.getRole().getRole().equals("Admin") && uri.startsWith("/admin/")) {
			error = "Access denied!";
		}
		if (error.length() > 0) { // có lỗi
			response.sendRedirect("/login?error=" + error);
			return false;
		}
		return true;
	}
}
