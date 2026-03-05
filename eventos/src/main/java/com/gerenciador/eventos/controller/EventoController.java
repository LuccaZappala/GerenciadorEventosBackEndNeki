package com.gerenciador.eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.eventos.dto.EventoCadastroDTO;
import com.gerenciador.eventos.dto.EventoDTO;
import com.gerenciador.eventos.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
	private EventoService service;
	
	@PostMapping
	public ResponseEntity<EventoDTO> criar(@RequestBody EventoCadastroDTO dto) {
		return ResponseEntity.ok(service.salvar(dto));
	}
	
	@GetMapping("/admin/{adminId}")
	public ResponseEntity<List<EventoDTO>> listarPorAdmin(@PathVariable Long adminId) {
		return ResponseEntity.ok(service.listarPorAdmin(adminId));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EventoDTO> atualizar(@PathVariable Long id, @RequestBody EventoCadastroDTO dto) {
		return ResponseEntity.ok(service.atualizar(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		service.excluir(id);
		return ResponseEntity.noContent().build();
	}

}
