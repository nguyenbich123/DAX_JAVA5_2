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
@Table(name = "DIACHI_")
public class DiaChi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Iddiachi")
    private Integer id_diaChi;
    
    @ManyToOne
    @JoinColumn(name = "Tendn")
    private Account tenDN;
    
    @Column(name="Duongsonha")
    private String duong_Sonha;
    
    @Column(name="Quanhuyen")
    private String quan_Huyen;
    
    @Column(name="Tinhthanhpho")
    private String tinh_ThanhPho;
}
