package com.poly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DUNGLUONG")
public class DungLuong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDL;
    private String dungLuong;
}
