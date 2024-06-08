package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "TNCS_")
public class TNCS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Idtncs")
	private Integer idTNCS;
	
	@Column(name = "Tinhnang")
	@NotBlank(message = "{NotBlank.item.tinhNang}")
	private String tinhNang;

}
