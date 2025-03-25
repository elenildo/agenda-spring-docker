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

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(contatoService.findById(id), HttpStatus.OK);
    }

    @GetMapping("busca")
    public ResponseEntity<?> findByEmail(@RequestParam String email) {
        return new ResponseEntity<>(contatoService.findByEmail(email), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Contato contato) {
        return new ResponseEntity<>(contatoService.update(id, contato), HttpStatus.OK);
    }

}
