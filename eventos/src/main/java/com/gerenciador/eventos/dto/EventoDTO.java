package com.gerenciador.eventos.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoDTO {
	
	private Long id;
	private String titulo;
	private String localizacao;
	private LocalDate data;
	private String imagem;
	private String nomeAdministrador;
	private Long adminId;

}
