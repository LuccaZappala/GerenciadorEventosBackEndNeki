package com.gerenciador.eventos.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gerenciador.eventos.dto.EventoCadastroDTO;
import com.gerenciador.eventos.dto.EventoDTO;
import com.gerenciador.eventos.model.Administrador;
import com.gerenciador.eventos.model.Evento;
import com.gerenciador.eventos.repository.AdministradorRepository;
import com.gerenciador.eventos.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private AdministradorRepository adminRepository;

    public EventoDTO salvar(EventoCadastroDTO dto) {
    	
        Administrador admin = adminRepository.findById(dto.getIdAdministrador())
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado"));

        Evento evento = new Evento();
        evento.setTitulo(dto.getTitulo());
        evento.setData(dto.getData());
        evento.setLocalizacao(dto.getLocalizacao());
        evento.setImagem(dto.getImagem());
        evento.setAdministrador(admin);

        Evento salvo = eventoRepository.save(evento);

        return new EventoDTO(salvo.getId(), salvo.getTitulo(), salvo.getLocalizacao(), 
                             salvo.getData(), salvo.getImagem(), admin.getNome(), admin.getId());
    }

    public List<EventoDTO> listarPorAdmin(Long adminId) {
        return eventoRepository.findByAdministradorId(adminId).stream()
                .map(e -> new EventoDTO(e.getId(), e.getTitulo(), e.getLocalizacao(), 
                                        e.getData(), e.getImagem(), e.getAdministrador().getNome(), e.getAdministrador().getId()))
                .collect(Collectors.toList());
    }
    
    public EventoDTO atualizar(Long id, EventoCadastroDTO dto) {
    	Evento evento = eventoRepository.findById(id)
    			.orElseThrow(( )-> new RuntimeException("Evento não encontrado."));
    	
    	evento.setData(dto.getData());
    	evento.setLocalizacao(dto.getLocalizacao());
    	evento.setTitulo(dto.getTitulo());
    	evento.setImagem(dto.getImagem());
    	
    	Evento atualizado = eventoRepository.save(evento);
    	return new EventoDTO(atualizado.getId(), atualizado.getTitulo(), atualizado.getLocalizacao(),
    			atualizado.getData(), atualizado.getImagem(), atualizado.getAdministrador().getNome(), atualizado.getAdministrador().getId());
    }
    
    public void excluir(Long id) {
    	if(!eventoRepository.existsById(id)) {
    		throw new RuntimeException("Evento não encontrado.");
    	}
    	eventoRepository.deleteById(id);
    }
}