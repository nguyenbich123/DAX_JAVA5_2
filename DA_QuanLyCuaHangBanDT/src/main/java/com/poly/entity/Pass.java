package com.poly.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pass {

	@NotBlank(message = "{NotBlank.pass.opass}")
	private String opass;
	@NotBlank(message = "{NotBlank.pass.npass}")
	private String npass;
	@NotBlank(message = "{NotBlank.pass.cfpass}")
	private String cfpass;
}
