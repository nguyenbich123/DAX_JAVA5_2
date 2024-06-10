package com.poly.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Account;
import com.poly.entity.ChiTietGioHang;
import com.poly.entity.ChiTietSP;
import com.poly.entity.GioHang;
import com.poly.repository.AccountDAO;
import com.poly.repository.ChiTietGioHangDAO;
import com.poly.repository.ChiTietSanPhamDAO;
import com.poly.repository.GioHangDAO;
@Controller
public class DetailProductController {

    @Autowired
    private ChiTietSanPhamDAO ctspDAO;

    @Autowired
    private ChiTietGioHangDAO ctghDAO;

    @Autowired
    private GioHangDAO ghDAO;

    @Autowired
    private AccountDAO accountDAO;

    
}
