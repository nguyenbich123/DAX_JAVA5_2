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
@Table(name = "DANHGIA_")
public class DanhGia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_danhGia;
    private Integer danhGia;
    
    @ManyToOne
    @JoinColumn(name = "TenDN")
    private Account maKH;
    
    @ManyToOne
    @JoinColumn(name = "Masp")
    private SanPham maSP;
}
