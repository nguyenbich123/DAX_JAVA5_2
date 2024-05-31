package com.poly.entity;

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
    private Integer id_giamGia;
    private String maGG;
    private Float giamGia;
    private Float dhtt;
    private Float stgtd;
    private Date tgAp;
    private Date tgKt;
    private String img;
}
