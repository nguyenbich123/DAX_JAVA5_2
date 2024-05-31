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
@Table(name = "DONHANG")
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
    
    @ManyToOne
    @JoinColumn(name = "ID_TTTT")
    private TTDH tttt;
    
    private Date ngayTT;
    private Double tongTien;
    private String ghiChu;
    
    @ManyToOne
    @JoinColumn(name = "ID_GIAMGIA")
    private GiamGia maGG;
}
