package com.poly.entity;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "ACCOUNT_")
public class Account {

    @Id
    @Column(name="Tendn")
    @NotBlank(message = "{NotBlank.tk.tenDN}")
    private String tenDN;

    @Column(name="Matkhau")
    @NotBlank(message = "{NotBlank.tk.matKhau}")
    private String matKhau;

    @Column(name="Hoten")
    @NotBlank(message = "{NotBlank.tk.hoTen}")
    private String hoTen;

    @Column(name="Sdt")
    @NotBlank(message = "{NotBlank.tk.sdt}")
    private String sdt;

    @Column(name="Email")
    @NotBlank(message = "{NotBlank.tk.email}")
    @Email(message = "{Email.tk.email}")
    private String email;

    @Column(name="Img")
    private String img;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Idrole")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Idtthd")
    private TrangThaiHD tthd;

    @OneToMany(mappedBy = "tenDN", fetch = FetchType.LAZY)
    private List<DiaChi> diachi;
}
