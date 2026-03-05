package com.gerenciador.eventos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gerenciador.eventos.dto.AdministradorCadastroDTO;
import com.gerenciador.eventos.dto.AdministradorDTO;
import com.gerenciador.eventos.dto.LoginResponseDTO;
import com.gerenciador.eventos.model.Administrador;
import com.gerenciador.eventos.repository.AdministradorRepository;

@Service
public class AdministradorService {
	
	@Autowired
	AdministradorRepository repository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private TokenService tokenService;
	
	public AdministradorDTO cadastrar(AdministradorCadastroDTO dto) {
		
		Administrador admin = new Administrador();
		admin.setNome(dto.getNome());
		admin.setEmail(dto.getEmail());
		
		String senhaCriptografada = passwordEncoder.encode(dto.getSenha());
		admin.setSenha(senhaCriptografada);
		
		Administrador salvo = repository.save(admin);
		
		return new AdministradorDTO(salvo.getId(), salvo.getNome(), salvo.getEmail());
	}
	
	public LoginResponseDTO login(String email, String senha) {
		Administrador admin = repository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("E-mail não cadastrado."));
		
		if (passwordEncoder.matches(senha, admin.getSenha())){
			String token = tokenService.gerarToken(admin);
			AdministradorDTO adminDto = new AdministradorDTO(admin.getId(), admin.getNome(), admin.getEmail());
			
			return new LoginResponseDTO(adminDto, token);
	} else {
		throw new RuntimeException("Senha inválida");
	}
	}
	}

