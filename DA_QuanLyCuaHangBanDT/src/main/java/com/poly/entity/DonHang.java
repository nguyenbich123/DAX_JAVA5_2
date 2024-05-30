package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
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
    @JoinColumn(name = "ID_TTDH")
    private TTDH ttdh;
    
    private Date ngayTT;
    private Float tongTien;
    private String ghiChu;
    
    @ManyToOne
    @JoinColumn(name = "ID_GIAMGIA")
    private GiamGia maGG;
}
