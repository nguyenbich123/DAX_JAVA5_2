package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "CHITIETSP_")
public class ChiTietSP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Mactsp")
    private Integer maCTSP;

    @ManyToOne
    @JoinColumn(name = "Masp")
    @ToString.Exclude
    private SanPham maSP;

    @ManyToOne
    @JoinColumn(name = "Mamau")
    @NotNull(message = "{NotNull.ctsp.maMau}")
    private Mau maMau;

    @ManyToOne
    @JoinColumn(name = "Madl")
    @NotNull(message = "{NotNull.ctsp.maDL}")
    private DungLuong maDL;

    @ManyToOne
    @JoinColumn(name = "Maram")
    @NotNull(message = "{NotNull.ctsp.maRam}")
    private Ram maRam;

    @Column(name="Soluong")
    @NotNull(message = "{NotNull.ctsp.soluong}")
    private Integer soluong;

    @Column(name = "Gia")
    @NotNull(message = "{NotNull.ctsp.gia}")
    private Double gia;

    @Column(name="Img")
    private String img;
}
