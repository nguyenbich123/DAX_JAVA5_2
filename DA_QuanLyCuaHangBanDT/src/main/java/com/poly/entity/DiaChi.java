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
    @NotBlank(message="{NotBlank.diachi.duong_Sonha}")
    private String duong_Sonha;
    
    @Column(name="Quanhuyen")
    @NotBlank(message="{NotBlank.diachi.quan_Huyen}")
    private String quan_Huyen;
    
    @Column(name="Tinhthanhpho")
    @NotBlank(message="{NotBlank.diachi.tinh_ThanhPho}")
    private String tinh_ThanhPho;
}
