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
@Table(name = "DLP_")
public class DLP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Iddlp")
	private Integer idDLP;
	
	@Column(name = "Dlpin")
	@NotBlank(message = "{NotBlank.dlp.dlPin}")
	private String dlPin;

}
