package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CHITIETGIOHANG_")
public class ChiTietGioHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_CTGH;
    
    @ManyToOne
    @JoinColumn(name = "MaCTSP")
    private ChiTietSP maCTSP;
    
    private Integer soLuong;
    
    @ManyToOne
    @JoinColumn(name = "Magh")
    private GioHang maGH;
}
