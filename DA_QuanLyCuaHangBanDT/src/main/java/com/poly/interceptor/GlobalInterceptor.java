package com.poly.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.poly.entity.Account;
import com.poly.service.CartService;
import com.poly.utils.SessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class GlobalInterceptor implements HandlerInterceptor {


	@Autowired
	CartService cartService;
	
	@Autowired
	SessionService session;
	 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("uri", request.getRequestURI());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mv)
			throws Exception {
		if(session.get("account") != null) {
        	// Lấy thông tin tài khoản người dùng
            Account currentAccount = (Account)session.get("account");
    		int sl = cartService.getTotalQuantity(currentAccount.getTenDN());
    		req.setAttribute("sl", sl);
    		
        }
		
	}
}
