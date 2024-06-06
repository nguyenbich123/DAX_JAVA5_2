package com.poly.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SANPHAM_")
public class SanPham {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Masp")
    private Integer maSP;
    
    @Column(name="Tensp")
    private String tenSP;
    
    @ManyToOne
    @JoinColumn(name = "Mahang")
    private Hang maHang;
    
    @ManyToOne
    @JoinColumn(name = "Mahdh")
    private HeDieuHanh maHDH;
    
    private String chip;
    
    @ManyToOne
    @JoinColumn(name = "Idmanhinh")
    private ManHinh manHinh;
    
    @ManyToOne
    @JoinColumn(name = "Idpin")
    private PinSac pinSac;
    
    @Column(name="Hotrosac")
    private String hoTroSac;
    
    @Column(name="Sim")
    private String sim;
    
    @ManyToOne
    @JoinColumn(name = "Idcamtruoc")
    private CameraTruoc camTruoc;
    
    @ManyToOne
    @JoinColumn(name = "Idcamsau")
    private CameraSau camSau;
    
//    @OneToMany(mappedBy = "maSP")
//	List<ChiTietSP> chiTietSP;
}
