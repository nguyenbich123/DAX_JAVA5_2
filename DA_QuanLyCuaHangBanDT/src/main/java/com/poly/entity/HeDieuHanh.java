package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "HEDIEUHANH_")
public class HeDieuHanh {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maHDH;
    private String tenHDH;
}
