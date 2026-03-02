package com.gerenciador.eventos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.eventos.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long>{
	
	Optional<Administrador> findByEmail(String email);

}
