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
public class ChiTietSP {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maCTSP;
    
    @ManyToOne
    @JoinColumn(name = "MaSP")
    private SanPham maSP;
    
    @ManyToOne
    @JoinColumn(name = "MaMau")
    private Mau maMau;
    
    @ManyToOne
    @JoinColumn(name = "MaDL")
    private DungLuong maDL;
    
    @ManyToOne
    @JoinColumn(name = "MaRam")
    private Ram maRam;
    
    private Integer soluong;
    private Float gia;
}
