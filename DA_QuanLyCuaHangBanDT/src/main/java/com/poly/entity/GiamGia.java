package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "GIAMGIA_")
public class GiamGia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idgiamgia")
    private Integer idGiamGia;

    @Column(name="Magg")
    @NotBlank(message = "{NotBlank.item.maGG}")
    private String maGG;

    @Column(name="Giamgia")
    @NotNull(message = "{NotNull.item.giamGia}")
    private Float giamGia;

    @Column(name="Dhtt")
    @NotNull(message = "{NotNull.item.dhtt}")
    private Float dhtt;

    @Column(name="Stgtd")
    @NotNull(message = "{NotNull.item.stgtd}")
    private Float stgtd;

    @Column(name="Tgap")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tgAp;

    @Column(name="Tgkt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tgKt;

    @Column(name="Img")
    private String img;
}
