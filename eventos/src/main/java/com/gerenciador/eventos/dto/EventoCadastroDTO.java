package com.gerenciador.eventos.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventoCadastroDTO {
	
	private String titulo;
	private String localizacao;
	private LocalDate data;
	private String imagem;
	private Long idAdministrador;

}
