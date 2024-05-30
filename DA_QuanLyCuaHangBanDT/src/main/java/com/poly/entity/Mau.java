package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Mau {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maMau;
    private String mauSac;
}
