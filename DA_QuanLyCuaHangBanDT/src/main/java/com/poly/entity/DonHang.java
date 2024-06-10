package com.poly.entity;

import java.util.Date;

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
@Table(name = "DONHANG_")
public class DonHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDH;
    
    @ManyToOne
    @JoinColumn(name = "Makh")
    private Account maKH;
    
    @ManyToOne
    @JoinColumn(name = "Mapt")
    private PTTT maPT;
    
    @ManyToOne
    @JoinColumn(name = "Idttdh")
    private TTDH ttdh;
    
    @ManyToOne
    @JoinColumn(name = "Idtttt")
    private TrangThaiTT tttt;
    
    @Column(name="Ngaytt")
    private Date ngayTT;
    
    @Column(name="Tongtien")
    private Double tongTien;
    
    @Column(name="Ghichu")
    private String ghiChu;
    
    @ManyToOne
    @JoinColumn(name = "Idgiamgia")
    private GiamGia maGG;
    
    @Column(name = "Diachi")
    private String diaChi;
}
