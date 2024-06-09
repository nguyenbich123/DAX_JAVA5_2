package com.poly.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "ACCOUNT_")
public class Account {

	@Id
    @Column(name="Tendn")
    @NotBlank(message = "{NotBlank.item.tenDN}")
    String tenDN;
    

	
    @Column(name="Matkhau")
    @NotBlank(message = "{NotBlank.item.matKhau}")
    String matKhau;
    
    @Column(name="Hoten")
    @NotBlank(message = "{NotBlank.item.hoTen}")
    String hoTen;
    
    @Column(name="Sdt")
    @NotBlank(message = "{NotBlank.item.sdt}")
    String sdt;
    
   
    @Column(name="Email")
    @NotBlank(message = "{NotBlank.item.email}")
    @Email(message = "{Email.item.email}")
    String email;
    
    @Column(name="Img")
    String img;

    @ManyToOne
    @JoinColumn(name = "Idrole")
    Role role;

    @ManyToOne
    @JoinColumn(name = "Idtthd")
    TrangThaiHD tthd;
    
	@OneToMany(mappedBy = "tenDN")
	List<DiaChi> diachi;

}
