package com.poly.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @NotNull(message = "{NotNull.gg.giamGia}")
    @Positive(message = "Phần trăm giảm giá phải là số dương.")	
    private Float giamGia;
    
    @Column(name="Dhtt")
    @NotNull(message = "{NotNull.gg.dhtt}")
    @Positive(message = "Đơn hàng tối thiểu phải là số dương.")	
    private Float dhtt;
    
    @Column(name="Stgtd")
    @NotNull(message = "{NotNull.gg.stgtd}")
    @Positive(message = "Số tiền giảm tối đa phải là số dương.")	
    private Float stgtd;
    
    @Column(name="Tgap")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tgAp;
    
    @Column(name="Tgkt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tgKt;
    
    @Column(name="Img")
    private String img;
    
    @Column(name="Soluong")
    @NotNull(message = "{NotNull.gg.soLuong}")
    private Integer soLuong;
    
    @Column(name="Slsd")
    private Integer slsd;
}
