package com.gerenciador.eventos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.eventos.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{
	
	List<Evento> findByAdministradorId(Long adminId);

}
