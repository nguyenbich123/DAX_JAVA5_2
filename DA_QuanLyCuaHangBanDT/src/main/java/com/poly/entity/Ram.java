package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "RAM")
public class Ram {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maRam;
    private String ram;
}
