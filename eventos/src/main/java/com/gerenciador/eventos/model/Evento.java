package com.gerenciador.eventos.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "eventos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String titulo;
	
	@Column(nullable=false)
	private String localizacao;
	
	@Column(nullable=false)
	private LocalDate data;
	
	@Column(columnDefinition = "TEXT")
	private String imagem;
	
	@ManyToOne
	@JoinColumn(name = "id_administrador", nullable = false)
	private Administrador administrador;

}