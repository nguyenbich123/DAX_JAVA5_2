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
@Table(name = "HINH_")
public class Hinh {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Mahinh")
    private Integer maHinh;
    
    @ManyToOne
    @JoinColumn(name = "MaCTSP")
    private ChiTietSP maCTSP;
    
    @Column(name="Img")
    private String img;
}
