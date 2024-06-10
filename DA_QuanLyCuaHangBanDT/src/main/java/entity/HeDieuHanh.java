package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "HEDIEUHANH_")
public class HeDieuHanh {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Mahdh")
    private Integer maHDH;
    
    @Column(name="Tenhdh")
      @NotBlank(message = "{NotBlank.hdh.tenHDH}")
    private String tenHDH;
}
