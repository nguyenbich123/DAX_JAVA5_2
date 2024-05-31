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
@Table(name = "SANPHAM")
public class SanPham {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maSP;
    private String tenSP;
    
    @ManyToOne
    @JoinColumn(name = "MaHang")
    private Hang maHang;
    
    @ManyToOne
    @JoinColumn(name = "MaHDH")
    private HeDieuHanh maHDH;
    
    private String chip;
    
    @ManyToOne
    @JoinColumn(name = "IdManHinh")
    private ManHinh manHinh;
    
    @ManyToOne
    @JoinColumn(name = "IdPin")
    private PinSac pinSac;
    
    private String hoTroSac;
    private String sim;
    
    @ManyToOne
    @JoinColumn(name = "IdCamTruoc")
    @Column(name = "CamTruoc")
    private CameraTruoc camTruoc;
    
    @ManyToOne
    @JoinColumn(name = "IdCamSau")
    @Column(name = "CamSau")
    private CameraSau camSau;
}
