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
@Table(name = "HTS_")
public class HTS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Idhts")
	private Integer idHTS;
	
	@Column(name = "Hotrosac")
	@NotBlank(message = "{NotBlank.hts.hoTroSac}")
	private String hoTroSac;

}
