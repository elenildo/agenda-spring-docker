package com.elenildo.agenda_docker.service;

import com.elenildo.agenda_docker.model.Contato;
import com.elenildo.agenda_docker.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public Contato create(Contato contato) {
        return contatoRepository.save(contato);
    }

    public List<Contato> listAll() {
        return contatoRepository.findAll();
    }
}
