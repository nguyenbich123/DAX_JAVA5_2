package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "GIAMGIA_")
public class GiamGia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idgiamgia")
    private Integer id_giamGia;
    
    @Column(name="Magg")
    private String maGG;
    
    @Column(name="Giamgia")
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
}
