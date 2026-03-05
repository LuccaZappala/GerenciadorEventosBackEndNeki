package com.gerenciador.eventos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDTO {
	
	private AdministradorDTO admin;
	private String token;

}
