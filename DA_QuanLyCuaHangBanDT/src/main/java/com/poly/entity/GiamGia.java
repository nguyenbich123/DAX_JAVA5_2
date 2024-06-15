package com.poly.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "GIAMGIA_")
public class GiamGia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idgiamgia")
    private Integer idGiamGia;
    
    @Column(name="Magg")
    @NotBlank(message = "{NotBlank.gg.maGG}")
    private String maGG;
    
    @Column(name="Giamgia")
    @NotNull(message = "{@NotNull.gg.giamGia}")
    private Float giamGia;
    
    @Column(name="Dhtt")
    private Float dhtt;
    
    @Column(name="Stgtd")
    private Float stgtd;
    
    @Column(name="Tgap")
    private Date tgAp;
    
    @Column(name="Tgkt")
    private Date tgKt;
    
    @Column(name="Img")
    private String img;
    
    @Column(name="Soluong")
    private Integer soLuong;
}
