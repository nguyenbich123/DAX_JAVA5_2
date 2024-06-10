package com.poly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Account;
import com.poly.entity.ChiTietDonHang;
import com.poly.entity.DonHang;

public interface ChiTietDonHangDAO extends JpaRepository<ChiTietDonHang,Integer>{
	// Truy vấn lấy ra danh sách chi tiết đơn hàng của các đơn hàng của tài khoản đăng nhập
	List<ChiTietDonHang> findByMaDH(DonHang maDH);
}
