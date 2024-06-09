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
@Table(name = "CNP_")
public class CNP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Idcnp")
	private Integer idcnp;
	
	@Column(name = "Congnghepin")
	@NotBlank(message = "{NotBlank.cnp.congNghePin}")
	private String congNghePin;

}

