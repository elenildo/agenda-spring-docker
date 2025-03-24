package com.elenildo.agenda_docker.service;

import com.elenildo.agenda_docker.model.Contato;
import com.elenildo.agenda_docker.repository.ContatoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public Contato create(Contato contato) {
        if(contatoRepository.existsByEmail(contato.getEmail().trim()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este e-mail já existe.");

        return contatoRepository.save(contato);
    }

    public List<Contato> listAll() {
        return contatoRepository.findAll();
    }

    public Contato findById(Long id) {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contato não localizado."));
    }

    public Contato findByEmail(String email) {
        return contatoRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contato não localizado."));
    }
}
