package com.poly.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "TRANGTHAIHD_")
public class TrangThaiHD {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Idtthd;
    
    @Column(name="Trangthai")
    @NotBlank(message = "{NotBlank.ttHD.trangThai}")
    String trangThai;
    
    @OneToMany(mappedBy = "tthd")
    @NotEmpty(message = "{NotEmpty.ttHD.accounts}")
	List<Account> accounts;
}
