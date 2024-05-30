package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class DanhGia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer danhGia;
    
    @ManyToOne
    @JoinColumn(name = "TenDN")
    private Account maKH;
    
    @ManyToOne
    @JoinColumn(name = "MaSP")
    private SanPham maSP;
}
