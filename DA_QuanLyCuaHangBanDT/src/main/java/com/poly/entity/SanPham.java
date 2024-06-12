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
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "{NotBlank.item.tenSP}")
    private String tenSP;
    
    @ManyToOne
    @JoinColumn(name = "Mahang")
    @NotNull(message = "{NotNull.item.maHang}")
    private Hang maHang;
    
    @ManyToOne
    @JoinColumn(name = "Mahdh")
    @NotNull(message = "{NotNull.item.maHDH}")
    private HeDieuHanh maHDH;
    
    @Column(name="Chip")
    @NotBlank(message = "{NotBlank.item.chip}")
    private String chip;
    
    @ManyToOne
    @JoinColumn(name = "Idmanhinh")
    @NotNull(message = "{NotNull.item.manHinh}")
    private ManHinh manHinh;
    
    @ManyToOne
    @JoinColumn(name = "Idpin")
    @NotNull(message = "{NotNull.item. pinSac}")
    private PinSac pinSac;
    
    @Column(name="Sim")
    @NotBlank(message = "{NotBlank.item.sim}")
    private String sim;
    
    @ManyToOne
    @JoinColumn(name = "Idcamtruoc")
    @NotNull(message = "{NotNull.item.camTruoc}")
    private CameraTruoc camTruoc;
    
    @ManyToOne
    @JoinColumn(name = "Idcamsau")
    @NotNull(message = "{NotNull.item.camSau}")
    private CameraSau camSau;
    
    
    @OneToMany(mappedBy = "maSP")
	List<ChiTietSP> ctsp; 
}
