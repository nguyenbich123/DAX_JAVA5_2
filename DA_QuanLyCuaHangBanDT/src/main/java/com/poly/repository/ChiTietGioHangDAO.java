package com.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.poly.entity.ChiTietGioHang;
import com.poly.entity.ChiTietSP;
import com.poly.entity.GioHang;

public interface ChiTietGioHangDAO extends JpaRepository<ChiTietGioHang,Integer>{
	
	 List<ChiTietGioHang> findByMaGHAndMaCTSP(GioHang gioHang, ChiTietSP chiTietSP);

	    List<ChiTietGioHang> findByMaGH(GioHang gioHang);
	    
	    // Truy vấn để lấy tổng số lượng sản phẩm trong giỏ hàng của một khách hàng
	    @Query("SELECT SUM(ctgh.soLuong) FROM ChiTietGioHang ctgh WHERE ctgh.maGH.maKH.tenDN = :account")
	    Integer getTotalQuantityByCustomerId(@Param("account") String customerId);

	    // Truy vấn để cập nhật số lượng sản phẩm
	  
	    @Query("UPDATE ChiTietGioHang ctgh SET ctgh.soLuong = :quantity WHERE ctgh.id_CTGH = :id")
	    void updateProductQuantity(@Param("id") Integer id, @Param("quantity") Integer quantity);

	    // Thêm phương thức xóa dựa trên maCTSP
	    @Modifying
	    @Transactional
	    @Query("DELETE FROM ChiTietGioHang ctgh WHERE ctgh.maCTSP.maCTSP = :mactsp")
	    void deleteByMaCTSP(@Param("mactsp") Integer maCTSP);
	    
	    ChiTietGioHang findByMaCTSPAndMaGH(ChiTietSP maCTSP, GioHang maGH);
	    
	    
	    
}
