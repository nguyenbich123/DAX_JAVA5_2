package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TRANGTHAITT")
public class TrangThaiTT {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String trangThai;
}
