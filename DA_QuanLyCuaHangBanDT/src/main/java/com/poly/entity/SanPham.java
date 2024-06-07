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
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "SANPHAM_")
public class SanPham {
    
	private static final long serialVersionUID = 1L;
	
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
    
    private String sim;
    
    @ManyToOne
    @JoinColumn(name = "Idcamtruoc")
    private CameraTruoc camTruoc;
    
    @ManyToOne
    @JoinColumn(name = "Idcamsau")
    private CameraSau camSau;
}
