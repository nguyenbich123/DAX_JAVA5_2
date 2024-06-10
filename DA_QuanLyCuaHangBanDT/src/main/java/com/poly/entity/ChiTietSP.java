package com.poly.entity;

import java.util.List;

import jakarta.persistence.Column;
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
@Table(name = "CHITIETSP_")
public class ChiTietSP {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maCTSP;
    
    @ManyToOne
    @JoinColumn(name = "Masp")
    private SanPham maSP;
    
    @ManyToOne
    @JoinColumn(name = "Mamau")
    private Mau maMau;
    
    @ManyToOne
    @JoinColumn(name = "Madl")
    private DungLuong maDL;
    
    @ManyToOne
    @JoinColumn(name = "Maram")
    private Ram maRam;
    
    @Column(name="Soluong")
    private Integer soLuong;
    
    private Double gia;
    
    @Column(name="img")
    private String img;
}
