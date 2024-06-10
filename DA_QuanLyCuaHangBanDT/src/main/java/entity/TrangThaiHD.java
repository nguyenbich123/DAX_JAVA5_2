package com.poly.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TRANGTHAIHD_")
public class TrangThaiHD {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Idtthd;
    
    @Column(name="Trangthai")
    String trangThai;
    
    @OneToMany(mappedBy = "tthd")
	List<Account> accounts;
}
