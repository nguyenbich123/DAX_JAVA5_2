package com.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.repository.ChiTietGioHangDAO;

@Service
public class CartService {

    @Autowired
    private ChiTietGioHangDAO ctghDAO;

    public Integer getTotalQuantity(String customerId) {
        return ctghDAO.getTotalQuantityByCustomerId(customerId);
    }
    
    public void updateProductQuantity(Integer mactsp, Integer quantity) {
        ctghDAO.updateProductQuantity(mactsp, quantity);
    }
    
    
    
    
    
}