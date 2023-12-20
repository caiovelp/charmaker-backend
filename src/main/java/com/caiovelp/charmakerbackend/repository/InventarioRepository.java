package com.caiovelp.charmakerbackend.repository;

import com.caiovelp.charmakerbackend.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    Optional<Inventario> findByPersonagemId(Long personagemId);
}
