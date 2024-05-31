package com.poly.entity;

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
@Table(name = "DIACHI")
public class DiaChi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_diaChi;
    
    @ManyToOne
    @JoinColumn(name = "TenDN")
    private Account tenDN;

    private String duong_Sonha;
    private String quan_Huyen;
    private String tinh_ThanhPho;
}
