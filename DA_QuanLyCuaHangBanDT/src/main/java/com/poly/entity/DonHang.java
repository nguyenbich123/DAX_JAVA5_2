package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "DONHANG_")
public class DonHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDH;
    
    @ManyToOne
    @JoinColumn(name = "TenDN")
    private Account maKH;
    
    @ManyToOne
    @JoinColumn(name = "MaPT")
    private PTTT maPT;
    
    @ManyToOne
    @JoinColumn(name = "IdTTDH")
    private TTDH ttdh;
    
    @ManyToOne
    @JoinColumn(name = "IdTTTT")
    private TTDH tttt;
    
    private Date ngayTT;
    private Double tongTien;
    private String ghiChu;
    
    @ManyToOne
    @JoinColumn(name = "Idgiamgia")
    private GiamGia maGG;
}
