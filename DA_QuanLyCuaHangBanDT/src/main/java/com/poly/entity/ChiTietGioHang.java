package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "CHITIETGIOHANG_")
public class ChiTietGioHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idctgh")
    private Integer id_CTGH;
    
    @ManyToOne
    @JoinColumn(name = "Mactsp")
    private ChiTietSP maCTSP;
    
    @Column(name="Soluong")
    private Integer soLuong;
    
    @ManyToOne
    @JoinColumn(name = "Magh")
    private GioHang maGH;
}
