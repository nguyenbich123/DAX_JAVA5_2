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
    @JoinColumn(name = "ID_MANHINH")
    private ManHinh manHinh;
    
    @ManyToOne
    @JoinColumn(name = "ID_PIN")
    private PinSac pinSac;
    
    private String hoTroSac;
    private String sim;
    
    @ManyToOne
    @JoinColumn(name = "ID_CAMTRUOC")
    private CameraTruoc camTruoc;
    
    @ManyToOne
    @JoinColumn(name = "ID_CAMSAU")
    private CameraSau camSau;
}
