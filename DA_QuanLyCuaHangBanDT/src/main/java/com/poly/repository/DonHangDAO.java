package com.poly.repository;

import java.util.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.DonHang;

public interface DonHangDAO extends JpaRepository<DonHang,Integer>{
	
	@Query("SELECT COUNT(DISTINCT maKH) sokh FROM DonHang o WHERE month(ngayTT) = month(?1) group by ngayTT")
	List<Object> findKHByngayTT(Date ngaytt);
	
	@Query("SELECT sum(tongTien) FROM DonHang o WHERE month(ngayTT) = month(?1) group by ngayTT")
	List<Object> findDTByngayTT(Date ngaytt);
	
	@Query("SELECT count(*) FROM DonHang o WHERE month(ngayTT) = month(?1) group by ngayTT")
	List<Object> findDHByngayTT(Date ngaytt);
	
	@Query("SELECT COUNT(DISTINCT maKH) FROM DonHang o WHERE o.ngayTT = ?1")
	List<Object> findKHBytday(Date ngaytt);
	
	
}
