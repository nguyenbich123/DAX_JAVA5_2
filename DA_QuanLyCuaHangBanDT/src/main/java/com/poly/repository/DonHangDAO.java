package com.poly.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Account;
import com.poly.entity.DonHang;

public interface DonHangDAO extends JpaRepository<DonHang,Integer>{

	// Truy vấn lấy ra danh sách đơn hàng của tài khoản đăng nhập
    Page<DonHang> findByMaKH(Account account, Pageable pageable);
}
