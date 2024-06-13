package com.poly.repository;

import java.util.Date;
import java.util.List;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Account;
import com.poly.entity.DonHang;
import java.util.List;


public interface DonHangDAO extends JpaRepository<DonHang,Integer>{


	// biểu đồ 2
		@Query("SELECT COUNT(DISTINCT maKH) sokh FROM DonHang o WHERE MONTH(o.ngayTT) = MONTH(?1) AND YEAR(o.ngayTT) = YEAR(?1) group by ngayTT")
		List<Object> findKHByngayTT(Date ngaytt);

		@Query("SELECT sum(tongTien)/1000000 FROM DonHang o WHERE MONTH(o.ngayTT) = MONTH(?1) AND YEAR(o.ngayTT) = YEAR(?1) group by ngayTT")
		List<Object> findDTByngayTT(Date ngaytt);

		@Query("SELECT count(*) FROM DonHang o WHERE MONTH(o.ngayTT) = MONTH(?1) AND YEAR(o.ngayTT) = YEAR(?1) group by ngayTT")
		List<Object> findDHByngayTT(Date ngaytt);

		@Query("SELECT ngayTT FROM DonHang o WHERE MONTH(o.ngayTT) = MONTH(?1) AND YEAR(o.ngayTT) = YEAR(?1) group by ngayTT")
		List<Object> findByngayTT(Date ngaytt);

	// biểu đồ 1
		// khách hàng
			@Query("SELECT COUNT(DISTINCT maKH) FROM DonHang o WHERE DAY(o.ngayTT)=DAY(?1) AND MONTH(o.ngayTT) = MONTH(?1) AND YEAR(o.ngayTT) = YEAR(?1)")
			List<Integer> findKHBytday(Date ngaytt);

			@Query("SELECT COUNT(DISTINCT maKH) FROM DonHang o WHERE MONTH(o.ngayTT) = MONTH(?1) AND YEAR(o.ngayTT) = YEAR(?1)")
			List<Integer> findKHBytmonth(Date ngaytt);

			@Query("SELECT COUNT(DISTINCT maKH) FROM DonHang o WHERE YEAR(o.ngayTT) = YEAR(?1)")
			List<Integer> findKHBytyear(Date ngaytt);

		// doanh thu
			@Query("SELECT sum(tongTien)/1000000 FROM DonHang o WHERE DAY(o.ngayTT)=DAY(?1) AND MONTH(o.ngayTT) = MONTH(?1) AND YEAR(o.ngayTT) = YEAR(?1)")
			List<Integer> findDTBytday(Date ngaytt);

			@Query("SELECT sum(tongTien)/1000000 FROM DonHang o WHERE MONTH(o.ngayTT) = MONTH(?1) AND YEAR(o.ngayTT) = YEAR(?1)")
			List<Integer> findDTBytmonth(Date ngaytt);

			@Query("SELECT sum(tongTien)/1000000 FROM DonHang o WHERE YEAR(o.ngayTT) = YEAR(?1)")
			List<Integer> findDTBytyear(Date ngaytt);

		// đơn hàng
			@Query("SELECT count(*) FROM DonHang o WHERE DAY(o.ngayTT)=DAY(?1) AND MONTH(o.ngayTT) = MONTH(?1) AND YEAR(o.ngayTT) = YEAR(?1)")
			List<Integer> findDHBytday(Date ngaytt);

			@Query("SELECT count(*) FROM DonHang o WHERE MONTH(o.ngayTT) = MONTH(?1) AND YEAR(o.ngayTT) = YEAR(?1)")
			List<Integer> findDHBytmonth(Date ngaytt);

			@Query("SELECT count(*) FROM DonHang o WHERE YEAR(o.ngayTT) = YEAR(?1)")
			List<Integer> findDHBytyear(Date ngaytt);

	// Truy vấn lấy ra danh sách đơn hàng của tài khoản đăng nhập
	Page<DonHang> findByMaKH(Account account, Pageable pageable);
    Page<DonHang> findByMaKHAndTtdhTrangThai(Account account, String trangThai, Pageable pageable);

    Optional<DonHang> findByMaDH(Integer maDH);
    
    @Query("SELECT o FROM DonHang o WHERE o.maKH = :account ORDER BY o.ngayTT DESC")
    Optional<DonHang> findLatestOrder(@Param("account") Account account);
}
