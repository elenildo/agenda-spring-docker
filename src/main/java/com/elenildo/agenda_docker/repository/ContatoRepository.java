package com.elenildo.agenda_docker.repository;

import com.elenildo.agenda_docker.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
