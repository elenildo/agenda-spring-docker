package com.elenildo.agenda_docker.repository;

import com.elenildo.agenda_docker.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    Optional<Contato> findByEmailIgnoreCase(String email);
    boolean existsByEmail(String email);
}
