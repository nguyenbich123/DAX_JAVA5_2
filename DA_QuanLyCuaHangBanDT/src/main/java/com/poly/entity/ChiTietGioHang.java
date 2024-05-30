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
public class ChiTietGioHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "MaCTSP")
    private ChiTietSP maCTSP;
    
    private Integer soLuong;
    
    @ManyToOne
    @JoinColumn(name = "MaGH")
    private GioHang maGH;
}
