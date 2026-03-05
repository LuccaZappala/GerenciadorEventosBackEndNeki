package com.gerenciador.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.eventos.dto.AdministradorCadastroDTO;
import com.gerenciador.eventos.dto.AdministradorDTO;
import com.gerenciador.eventos.dto.LoginDTO;
import com.gerenciador.eventos.dto.LoginResponseDTO; 
import com.gerenciador.eventos.service.AdministradorService;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {
	
	@Autowired
	private AdministradorService service;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<AdministradorDTO> cadastrar(@RequestBody AdministradorCadastroDTO dto) {
		return ResponseEntity.ok(service.cadastrar(dto));
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO dto) {
		
		LoginResponseDTO resposta = service.login(dto.getEmail(), dto.getSenha());
		return ResponseEntity.ok(resposta);
	}

}