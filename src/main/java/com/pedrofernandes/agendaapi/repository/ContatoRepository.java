package com.pedrofernandes.agendaapi.repository;

import com.pedrofernandes.agendaapi.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
