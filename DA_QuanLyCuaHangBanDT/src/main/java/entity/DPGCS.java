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
@Table(name = "DPGCS_")
public class DPGCS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Iddpgcs")
	private Integer idDPGCS;
	
	@Column(name = "Dpg")
	@NotBlank(message = "{NotBlank.dpg.dpg}")
	private String dpg;

}

