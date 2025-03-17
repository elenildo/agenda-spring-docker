package com.elenildo.agenda_docker.controller;

import com.elenildo.agenda_docker.model.Contato;
import com.elenildo.agenda_docker.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AgendaController {

    private final ContatoService contatoService;

    public AgendaController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<?> index() {
        return new ResponseEntity<>(contatoService.listAll(), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Contato contato) {
        return new ResponseEntity<>(contatoService.create(contato), HttpStatus.OK);
    }
}
