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
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

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
    @NotBlank(message = "{NotBlank.sanpham.tenSP}")
    private String tenSP;
    
    @ManyToOne
    @JoinColumn(name = "Mahang")
    @NotBlank(message = "{NotBlank.sanpham.maHang}")
    private Hang maHang;
    
    @ManyToOne
    @JoinColumn(name = "Mahdh")
    @NotBlank(message = "{NotBlank.sanpham.maHDH}")
    private HeDieuHanh maHDH;
    
    @Column(name="Chip")
    @NotBlank(message = "{NotBlank.sanpham.Chip}")
    private String chip;
    
    @ManyToOne
    @JoinColumn(name = "Idmanhinh")
    private ManHinh manHinh;
    
    @ManyToOne
    @JoinColumn(name = "Idpin")
    private PinSac pinSac;
    
    @Column(name="Sim")
    @NotBlank(message = "{NotBlank.sanpham.sim}")
    private String sim;
    
    @ManyToOne
    @JoinColumn(name = "Idcamtruoc")
    @NotBlank(message = "{NotBlank.sanpham.camTruoc}")
    private CameraTruoc camTruoc;
    
    @ManyToOne
    @JoinColumn(name = "Idcamsau")
    @NotBlank(message = "{NotBlank.sanpham.camSau}")
    private CameraSau camSau;


    @OneToMany(mappedBy = "maSP")
	List<ChiTietSP> ctsp;
}
