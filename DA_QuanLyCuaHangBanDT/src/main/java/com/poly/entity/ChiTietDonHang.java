package com.poly.entity;

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
@Table(name = "CHITIETDONHANG_")
public class ChiTietDonHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idctdh")
    private Integer id_CTDH;
    
    @ManyToOne
    @JoinColumn(name = "Mactsp")
    private ChiTietSP maCTSP;

    @Column(name="Soluong")
    private Integer soLuong;

    @Column(name="Gia")
    private Float gia;
    
    @ManyToOne
    @JoinColumn(name = "Madh")
    private DonHang maDH;
}
