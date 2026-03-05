package com.gerenciador.eventos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.eventos.dto.AdministradorCadastroDTO;
import com.gerenciador.eventos.dto.AdministradorDTO;
import com.gerenciador.eventos.model.Administrador;
import com.gerenciador.eventos.repository.AdministradorRepository;

@Service
public class AdministradorService {
	
	@Autowired
	AdministradorRepository repository;
	
	public AdministradorDTO cadastrar(AdministradorCadastroDTO dto) {
		
		Administrador admin = new Administrador();
		admin.setNome(dto.getNome());
		admin.setEmail(dto.getEmail());
		admin.setSenha(dto.getSenha());
		
		Administrador salvo = repository.save(admin);
		
		return new AdministradorDTO(salvo.getId(), salvo.getNome(), salvo.getEmail());
	}

}
