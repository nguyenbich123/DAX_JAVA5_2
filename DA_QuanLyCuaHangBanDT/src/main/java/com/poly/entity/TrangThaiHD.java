package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TRANGTHAIHD")
public class TrangThaiHD {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_THHD;
    String trangThai;
}
